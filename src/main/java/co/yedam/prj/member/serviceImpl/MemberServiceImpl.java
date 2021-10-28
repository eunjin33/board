package co.yedam.prj.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.comm.DataSource;
import co.yedam.prj.member.service.MemberService;
import co.yedam.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	//	@Override 키워드를 지우면 독립 메소드가 됨 꼭 쓰기! 
	public List<MemberVO> memberSelectList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO vo;
		String sql = "select * from member";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setAuthor(rs.getString("author"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		String sql = "select*from member where id =?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		int n = 0;
		String sql = "insert into member values(?,?,?,?,?,?)";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getAddress());
			psmt.setString(5, vo.getTel());
			psmt.setString(6, vo.getAuthor());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		String sql = "SELECT*FROM member where id = ? and password = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			//해당하는 행이 하나니까 if 
			//아이디랑 패스워드가 없으면 아이디랑 패스워드만 넘어오고 일치하는 애가 있으면 나머지 값도 가지고 온다
			if(rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setAuthor(rs.getString("author"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public boolean isIdCheck(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void close() { //연결된 Connection을 종료하는 메소드 
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
