package co.yedam.board.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.notice.service.NoticeService;
import co.yedam.board.notice.service.NoticeVO;
import co.yedam.board.notice.servicelmpl.NoticeServicelmpl;

public class NoticeInsert implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 저장
		NoticeService noticeDao = new NoticeServicelmpl();
		NoticeVO vo = new NoticeVO();
		vo.setId(request.getParameter("id"));
		vo.setName(request.getParameter("name"));
		//문자열로 넘어오는 writeDate를 date 타입으로 바꿔주는 것 
		vo.setWriteDate(Date.valueOf(request.getParameter("writeDate")));
		vo.setTitle(request.getParameter("title"));
		vo.setContents(request.getParameter("contents"));
		
		int n =noticeDao.noticeInsert(vo);
		String viewPage = null;
		
		if(n != 0 ) {
			viewPage = "noticeList.do"; //정상적으로 등록되면 목록으로 가기 
		}else {
			request.setAttribute("message", "등록이 실패했습니다.");
			viewPage = "notice/noticeFail";
		}
		return viewPage;
	}

}
