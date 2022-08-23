
public class SudokuSolver {

    public static void main(String[] args) {
        final int[][] board9x9 = {
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

        final BoardManager boardManager = new BoardManager(board9x9);
        System.out.println("INPUT:");
        boardManager.print();
        System.out.println("OUTPUT:");
        boardManager.solve();
        boardManager.print();
        System.out.println("Solve time: "+boardManager.getTime()+"ms");






    }
}
