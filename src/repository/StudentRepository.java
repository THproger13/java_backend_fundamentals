package repository;

import dto.StudentDTO;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    List<StudentDTO> studentDTOList = new ArrayList<>();
    StudentDTO studentDTO = new StudentDTO();

    public void delete(long id) {
        for (StudentDTO studentDTO : studentDTOList) {
            if (id == studentDTO.getId()) {
                studentDTOList.remove(studentDTO);
            }
        }
    }

    public boolean update(StudentDTO studentDTO) {
        for (StudentDTO StudentDTO : studentDTOList) {
            if (studentDTO.getStudentName().equals(studentDTO.getStudentName())) {
                studentDTO.setStudentMajor(studentDTO.getStudentMajor());
                studentDTO.setStudentMobile(studentDTO.getStudentMobile());
                return true; // 수정 성공 시 true 반환
            }
        }
        return false; // 수정 실패 시 false 반환
    }
    // 학생정보를 저장할 리스트
    /*
     아래에서 선언해준 부분을 살펴 보자.
    List의 경우 인터페이스이고 따라서 List인터페이스를 직접 인스턴스화 할 수 없고
    구체적인 List 구현 클래스를 사용해야 한다. 해당 코드에서 ArrayList는 List인터페이스를
    구현한 클래스중 하나이다.
    */

    public boolean save(StudentDTO studentDTO) {
        // id 값을 하나씩 증가시켜 함께 저장
        // (현재 리스트에 저장된 학생수 가져오고 1증가시켜 저장)
        int size = studentDTOList.size();
        studentDTO.setId((long) (size + 1));
        // 리스트에 신규학생 추가 - return 값은 add()메서드의 시그니처에 의해 boolean형
        // 이 된다.
        return studentDTOList.add(studentDTO);
    }

    public List<StudentDTO> findAll() {
        return studentDTOList;
    }

    public String findById(Long id) {

        StudentDTO foundStudent = null;

        try {
            //foreach문으로 비교
            for (StudentDTO studentDTO : studentDTOList) {
                //id와 일치하는 결과를 찾으면 해당 DTO 객체를 foundstudent변수에 저장한다.
                if (studentDTO.getId().equals(id)) {
                    foundStudent = studentDTO;
                    break;
                }
            }

            if (foundStudent != null) {
                System.out.println("학생 정보 조회 성공");
                System.out.println(id + " 번 학생의 정보: " + foundStudent);
            } else {
                System.out.println("해당 학생을 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("학생 정보 조회 오류: " + e);
        }
        return foundStudent != null ? foundStudent.toString() : "해당 학생을 찾을 수 없습니다.";
    }
}