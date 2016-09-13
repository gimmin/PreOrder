package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.Board;
import board.BoardCommand;
import dao.DaoBoard;
import login.AuthInfo;



@Controller
public class ControllerBoard {
	private DaoBoard daoBoard;
	
	public void setDaoBoard(DaoBoard daoBoard) {
		this.daoBoard = daoBoard;
	}

	@RequestMapping(value="/BoardList")
	public String list(BoardCommand boardCommand, Model model) {
		List<Board> boards = daoBoard.getAll();
		model.addAttribute("boards", boards);
		return "/main";
	}
	@RequestMapping(value="/writeBoard", method=RequestMethod.POST)
	public String writeBoard(BoardCommand boardCommand, HttpSession session, HttpServletRequest request, Model model) throws IOException{
		//DB에 넣을 이메일, 이름 얻기
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		boardCommand.setEmail(authInfo.getEmail());
		boardCommand.setOwner(authInfo.getName());
		
		//업로드 파일 설정 업로드할 경로 정하기
		ServletContext context = request.getSession().getServletContext();

		String realPath = context.getRealPath("/")+"upload";
		//파일 크기 설정
		int maxSize = 10*1024*1024;
		//type설정
		String encType = "UTF-8";
		//파일이름이 같으면 뒤에 숫자 붙이기
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		//파일 업로드
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, encType, policy);
		//DB에 넣을 파일 이름 구하기
		if(multi.getFile("file") != null){
			File file = multi.getFile("file");
			boardCommand.setFile(file.getName());
		}
		//DB에 넣을 게시판 글 구하기
		boardCommand.setContents(multi.getParameter("contents"));
		//DB삽입
		daoBoard.insertBoard(boardCommand);
		
		
		List<Board> boards = daoBoard.getAll();
		model.addAttribute("boards", boards);
		return "main";
	}
}
