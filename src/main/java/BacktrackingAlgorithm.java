import java.util.stream.IntStream;

public class BacktrackingAlgorithm extends AbstractAlgorithm {

    private final int[][] board;

    public BacktrackingAlgorithm(int[][] board) {
        super(board);
        this.board = board;
    }

    @Override
    public boolean solve() {
            // we iterate over entire board looking for empty cells
            for(int row = getStartIndex(); row < getBoardSize(); row++){
                for(int column = getStartIndex(); column < getBoardSize(); column++){
                    // if we find empty cell we iterate over all possible values until we find one that passes validation
                    if(board[row][column] == getNoValue()){
                        for(int guess = getMinValue(); guess <= getMaxValue(); guess++){
                            board[row][column] = guess;  // put in our guess
                            if(isValid(row, column) && solve()){
                                // if our guess is valid recursive call to this function passes, sudoku is solved
                                return true;
                            }
                            // if we didn't find the right value we empty the cell and try again
                            board[row][column] = getNoValue();
                        }
                        // if there is no possible value to put in a cell sudoku might be unsolvable
                        return false;
                    }

                }
            }
            print();
            return true;
    }

    boolean checkConstraint(int row, boolean[] constraint, int column) {
        if(getBoard()[row][column] != getNoValue()){
            if(!constraint[board[row][column] - 1]){
                constraint[board[row][column] - 1] = true;
            }
            else{
                return false;
            }
        }
        return true;
    }


    private boolean isValid(int row, int column) {
        return (rowConstraint(row))
                && columnConstraint(column)
                && squareConstraint(row, column);

    }

    private boolean columnConstraint(int column) {
        boolean[] constraint = new boolean[getBoardSize()];                                                                // we fill boolean array with false values
        return IntStream.range(getStartIndex(), getBoardSize()).allMatch(row -> checkConstraint(row, constraint, column));     // for each cell in column we check all the others values
    }                                                                                                                  // to see if they are valid

    private boolean rowConstraint(int row) {
        boolean[] constraint = new boolean[getBoardSize()];                                                                // same stuff just for rows
        return IntStream.range(getStartIndex(), getBoardSize()).allMatch(column -> checkConstraint(row, constraint, column));
    }

    private boolean squareConstraint(int row, int column) {
        boolean[] constraint = new boolean[getBoardSize()];
        int subsectionRowStart = (row / getSubsectionSize()) * getSubsectionSize();  // find start and end of a subsection
        int subsectionRowEnd = subsectionRowStart + getSubsectionSize();         // default size of a subsection is 3x3

        int subsectionColumnStart = (column / getSubsectionSize()) * getSubsectionSize();
        int subsectionColumnEnd = subsectionColumnStart + getSubsectionSize();

        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!checkConstraint(r, constraint, c)) return false;       // same as others, we check every cell in subsection to find an invalid guess
            }
        }
        return true;
    }
}
