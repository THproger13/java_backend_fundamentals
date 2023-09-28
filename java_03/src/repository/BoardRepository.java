package repository;

import DTO.BoardDTO;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    static List<BoardDTO> boardDTOList = new ArrayList<>();

    //게시글 작성
    public static boolean boardWrite(BoardDTO boardDTO) {
        return boardDTOList.add(boardDTO);
    }

    //전체 목록 출력
    public List<BoardDTO> findAll() {
        return new ArrayList<>(boardDTOList);
    }

    //id기준 글 조회하기
    public BoardDTO check(long id) {
        for (BoardDTO board : boardDTOList) {
            if (id == board.getId()) {
                board.setBoardHits(board.getBoardHits() + 1);
                return BoardDTO;
            }else{
                return null;
            }
        }
        return null;
    }

    //id기준 글 수정전 글 id,비밀번호 확인(제목, 내용 수정)
    public boolean validateidboardpass(long id, String boardPass) {

        for (BoardDTO board : boardDTOList) {
            if (id == board.getId() && boardPass.equals(board.getBoardPass())) {
                return true;
            } else if (id == board.getId() && !boardPass.equals(board.getBoardPass())) {
                return false;
            }
        }
        return false;

    }

    public void update(long id, String boardTitle, String boardContents) {
        for (BoardDTO board : boardDTOList) {
            if (id == board.getId()) {
                board.setBoardTitle(boardTitle);
                board.setBoardContents(boardContents);
            }
        }
    }

    public List<BoardDTO> search(String boardTitle) {
        List<BoardDTO> searchList = new ArrayList<>();
        for (BoardDTO board : boardDTOList) {
            if (boardTitle.equals(board.getBoardTitle())) {
                searchList.add(board);
                return searchList;
            }
        }
        return null;
    }
    public void delete(BoardDTO boardDTO){
       boardDTOList.remove(boardDTO);
    }

}
