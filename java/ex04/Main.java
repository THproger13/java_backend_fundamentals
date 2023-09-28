package ex04;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDAO dao = new StudentDAO();
		
		//조회
		//System.out.println(dao.read(1));
		
		//입력
		//Student stu = new Student(20,"김태훈", "인천","010-8865-7126" );
		//dao.insert(stu);
		
		//수정
		Student stu = new Student(2,"강감찬", "서울","010-0000-0000" );
		dao.update(stu);
		
		
		//dao.delete(3);
		
		//목록출력
		for(Student vo: dao.list()) {
			System.out.println(vo.toString());
	
		}	
		
		//Juso.run();		
		//Database.connect();
		
		
	}

}
