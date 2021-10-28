package co.yedam.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogout implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃
		HttpSession session = request.getSession();
		session.invalidate(); //session 지워주는 것 
		
		return "home.do";
	}

}
