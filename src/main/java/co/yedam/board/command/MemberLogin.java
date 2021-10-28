package co.yedam.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.prj.member.service.MemberService;
import co.yedam.prj.member.serviceImpl.MemberServiceImpl;
import co.yedam.prj.member.vo.MemberVO;

public class MemberLogin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse respones) {
		// 로그인 과정
		HttpSession session = request.getSession(); //session 객체를 불러온다 
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id")); // 폼에서 입력된 값을 vo 객체에 담음
		vo.setPassword(request.getParameter("password"));

		vo = memberDao.memberLogin(vo);
		String page = null;
		if (vo.getName() != null) {
			// 성공하면 담아서
			session.setAttribute("id", vo.getId()); //session 에 값을 담아 놓는다. 세션을 지우기 전까지 로그인 유지 
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("name", vo.getName());
			page = "member/memberLoginSuccess";
		} else {
			page = "member/memberLoginFail";
		}
		return page;
	}

}
