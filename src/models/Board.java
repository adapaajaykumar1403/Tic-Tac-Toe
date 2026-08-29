package models;

public class Board {
    private int boardId;
    private char[][] board;
    private int [] rowArr;
    private int[] colArr;
    private int diag;
    private int antiDiag;

    public Board(int boardId){
        this.boardId = boardId;
        this.board = new char[3][3];
        this.rowArr = new int[3];
        this.colArr = new int[3];
        this.diag = 0;
        this.antiDiag = 0;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public int[] getRowArr() {
        return rowArr;
    }

    public void setRowArr(int[] rowArr) {
        this.rowArr = rowArr;
    }

    public int[] getColArr() {
        return colArr;
    }

    public void setColArr(int[] colArr) {
        this.colArr = colArr;
    }

    public int getDiag() {
        return diag;
    }

    public void setDiag(int diag) {
        this.diag = diag;
    }

    public int getAntiDiag() {
        return antiDiag;
    }

    public void setAntiDiag(int antiDiag) {
        this.antiDiag = antiDiag;
    }
}
