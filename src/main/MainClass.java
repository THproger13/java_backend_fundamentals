package main;

import service.BoardService;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        BoardService boardService = new BoardService();
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while(run) {
            System.out.println("======게시판=======\n");
            System.out.println("1. 글작성 메뉴 2. 글목록 메뉴 3. 글 조회 메뉴" +
                    " 4. 글 수정 메뉴 5. 글 삭제 메뉴 6. 글 검색 메뉴 7. 샘플 데이터 저장 0. 게시판 종료\n");
            System.out.println("=================\n");
            System.out.println("메뉴를 입력해 주세요 : \n");
            int menu = sc.nextInt();
            switch (menu){
                // 글작성 메뉴
                case 1:
                    System.out.println("글 작성 메뉴");
                    boardService.boardwrite();
                    break;
                    //글 목록 메뉴
                case 2:
                    System.out.println("글 목록 메뉴");
                    boardService.findAll();
                    break;

                //글 조회 메뉴
                case 3:
                    System.out.println("글 조회 메뉴");
                    boardService.check();
                    break;

                    //글 수정 메뉴
                case 4:
                    System.out.println("글 수정 메뉴");
                    boardService.update();
                    break;

                    //글 삭제 메뉴
                case 5:
                    System.out.println("글 삭제 메뉴");
                    boardService.delete();
                    break;

                    //글 검색 메뉴
                case 6:
                    System.out.println("글 검색 메뉴");
                    boardService.search();
                    break;
                case 7:
                    System.out.println("글 샘플데이터 저장");
                    boardService.savesample();
                    break;
                    //게시판 종료
                case 0:
                    System.out.println("게시판을 종료합니다.");
                    run = false;
            }

        }
    }

}
