package models;

public class GameBoard {
    private int boardId;
    private char[][] board;
    private int [] rowArr;
    private int[] colArr;
    private int diag;
    private int antiDiag;


    public GameBoard(int boardId){
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

    public boolean isValidMove(int x, int y){
        char[][] board = this.board;
        if(x<0 || x>2 || y<0 || y>2 || board[x][y] == 'X' || board[x][y] =='O'){
            return false;
        }
        return true;
    }
    public boolean validateMove(int turn, int x, int y){

        char ch = (turn == 1) ? 'X' : 'O';
        int val = (ch == 'X') ? 1 : -1;
        this.board[x][y] = ch;
        this.rowArr[x] = rowArr[x] + val;
        this.colArr[y] = colArr[y] + val;
        if(x == y){
            this.diag += val;
        }
        if(x+y == 2){
            this.antiDiag += val;
        }
        return rowArr[x] == 3 || rowArr[x] == -3 ||
                colArr[y] == 3 || colArr[y] == -3 ||
                diag == 3 || diag == -3 ||
                antiDiag == 3 || antiDiag == -3;
    }
    public char getCell(int x, int y){
        return this.board[x][y];
    }
}
