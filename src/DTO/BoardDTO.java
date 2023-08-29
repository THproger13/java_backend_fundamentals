package DTO;

public class BoardDTO {
    private long id;
    private String boardTitle;
    private String boardWriter;
    private String boardContents;
    private String boardPass;
    private long boardHits;

    private static long numId = 1L;
    private static long numHits = 0L;


    //기본생성자
    public BoardDTO(){

    }

    public BoardDTO(String boardTitle,String boardWriter, String boardContents, String boardPass){
        this.id = numId++;
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardContents = boardContents;
        this.boardPass = boardPass;
        this.boardHits = numHits;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    public String getBoardContents() {
        return boardContents;
    }

    public void setBoardContents(String boardContents) {
        this.boardContents = boardContents;
    }

    public String getBoardPass() {
        return boardPass;
    }

    public void setBoardPass(String boardPass) {
        this.boardPass = boardPass;
    }

    public long getBoardHits() {
        return boardHits;
    }

    public void setBoardHits(long boardHits) {
        this.boardHits = boardHits;
    }


    @Override
    public String toString() {
        return "BoardDTO{" +
                "id=" + id +
                ", boardTitle='" + boardTitle + '\'' +
                ", boardWriter='" + boardWriter + '\'' +
                ", boardHits='" + boardHits + '\'' +
                '}';
    }
}
