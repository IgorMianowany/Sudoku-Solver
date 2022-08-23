
public class SudokuSolver {

    public static void main(String[] args) {
        final int[][] board = {
                { 3, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 1, 0, 8, 4, 0, 5, 0 },
                { 0, 0, 0, 0, 6, 0, 0, 0, 0 },
                { 0, 0, 0, 3, 0, 0, 0, 2, 0 },
                { 0, 0, 4, 6, 0, 0, 0, 0, 0 },
                { 9, 0, 0, 0, 4, 2, 0, 0, 8 },
                { 0, 0, 0, 2, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 0, 0, 0, 0, 9 },
                { 0, 0, 3, 0, 1, 5, 0, 8, 0 }
        };

        final BoardManager boardManager = new BoardManager(board);
        System.out.println("BEFORE SOLVE: ");
        boardManager.print(board);
        System.out.println("AFTER SOLVE: ");
        boardManager.solve(board);
        boardManager.print(board);






    }
}
