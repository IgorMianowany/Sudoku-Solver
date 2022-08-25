import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import computationlogic.SudokuUtils;


public class BacktrackingAlgorithm extends AbstractAlgorithm {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private final int[][] board;
    private final int[][] originalBoard;
    private final Scanner in = new Scanner(System.in);


    private int iterations = 0;

    public BacktrackingAlgorithm(int[][] board) {
        super(board);
        this.board = board;
        originalBoard = SudokuUtils.copyToNewArray(board);
    }

    @Override
    public boolean solve() {
            // we iterate over entire board looking for empty cells
            for(int row = getStartIndex(); row < getBoardSize(); row++){
                for(int column = getStartIndex(); column < getBoardSize(); column++){
                    // if we find empty cell we iterate over all possible values until we find one that passes validation
                    if(board[row][column] == getNoValue()){
                        for(int guess = getMinValue(); guess <= getMaxValue(); guess++){
                            iterations++;
                            board[row][column] = guess;  // put in our guess
                            if(isValid(row, column, guess) && solve()){
                                // if our guess is valid then recursive call to this function passes and sudoku is solved
                                System.out.println("solved");
                                return true;
                            }
                            // if we didn't find the right value we empty the cell and try again,
                            // if we can't find the value again, we come back to previous guess and try again
                            board[row][column] = getNoValue();
                        }
                        System.out.println(ANSI_RED+"NO POSSIBLE SOLUTION, GOING BACK" + ANSI_RESET);
                        // if there is no possible value to put in a cell algorithm will go back to check previous guesses
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


    private boolean isValid(int row, int column, int guess) {
        if(rowConstraint(row) && columnConstraint(column) && squareConstraint(row, column)){
            System.out.println("row: "+(row +1)+"\ncolumn: "+(column+1)+"\nguess: "+guess
                    +"\niterations: " + iterations);
            print(row, column);
            try{
                TimeUnit.MILLISECONDS.sleep(850);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return true;
        }
        return false;
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
    @Override
    public int getIterations() {
        return iterations;
    }

    @Override
    public void print(int guessRow, int guessColumn){
        for(int row = getStartIndex(); row < getBoardSize(); row++){
            for(int column = getStartIndex(); column < getBoardSize(); column++){
                if(row == guessRow && column == guessColumn){
                    System.out.print(ANSI_YELLOW+"|"+board[row][column] + "|    "+ANSI_RESET);
                }
                else if(board[row][column] != 0 && originalBoard[row][column] == 0 && row == guessRow && column == guessColumn-1){
                    System.out.print(ANSI_GREEN + board[row][column] + "    " + ANSI_RESET);
                }
                else if(board[row][column] != 0 && originalBoard[row][column] == 0){
                    System.out.print(ANSI_GREEN + board[row][column] + "     " + ANSI_RESET);
                }
                else{
                    if (row == guessRow && column == guessColumn-1) {
                        System.out.print(board[row][column] + "    ");
                    } else{
                        System.out.print(board[row][column] + "     ");
                    }
                }
            }
            System.out.println();
        }
    }
}
