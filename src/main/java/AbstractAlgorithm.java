public class AbstractAlgorithm implements Algorithm {
    private final int startIndex = 0;
    private final int noValue = 0;
    private final int minValue = 1;
    private final int maxValue = 9;
    private final int subsectionSize = 3;
    private final int boardSize;
    private final int[][] board;

    public AbstractAlgorithm(int[][] board) {
        this.board = board;
        this.boardSize = board.length;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getNoValue() {
        return noValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getSubsectionSize() {
        return subsectionSize;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int[][] getBoard() {
        return board;
    }

    @Override
    public boolean solve() {
        return false;
    }

    @Override
    public void print() {
        for(int row = getStartIndex(); row < getBoardSize(); row++){
            for(int column = getStartIndex(); column < getBoardSize(); column++){
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void print(int[][] board) {
        for(int row = getStartIndex(); row < getBoardSize(); row++){
            for(int column = getStartIndex(); column < getBoardSize(); column++){
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void print(int row, int column) {

    }

    @Override
    public int getIterations() {
        return 0;
    }
}
