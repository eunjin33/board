package co.yedam.board.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.prj.member.service.MemberService;
import co.yedam.prj.member.serviceImpl.MemberServiceImpl;
import co.yedam.prj.member.vo.MemberVO;

public class MemberSelectList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse respones) {
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> list = new ArrayList<MemberVO>();
		//dao 연걸해서 가지고 온다
		list = dao.memberSelectList();
		 
		
		request.setAttribute("members", list); //넘오온 닶을 보여줄 페이지에 전달하기 위해서 request 객체에 담는다
		return "member/memberSelectList";
	}

}
