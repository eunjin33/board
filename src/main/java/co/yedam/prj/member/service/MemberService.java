package co.yedam.prj.member.service;

import java.util.List;

import co.yedam.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);	//전체 리스트 불러오기
	int memberInsert(MemberVO vo);	//내용 넣기
	int memberUpdate(MemberVO vo);	//내용 수정하기
	int memberDelete(MemberVO vo);	//내용 삭제하기
	
	//로그인 기능을 넣을 메소드 
	MemberVO memberLogin(MemberVO vo);
	//아이디 값을 받아서 있는지 확인
	boolean isIdCheck(String id);
	
}
