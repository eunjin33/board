package co.yedam.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.yedam.prj.member.service.MemberService;
import co.yedam.prj.member.serviceImpl.MemberServiceImpl;
import co.yedam.prj.member.vo.MemberVO;

public class MemberLoginform implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse respones) {
		
		return "member/memberLoginForm";
	}

}
