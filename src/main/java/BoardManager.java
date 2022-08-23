import java.util.Scanner;
import java.util.stream.IntStream;

public class BoardManager {
    private final static int START_INDEX = 0;
    private final static int NO_VALUE = 0;
    private final static int MIN_VALUE = 1;
    private final static int MAX_VALUE = 9;
    private final static int SUBSECTION_SIZE = 3;
    private final int BOARD_SIZE;



    private long time;
    private final Scanner scanner = new Scanner(System.in);
    private final int[][] board;



    public BoardManager(int[][] board) {
        this.board = board;
        BOARD_SIZE = board.length;
    }

    public void solve(int choice) {
        long start = System.currentTimeMillis();
        switch (choice){
            case 1 -> bruteForceSolve();
            case 2 -> bruteForceSolve();
        }
        bruteForceSolve();
        time = System.currentTimeMillis() - start;
    }

    public boolean bruteForceSolve(){
        // we iterate over entire board looking for empty cells
        for(int row = START_INDEX; row < BOARD_SIZE; row++){
            for(int column = START_INDEX; column < BOARD_SIZE; column++){
                // if we find empty cell we iterate over all possible values until we find one that passes validation
                if(board[row][column] == NO_VALUE){
                    for(int guess = MIN_VALUE; guess <= MAX_VALUE; guess++){
                        board[row][column] = guess;  // put in our guess
                        if(isValid(row, column) && bruteForceSolve()){
                            // if our guess is valid recursive call to this function passes, sudoku is solved
                            return true;
                        }
                        // if we didn't find the right value we empty the cell and try again
                        board[row][column] = NO_VALUE;
                    }
                    // if there is no possible value to put in a cell sudoku might be unsolvable
                    return false;
                }

            }
        }
        return true;
    }

    boolean checkConstraint(int row, boolean[] constraint, int column) {
        if(board[row][column] != NO_VALUE){
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
        boolean[] constraint = new boolean[BOARD_SIZE];                                                                // we fill boolean array with false values
        return IntStream.range(START_INDEX, BOARD_SIZE).allMatch(row -> checkConstraint(row, constraint, column));     // for each cell in column we check all the others values
    }                                                                                                                  // to see if they are valid

    private boolean rowConstraint(int row) {
        boolean[] constraint = new boolean[BOARD_SIZE];                                                                // same stuff just for rows
        return IntStream.range(START_INDEX, BOARD_SIZE).allMatch(column -> checkConstraint(row, constraint, column));
    }

    private boolean squareConstraint(int row, int column) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        int subsectionRowStart = (row / SUBSECTION_SIZE) * SUBSECTION_SIZE;  // find start and end of a subsection
        int subsectionRowEnd = subsectionRowStart + SUBSECTION_SIZE;         // default size of a subsection is 3x3

        int subsectionColumnStart = (column / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int subsectionColumnEnd = subsectionColumnStart + SUBSECTION_SIZE;

        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!checkConstraint(r, constraint, c)) return false;       // same as others, we check every cell in subsection to find an invalid guess
            }
        }
        return true;
    }

    public void print(){
        for(int row = START_INDEX; row < BOARD_SIZE; row++){
            for(int column = START_INDEX; column < BOARD_SIZE; column++){
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }

    public long getTime() {
        return time;
    }

}
