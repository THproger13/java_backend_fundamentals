package service;

import DTO.BoardDTO;
import repository.BoardRepository;

import java.util.List;
import java.util.Scanner;

public class BoardService {
    Scanner sc = new Scanner(System.in);
    BoardDTO boardDTO = new BoardDTO();
    BoardRepository boardRepository = new BoardRepository();

    //글 작성
    public void boardwrite() {
        System.out.println("글 제목을 입력해주세요! : ");
        String boardTitle = sc.next();

        System.out.println("글 작성자를 입력해주세요! : ");
        String boardWriter = sc.next();

        System.out.println("글 내용을 입력해주세요! : ");
        String boardContents = sc.next();

        System.out.println("비밀번호를 입력해주세요! : ");
        String boardPass = sc.next();

        BoardDTO boardDTO = new BoardDTO(boardTitle, boardWriter, boardContents, boardPass);

        boolean result = BoardRepository.boardWrite(boardDTO);
        System.out.println(result ? "글이 게시되었습니다." : "글 게시를 실패 하였습니다.");
        findAll();

    }

    //글 목록 출력
    public void findAll() {
        List<BoardDTO> boards = boardRepository.findAll();
        for (BoardDTO board : boards) {
            System.out.println(board.toString());
        }
    }

    //id 기준 글을 조회
    public void check() {
        findAll();
        System.out.println("조회할 글 아이디를 입력해주세요! : ");
        long id = sc.nextLong();
        boolean result = boardRepository.check(id);
        if(result){
            System.out.println("boardDTO = " + boardDTO);
        }else{
            System.out.println("요청하신 글이 없습니다.");
        }

    }
//id에 해당하는 글 제목, 글 내용 수정하기
    public void update() {

            System.out.println("수정할 글 아이디를 입력해주세요! : ");
            long id = sc.nextLong();

            System.out.println("수정전 확인을 위해 비밀번호를 입력해주세요! : ");
            String boardPass = sc.next();

            boolean result = boardRepository.validateidboardpass(id, boardPass);
            if(result) {
                System.out.println("수정할 제목을 입력하세요! : ");
                String boardTitle = sc.next();

                System.out.println("수정할 글 내용을 입력하세요! : ");
                String boardContents = sc.next();

                boardRepository.update(id, boardTitle, boardContents);
                System.out.println("글 제목과 글 내용이 수정되었습니다.");
                findAll();
            }else{
                System.out.println("비밀번호가 틀렸습니다.");
            }
        }
    //제목으로 글 검색하기
    public void search() {
        System.out.println("조회할 글 제목을 입력해주세요! : ");
        String boardTitle = sc.next();
        System.out.println(boardRepository.search(boardTitle));

    }
    //글 삭제하기
    public void delete(){
        System.out.println("삭제할 글 아이디를 입력해주세요! : ");
        long id = sc.nextLong();

        System.out.println("삭제전 확인을 위해 비밀번호를 입력해주세요! : ");
        String boardPass = sc.next();

        boolean result = boardRepository.validateidboardpass(id, boardPass);
        if(result) {
            boardRepository.delete(boardDTO);
            System.out.println(id +  "번 글이 삭제되었습니다.");
            findAll();
        }else{
            System.out.println("비밀번호가 틀렸습니다.");
        }
    }

    public void savesample() {
        for(int i = 1; i<=10; i++){
            BoardDTO boardDTO =
            new BoardDTO("title"+i,"writer"+i,"contents"+i,"pass"+i);
            BoardRepository.boardWrite(boardDTO);
        }
        System.out.println("샘플데이터가 저장되었습니다.");
        findAll();
    }
}
