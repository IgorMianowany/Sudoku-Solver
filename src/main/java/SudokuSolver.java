public class SudokuSolver {
    private final int[][] board;
    private final BoardManager boardManager;

    public SudokuSolver(int[][] board) {
        this.board = board;
        this.boardManager = new BoardManager(board);
    }

    public int[][] solveBoardWithBacktracking(int[][] board){
        return boardManager.solve(1);
    }
}
