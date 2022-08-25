import java.util.Scanner;

public class SudokuSolverMain {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

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

        int[][] boardCopy = {
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

        final BoardManager boardManager = new BoardManager(boardCopy);


        boardManager.solve(2);
        //boardManager.print();
        System.out.println("Solve time: "+boardManager.getTime()+"ms");
        System.out.println("Iterations: "+boardManager.getIterations());






    }
}
