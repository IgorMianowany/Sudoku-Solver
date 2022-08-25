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
