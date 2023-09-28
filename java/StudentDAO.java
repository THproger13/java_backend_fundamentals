package ex05;

import java.sql.*;
import java.util.*;
import java.sql.Date;

public class StudentDAO {
	Connection con = Database.connect();
	
	// 학생수정
	public void update(StudentVO vo) {
		try {
			String sql = "update students set sname=?, dept=?, birthday=?, year=? where sno=?";
			PreparedStatement ps = con.prepareStatement(sql);//sql문을 넣어주는 문법
			ps.setString(1, vo.getSname());
			ps.setString(2, vo.getDept());
			ps.setString(3, vo.getBirthday());
			ps.setInt(4, vo.getYear());
			ps.setString(5, vo.getSno());
			ps.execute();
			
		}catch(Exception e) {
			System.out.println("학생수정 : " + e.toString());
		}
	}
	// 학생삭제
	public void delete(String sno) {
		try {
			String sql = "delete from students where sno=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sno);
			ps.execute();
		}catch(Exception e) {
			System.out.println("학생삭제 : " + e.toString());
		}
	}
	
	// 학생조회
	public StudentVO read(String sno) {
		StudentVO vo = new StudentVO();
		try {
			String sql = "SELECT * from students where sno=?";
			PreparedStatement ps = con.prepareStatement(sql); 
			ps.setString(1, sno);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) { 				 
				vo.setSno(rs.getString("sno")); 
				vo.setSname(rs.getString("sname"));
				vo.setDept(rs.getString("dept"));
				vo.setBirthday(rs.getString("birthday"));
				vo.setYear(rs.getInt("year")); 
			}
		}catch(Exception e) {
			System.out.println("학생조회 : " + e.toString());
		}
		return vo;
	}
	
	// 학생입력
	public void insert(StudentVO vo) {
		try {
			String sql = "insert into students(sno, sname, dept, birthday) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);//sql문을 넣어주는 문법
			ps.setString(1, vo.getSno());
			ps.setString(2, vo.getSname());
			ps.setString(3, vo.getDept());
			ps.setString(4, vo.getBirthday());
			ps.execute();
			
		}catch(Exception e) {
			System.out.println("학생입력 : " + e.toString());
		}
	}
	
	// 새로운 학번 구하기
	public String getNo() {
		String no = "";
		try {
			String sql = "select max(sno)+1 no from students ";
			PreparedStatement ps = con.prepareStatement(sql); // sql문을 넣어주는 문법
			ResultSet rs = ps.executeQuery(); // sql(Query)를 실행하라/실행결과를 rs에 넣어라
			if(rs.next()) { // rs안에 있는 데이터를 하나씩 가져와라 없어지면 반복문 종료
				no = rs.getString("no");
			}
		}catch(Exception e) {
			System.out.println("새로운 학번구하기 : " + e.toString());
		}
		return no;
		
	}
	
	// 학생목록 
	public List<StudentVO> list(){
		List<StudentVO> array = new ArrayList<StudentVO>();
		try {
			String sql = "select * from students ";
			PreparedStatement ps = con.prepareStatement(sql); //sql문을 넣어주는 문법
			ResultSet rs = ps.executeQuery(); // sql(Query)를 실행하라/실행결과를 rs에 넣어라
			while(rs.next()) { // rs안에 있는 데이터를 하나씩 가져와라 없어지면 반복문 종료
				StudentVO vo = new StudentVO(); //array이에 넣어주기 위에 vo를 새로 만들어서 여기다 넣어준다.
				vo.setSno(rs.getString("sno")); // vo에 컬럼에 있는 값을 가져와서 세팅해준다. 컬럼명은 틀리면 안됌
				vo.setSname(rs.getString("sname"));
				vo.setDept(rs.getString("dept"));
				vo.setBirthday(rs.getString("birthday"));
				vo.setYear(rs.getInt("year"));
				array.add(vo); //세팅된 값을 array에 리턴해줘야하기 때문에 추가해준다.
			}
		}catch(Exception e) {
			System.out.println("학생목록 : " + e.toString());
		}
		return array;
	}
}