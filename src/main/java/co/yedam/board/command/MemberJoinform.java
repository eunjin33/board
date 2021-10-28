package co.yedam.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberJoinform implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 폼
		
		return "member/memberJoinForm";
	}

}
