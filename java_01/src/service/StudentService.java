package service;

import dto.StudentDTO;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 StudentService 클래스의 경우 백엔드의 데이터들을 원하는대로 조작을 하는 기능을 구현하는 부분이다.
 아래의 코드를 보면 키보드로부터 입력받은 데이터들을 dto클래스의 필드값을 변경하는데 사용이 된다.
 언뜻보면 StudentRepository의 id값에 대한 구현도 StudentService 클래스에서 해줘야 할것 같다.
 하지만 id의 경우 학생의 데이터들(이름, 전공, 전화번호)을 입력만 해주고 해당 데이터들이 추가적으로 입력될
 때마다 '자동으로' 1씩 증가하여 할당을 시키는 구조이므로 데이터자체를 저장하는 용도로 구현된 기능들만
 따로 StudentRepository에 구현을 해주었다.*/

public class StudentService {
    List<StudentDTO> studentDTOList = new ArrayList<>();

    StudentRepository studentRepository = new StudentRepository();
    // 학생 정보 삭제
    public void delete() {
        findAll();
        Scanner scanner = new Scanner(System.in);
        StudentRepository studentRepository = new StudentRepository();

        System.out.println("삭제할 학생 id를 입력 하세요 : ");
        long id = scanner.nextLong();
        studentRepository.delete(id);
    }


    // 학생 정보 수정
    public void update() {
        //수정전에 학생 전체 리스트를 가져온다.
        findAll();
        Scanner scanner = new Scanner(System.in);
        StudentDTO studentDTO = new StudentDTO();

        System.out.print("수정할 학생 이름(수정 기준)을 입력하세요: ");
        String studentName = scanner.next();
        if(!studentName.isEmpty()) {
            studentDTO.setStudentName(studentName);
        }
        System.out.print("수정할 학생 전공을 입력하세요: ");
        String studentMajor = scanner.next();
        if (!studentMajor.isEmpty()) {
            studentDTO.setStudentMajor(studentMajor);
        }

        System.out.print("수정할 학생 전화 번호를 입력하세요: ");
        String studentMobile = scanner.next();
        if (!studentMobile.isEmpty()) {
            studentDTO.setStudentMobile(studentMobile);
        }

        boolean result = studentRepository.update(studentDTO);
        // repository의 save() 내용
        // 넘겨받은 dto 객체를 리스트에 추가하고 추가하면 true 리턴
        if (result) {
            System.out.println("수정 성공");
        } else {
            System.out.println("수정 실패");
        }
        findAll();
    }
    public void findById() {
        //조회기능 선택시 목록을 미리 먼저 보여줌
        // 서비스 클래스에서 정의한 findAll() 메서드 호출
        findAll();
        //조회할 아이디 입력 받기
        Scanner scanner = new Scanner(System.in);
        System.out.print("검색할 학생 id를 입력하세요: ");
        Long id = Long.valueOf(scanner.next());
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentRepository.findById(id);
    }

    // 학생등록 메서드
    // 매개변수 없음.
    // 리턴 없음.
    // 메서드 이름: save()
    // 실행내용
    // 스캐너로 이름(studentName), 학과(studentMajor), 전화번호(studentMobile)를 입력받고
    // 입력값을 DTO객체에 담아서 StudentRepository의 save() 메서드로 전달

    public void save() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름: ");
        String studentName = scanner.next();
        System.out.println("학과: ");
        String studentMajor = scanner.next();
        System.out.println("전화 번호: ");
        String studentMobile = scanner.next();
        // DTO 객체
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName(studentName);
        studentDTO.setStudentMajor(studentMajor);
        studentDTO.setStudentMobile(studentMobile);

        /* DTO 객체를 StudentRepository의 save() 메서드로 전달하여 리턴을 boolean으로 받음.
        save()메서드의 리턴값이 boolean형이 될 수 있는 이유는 List인터페이스의 메서드인
         add 메서드의 선언에서 반환 타입이 boolean으로 지정 되어있기 때문에 필연적인 것이다.
            - 메서드의 선언이란 :  메소드를 유일하게 식별하는 정보를 나타내는 것을 말한다.
             메소드의 시그니처는 메소드의 이름, 매개변수의 타입 및 개수를 포함한다.
             이 정보를 통해 컴파일러나 런타임 환경(컴퓨터의 자원을 사용하여,
             여러가지 트랜젝션, 스케쥴링을 관리)이 메소드를 구별하고 호출할 수 있다.
        */
        boolean result = studentRepository.save(studentDTO);
        // repository의 save() 내용
        // 넘겨받은 dto 객체를 리스트에 추가하고 추가하면 true 리턴
        if (result) {
            System.out.println("등록 성공");
            System.out.println(studentRepository.findAll());
        } else {
            System.out.println("등록 실패");
        }
    }
    /*
        findAll() 메서드
        Main에서 3번 선택시 호출되는 메서드
        매개변수 리턴 없음.
        실행내용
          - Repository의 findAll 메서드를 호출하여 리스트를 리턴받음.
          - 리턴받은 리스트에 담긴 데이터를 for문을 이용하여 출력함.
     */

    public void findAll() {
        // - Repository의 findAll 메서드를 호출하여 리스트를 리턴받음.
        List<StudentDTO> studentDTOList = studentRepository.findAll();
        // 1. foreach문으로 구현
        for (StudentDTO studentDTO: studentDTOList) {
            System.out.println("studentDTO = " + studentDTO);
        }
        // 1. for문으로 구현

//        for (int i=0; i<studentDTOList.size(); i++) {
//            System.out.println(studentDTOList.get(i));
//        }
    }



}