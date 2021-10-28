package co.yedam.board.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.notice.service.NoticeService;
import co.yedam.board.notice.service.NoticeVO;
import co.yedam.board.notice.servicelmpl.NoticeServicelmpl;

public class NoticeList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 목록
		NoticeService noticeDao = new NoticeServicelmpl();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		list = noticeDao.noticeSelectList();
		request.setAttribute("notices", list); //결과를 담아둔다
		
				
		return "notice/noticeList";
	}

}
