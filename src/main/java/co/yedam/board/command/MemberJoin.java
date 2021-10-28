package co.yedam.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.prj.member.service.MemberService;
import co.yedam.prj.member.serviceImpl.MemberServiceImpl;
import co.yedam.prj.member.vo.MemberVO;

public class MemberJoin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 처리
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setAddress(request.getParameter("address"));
		vo.setTel(request.getParameter("tel"));
		vo.setAuthor(request.getParameter("author"));
		
		//인서트는 인티저로 리턴?
		int n = memberDao.memberInsert(vo);
		String viewPage = null;
		if(n != 0) {
			request.setAttribute("message", "회원가입에 성공하였습니다.");
			viewPage = "member/memberJoinSuccess";
			
		}else {
			request.setAttribute("message", "회원가입에 실패하였습니다.");
			viewPage = "member/memberFail";
		}
		return viewPage;
	}

}
