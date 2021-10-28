package co.yedam.board.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.command.Command;
import co.yedam.board.command.HomeCommand;
import co.yedam.board.command.MemberJoin;
import co.yedam.board.command.MemberJoinform;
import co.yedam.board.command.MemberLogin;
import co.yedam.board.command.MemberLoginform;
import co.yedam.board.command.MemberLogout;
import co.yedam.board.command.MemberSelect;
import co.yedam.board.command.MemberSelectList;
import co.yedam.board.command.NoticeDelete;
import co.yedam.board.command.NoticeForm;
import co.yedam.board.command.NoticeInsert;
import co.yedam.board.command.NoticeList;
import co.yedam.board.command.NoticeSelect;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String,Command> map = new HashMap<String,Command>();

	public FrontController() {
		super();
	
	}


	public void init(ServletConfig config) throws ServletException {
		//수행할 command(명령)를 넣어 두는 곳
		map.put("/home.do", new HomeCommand());  //홈
		map.put("/noticeList.do", new NoticeList()); //공지사항 목록
		map.put("/noticeSelect.do", new NoticeSelect()); //세부내역보기
		map.put("/noticeForm.do", new NoticeForm()); //게시글 입력 폼
		map.put("/noticeInsert.do", new NoticeInsert()); //게시글 등록 폼
		map.put("/noticeDelete.do", new NoticeDelete()); //게시글 삭제 폼
		
		map.put("/memberSelectList.do", new MemberSelectList()); //멤버 목록
		map.put("/memberLoginform.do", new MemberLoginform()); //로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); //로그인 처리 과정 
		map.put("/memberLogout.do", new MemberLogout()); //로그아웃
		map.put("/memberJoinform.do", new MemberJoinform());//회원가입
		map.put("/memberJoin.do", new MemberJoin()); //회원가입 처리
		map.put("/memberSelect.do", new MemberSelect()); //로그인한 회원 한명 조회
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//요청을 분석하고, 수행할 command를 찾아 실행하고 결과를 보여줄 페이지를 선택한다 
		request.setCharacterEncoding("UTF-8"); 
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.run(request, response);
		
		if(!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		RequestDispatcher dispatcher =request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
