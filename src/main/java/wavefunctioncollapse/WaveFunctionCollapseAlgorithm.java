package wavefunctioncollapse;

import abstraction.AbstractAlgorithm;

public class WaveFunctionCollapseAlgorithm extends AbstractAlgorithm {

    private final int[][] board;
    private final Tile[][] tileBoard = new Tile[9][9];

    public WaveFunctionCollapseAlgorithm(int[][] board) {
        super(board);
        this.board = board;

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                tileBoard[i][j] = new Tile(board[i][j]);
            }
        }
    }

    @Override
    public boolean solve(){
        // limit options for every tile

        // find tile with the lowest entropy

        // collapse tile to single guess

        // repeat until solved
        return false;
    }

    @Override
    public void print(){
        for(int row = getStartIndex(); row < getBoardSize(); row++){
            for(int column = getStartIndex(); column < getBoardSize(); column++){
                System.out.print(tileBoard[row][column].getChoice() + "/" + tileBoard[row][column].getPossibleNumbers().size() + " ");
            }
            System.out.println();
        }
    }

}
