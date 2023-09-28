package ex04;

import java.util.*;

public class Juso {
	
	
	public static void run() {
		
	boolean run = true;	
	
	List<Student> array = new ArrayList<>();
	
	Student Juso = new  Student(1, "홍길동", "인천시 부평구","010-9884-2382");
	array.add(Juso);
	
	Juso = new  Student(2, "김태훈", "인천시 연수구","010-5499-4587");
	array.add(Juso);
	
	Juso = new  Student(3, "이순신", "인천시 계양구","010-6598-2154");
	array.add(Juso);
	
	int last = 3;
	
		while(run) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\n==================================");
			System.out.println("1. 등록 2. 목록 3. 조회 4. 수정 5.삭제 0.종료");
			System.out.println("==================================");
			System.out.print("메뉴를 입력해주세요. : ");
			
			String menu = sc.nextLine();
			
			switch(menu) {
			
			case "1":
				Student newStu = new Student();
				//Integer.parseInt(sc.nextLine());
				newStu.setNo(++last);
				System.out.println("학번 : " + ++last);
				
				
				System.out.print("등록할 이름을 입력 : ");
				newStu.setName(sc.nextLine()); 
				
				System.out.println("등록할 주소를 입력 : ");
				newStu.setAddress(sc.nextLine()); 

				System.out.println("등록할 전화번호를 입력 : ");
				newStu.setPhoneNum(sc.nextLine()); 
				
				array.add(newStu);
				
				System.out.println("등록된 전체 학생수 : " + array.size());

				
				break;
				
			case "2":
				for(Student stu : array) {
					
					System.out.printf("%d\t%s\t%s\t%s\n", stu.getNo(),stu.getName(), stu.getAddress(), stu.getPhoneNum()); 
				}
				break;
				
			case "3":
				
				System.out.println("조회할 학번을 입력해주세요: ");
				
				String search = sc.nextLine();
				
				for(Student stu : array) {
					if(stu.getNo()== Integer.parseInt(search)) {
						System.out.println("이름 : " + stu.getName());
						System.out.println("주소 : " + stu.getAddress());
						System.out.println("전화번호 : " + stu.getPhoneNum());

					}
				}
				break;
				
			case "4":
				System.out.println("수정할 학번을 입력해주세요: ");
				
				String change = sc.nextLine();
				
				for(Student stu : array) {
					if(stu.getNo()== Integer.parseInt(change)) {
						System.out.print("수정할 이름 : " + stu.getName() +"->");
						stu.setName(sc.nextLine());
						System.out.println(stu.getName() + "로 이름이 변경되엇습니다."); 
						
						System.out.print("수정할 주소 : " + stu.getAddress() +"->");
						stu.setAddress(sc.nextLine());
						System.out.println(stu.getAddress() + "로 주소가 변경되엇습니다."); 

						System.out.print("수정할 전화번호 : " + stu.getPhoneNum() +"->");
						stu.setPhoneNum(sc.nextLine());
						System.out.println(stu.getPhoneNum() + "로 전화번호가 변경되엇습니다."); 
						
						System.out.println( stu.getName()+ "의 정보가 변경되었습니다. ");
						
						System.out.println(stu.toString());
					}
				}
				
				break;
				
			case "5":
				System.out.println("삭제할 학번을 입력해주세요: ");
				
				String delete = sc.nextLine();
				
				for(Student stu : array) {
					if(stu.getNo()== Integer.parseInt(delete)) {
						array.remove(stu);
						System.out.println(stu.getName()+ "학생 삭제 완료!");
						break;
					}
				}
				break;
				
			case "0":
				run = false;
				System.out.println("프로그램을 종료합니다. ");
				
				break;
			default:
				System.out.println("0부터 5까지 입력해주세요");
			}
			
		}//while에 대한 괄호
		
	}//run

}//Juso클랴스
