package co.yedam.board.notice.service;

import java.util.List;

public interface NoticeService {
	List<NoticeVO> noticeSelectList(); //글 전체 목록
	NoticeVO noticeSelect(NoticeVO vo);	//글 하나 읽기
	int noticeInsert(NoticeVO vo);	//글 추가
	int noticeUpdate(NoticeVO vo);	//글 수정
	int noticeDelete(NoticeVO vo);	//글 삭제
	
}
