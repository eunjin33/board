package co.yedam.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.notice.service.NoticeService;
import co.yedam.board.notice.service.NoticeVO;
import co.yedam.board.notice.servicelmpl.NoticeServicelmpl;

public class NoticeSelect implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//하나의 게시글을 조회한다 세부내용 보기
		NoticeService noticeDao = new NoticeServicelmpl();
		NoticeVO vo = new NoticeVO();
		//캡슐화 시키는 것
		vo.setnId(Integer.valueOf(request.getParameter("nid")));
		vo = noticeDao.noticeSelect(vo);
		request.setAttribute("notice", vo);
		
		return "notice/noticeSelect";
	}

}
