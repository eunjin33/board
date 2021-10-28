package co.yedam.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.prj.member.service.MemberService;
import co.yedam.prj.member.serviceImpl.MemberServiceImpl;
import co.yedam.prj.member.vo.MemberVO;

public class MemberSelect implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//회원 한명만 조회하기
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		vo.setId(request.getParameter("id"));
		vo = memberDao.memberSelect(vo);
		request.setAttribute("member", vo);
		
		return "member/memberSelect";
	}

}
