import abstraction.AbstractAlgorithm;
import algorithmX.DancingLinksAlgorithm;
import backtrackingAlgorithm.BacktrackingAlgorithm;
import wavefunctioncollapse.WaveFunctionCollapseAlgorithm;

public class BoardManager {
    private long time;
    private final AbstractAlgorithm backtrackingAlgorithm;
    private final AbstractAlgorithm dancingLinksAlgorithm;
    private final AbstractAlgorithm waveFunctionCollapseAlgorithm;
    private AbstractAlgorithm currentAlgorithm;


    public BoardManager(int[][] board) {
        backtrackingAlgorithm = new BacktrackingAlgorithm(board);
        dancingLinksAlgorithm = new DancingLinksAlgorithm(board);
        waveFunctionCollapseAlgorithm = new WaveFunctionCollapseAlgorithm(board);
        currentAlgorithm = backtrackingAlgorithm;
    }

    public int[][] solve(int choice) {
        long start = System.currentTimeMillis();
        switch (choice){
            case 1 -> {
                currentAlgorithm = backtrackingAlgorithm;
                backtrackingAlgorithm.solve();
            }
            case 2 -> {
                currentAlgorithm = dancingLinksAlgorithm;
                dancingLinksAlgorithm.solve();
            }
            case 3 -> {
                currentAlgorithm = waveFunctionCollapseAlgorithm;
                waveFunctionCollapseAlgorithm.print();
            }
        }
        time = System.currentTimeMillis() - start;
        return currentAlgorithm.getBoard();
    }

    public String boardToString(int[][] board){



       // return board;
        return null;
    }

    public long getTime() {
        return time;
    }

    public int getIterations() {
        return backtrackingAlgorithm.getIterations();
    }

    public void print(){
        currentAlgorithm.print();
    }

}
