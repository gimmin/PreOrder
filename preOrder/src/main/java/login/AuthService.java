package login;

import dao.DaoMember;
import exception.IdPasswordNotMatchingException;
import exception.MemberNotFoundException;
import member.Member;

public class AuthService {
	private DaoMember daoMember;
	
	public void setDaoMember(DaoMember daoMember) {
		this.daoMember = daoMember;
	}

	public AuthInfo authenticate(String email, String password){
		Member member = daoMember.selectByEmail(email);
		if(member == null){
			throw new MemberNotFoundException();
		}
		if(!member.matchPassword(password)){
			throw new IdPasswordNotMatchingException();
		}
		return new 
			AuthInfo(member.getId(), member.getEmail(), member.getName());
	}
}
