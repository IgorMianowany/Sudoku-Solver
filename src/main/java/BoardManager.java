public class BoardManager {
    private long time;
    private final AbstractAlgorithm backtrackingAlgorithm;
    private final AbstractAlgorithm dancingLinksAlgorithm;
    private AbstractAlgorithm currentAlgorithm;


    public BoardManager(int[][] board) {
        backtrackingAlgorithm = new BacktrackingAlgorithm(board);
        dancingLinksAlgorithm = new DancingLinksAlgorithm(board);
        currentAlgorithm = backtrackingAlgorithm;
    }

    public void solve(int choice) {
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
