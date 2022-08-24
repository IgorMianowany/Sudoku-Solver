import java.util.Scanner;
import java.util.stream.IntStream;

public class BoardManager {
    private long time;
    private final AbstractAlgorithm backtrackingAlgorithm;
    private final AbstractAlgorithm currentAlgorithm;


    public BoardManager(int[][] board) {
        backtrackingAlgorithm = new BacktrackingAlgorithm(board);
        currentAlgorithm = backtrackingAlgorithm;
    }

    public void solve(int choice) {
        long start = System.currentTimeMillis();
        switch (choice){
            case 1 -> backtrackingAlgorithm.solve();
        }
        time = System.currentTimeMillis() - start;
    }

    public long getTime() {
        return time;
    }

    public void print(){
        currentAlgorithm.print();
    }

}
