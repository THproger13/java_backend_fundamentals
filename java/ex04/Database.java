package ex04;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	//해당 클래스는 나중에 복붙해서 사용한다. 유저네임과 패스워드만 바꿔서 사용가능
	
	public static Connection connect() {
	
		Connection con = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "java";
		String password = "pass";
		
		//오류 발생시 오류원인을 보여준다 
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user, password);
			System.out.println("접속성공"); 
			
		}catch(Exception e) {
			System.out.println("DB연결: " + e.toString());
		}
		return con;
		
		
		
	}
	
	
}
