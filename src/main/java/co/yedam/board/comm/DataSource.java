package co.yedam.board.comm;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	//자기 자신으로 변수 선언
	private static DataSource dataSource;
	private String driver;
	private String url;
	private String user;
	private String password;
	private Connection conn;
	
	//생성자 하나 만들어주기
	private DataSource() {
		//생성하면서 아래 메소드를 읽어라 
		getProperties();  //외부에 있는 데이버베이스 정보를 가져온다
	}
	//기본적인 싱글톤 패턴 
	public static DataSource getInstance() {
		dataSource = new DataSource();
		return dataSource;
	}
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("데이터베이스 연결 실패");
			e.printStackTrace();
		}
		return conn;
	}
	//db 연결하는 부분 
	private void getProperties() {
		String resource = "/db.properties";
		Properties properties = new Properties();
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resource);
			properties.load(inputStream);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
