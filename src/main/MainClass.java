package main;

import service.StudentService;

import java.util.Scanner;

public class MainClass {
    // 스캐너를 이용하여
    // 1. 학생 등록
    // 2. 학생 상세 조회
    // 3. 학생 목록 조회
    // 4. 학생 정보 수정
    // 5. 학생 정보 삭제
    // 를 선택하는 코드를 작성합시다.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();
        boolean run = true;
        while (run) {
            System.out.println("====== 학생 관리 ======");
            System.out.println("1.학생 등록 2.학생 조회 3.학생 목록 4.정보 수정 5.삭제 0.종료");
            System.out.println("선택>  ");
            int sel = scanner.nextInt();
            if (sel == 1) {
                System.out.println("학생 등록 메뉴");
                studentService.save();
            } else if (sel == 2) {
                 /*
                    service 의 findById 메서드를 호출함.

                    service의 findById 구현
                    - id값을 입력받고 repository의 findById로 id값을 넘김
                    - 입력받은 id에 해당하는 학생 데이터를 리턴받음.
                    - 리턴받은 값을 출력함.
                 */
                System.out.println("학생 조회 메뉴");
                studentService.findById();

            } else if (sel == 3) {
                System.out.println("학생 목록 메뉴");
                studentService.findAll();
            } else if (sel == 4) {
                System.out.println("학생 수정 메뉴");
                studentService.update();
            } else if (sel == 5) {
                System.out.println("학생 삭제 메뉴");
                studentService.delete();
            } else if (sel == 0) {
                System.out.println("종료");
                break;
            }
        }
    }
}