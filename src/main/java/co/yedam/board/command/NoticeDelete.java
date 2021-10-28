package co.yedam.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.notice.service.NoticeService;
import co.yedam.board.notice.service.NoticeVO;
import co.yedam.board.notice.servicelmpl.NoticeServicelmpl;

public class NoticeDelete implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 삭제
		NoticeService noticeDao = new NoticeServicelmpl();
		NoticeVO vo = new NoticeVO();
		vo.setnId(Integer.valueOf(request.getParameter("nId"))); //폼에 있는 네임 이름이랑 똑같이
		int n = noticeDao.noticeDelete(vo);
		String viewPage = null;
		if(n != 0) {
			viewPage = "noticeList.do";
		}else {
			request.setAttribute("message", "삭제를 실패하였습니다.");
			viewPage = "notice/noticeFail";
		}
		return viewPage;
	}

}
