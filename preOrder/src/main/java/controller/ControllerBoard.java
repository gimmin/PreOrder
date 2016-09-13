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
		//DB�� ���� �̸���, �̸� ���
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		boardCommand.setEmail(authInfo.getEmail());
		boardCommand.setOwner(authInfo.getName());
		
		//���ε� ���� ���� ���ε��� ��� ���ϱ�
		ServletContext context = request.getSession().getServletContext();

		String realPath = context.getRealPath("/")+"upload";
		//���� ũ�� ����
		int maxSize = 10*1024*1024;
		//type����
		String encType = "UTF-8";
		//�����̸��� ������ �ڿ� ���� ���̱�
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		//���� ���ε�
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, encType, policy);
		//DB�� ���� ���� �̸� ���ϱ�
		if(multi.getFile("file") != null){
			File file = multi.getFile("file");
			boardCommand.setFile(file.getName());
		}
		//DB�� ���� �Խ��� �� ���ϱ�
		boardCommand.setContents(multi.getParameter("contents"));
		//DB����
		daoBoard.insertBoard(boardCommand);
		
		
		List<Board> boards = daoBoard.getAll();
		model.addAttribute("boards", boards);
		return "main";
	}
}
