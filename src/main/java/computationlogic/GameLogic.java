package computationlogic;

import constants.GameState;
import constants.Rows;
import jdk.swing.interop.SwingInterOpUtils;
import problemdomain.SudokuGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static problemdomain.SudokuGame.GRID_BOUNDARY;

public class GameLogic {


    public static SudokuGame getNewGame(){
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

        final int[][] boardSolved ={
                {3, 0, 9, 5, 2, 7, 1, 4, 6},
                {7, 6, 1, 9, 8, 4, 2, 5, 3},
                {4 ,2 ,5 ,1 ,6, 3, 8, 9, 7},
                {8, 5, 7, 3, 9, 1, 6, 2, 4},
                {2, 3 ,4 ,6 ,5 ,8 ,9, 7, 1},
                {9, 1, 6, 7, 4, 2, 5, 3, 8},
                {1 ,4 ,8 ,2 ,7, 9, 3, 6, 5},
                {5, 7, 2, 8, 3, 6, 4, 1, 9},
                {6, 9, 3, 4, 1, 5, 7, 8, 2}
        };

        return new SudokuGame(
                GameState.NEW,
                boardSolved);
    }

    public static GameState checkForCompletion(int[][] grid){
        System.out.println("Checking for completion");
        if(sudokuIsInvalid(grid)) return GameState.ACTIVE;
        System.out.println("Tiles are not filled: " + tilesAreNotFilled(grid));
        if(tilesAreNotFilled(grid)) return GameState.ACTIVE;
        return GameState.COMPLETE;
    }

    public static boolean sudokuIsInvalid(int[][] grid) {
        if(rowsAreInvalid(grid)) return true;
        if(columnsAreInvalid(grid)) return true;
        return squaresAreInvalid(grid);
    }

    private static boolean rowsAreInvalid(int[][] grid) {
        for(int yIndex = 0; yIndex < GRID_BOUNDARY; yIndex++){
            List<Integer> row = new ArrayList<>();
            for(int xIndex = 0; xIndex< GRID_BOUNDARY; xIndex++){
                row.add(grid[xIndex][yIndex]);
            }
            if(collectionHasRepeats(row)) return true;
        }
        return false;
    }

    private static boolean columnsAreInvalid(int[][] grid) {
        for(int xIndex = 0; xIndex < GRID_BOUNDARY; xIndex++){
            List<Integer> row = new ArrayList<>();
            for(int yIndex = 0; yIndex< GRID_BOUNDARY; yIndex++){
                row.add(grid[xIndex][yIndex]);
            }
            if(collectionHasRepeats(row)) return true;
        }
        return false;
    }

    private static boolean squaresAreInvalid(int[][] grid) {
        System.out.println("Top row invalid: " + rowOfSquaresIsInvalid(Rows.TOP, grid));
        System.out.println("Mid row invalid: " + rowOfSquaresIsInvalid(Rows.MIDDLE, grid));
        System.out.println("Bot row invalid: " + rowOfSquaresIsInvalid(Rows.BOTTOM, grid));
        if(rowOfSquaresIsInvalid(Rows.TOP, grid)) return true;
        if(rowOfSquaresIsInvalid(Rows.MIDDLE, grid)) return true;
        return rowOfSquaresIsInvalid(Rows.BOTTOM, grid);
    }

    private static boolean rowOfSquaresIsInvalid(Rows value, int[][] grid) {
        switch (value){
            case TOP -> {
                if(squareIsInvalid(0,0,grid)) return true;
                if(squareIsInvalid(3,0,grid)) return true;
                return squareIsInvalid(6, 0, grid);
            }
            case MIDDLE -> {
                if(squareIsInvalid(3,3,grid)) return true;
                if(squareIsInvalid(3,3,grid)) return true;
                return squareIsInvalid(6, 3, grid);
            }
            case BOTTOM -> {
                if(squareIsInvalid(0,6,grid)) return true;
                if(squareIsInvalid(3,6,grid)) return true;
                return squareIsInvalid(6, 6, grid);
            }
            default -> {
                return false;
            }
        }
    }

    private static boolean squareIsInvalid(int xIndex, int yIndex, int[][] grid) {
        int xIndexEnd = xIndex + 3;
        int yIndexEnd = yIndex + 3;

        List<Integer> square = new ArrayList<>();

        while(yIndex<yIndexEnd){
            while (xIndex<xIndexEnd){
                square.add(grid[xIndex][yIndex]);
                xIndex++;
            }
            xIndex -=3;
            yIndex++;
        }
        return collectionHasRepeats(square);
    }

    private static boolean collectionHasRepeats(List<Integer> collection) {
        for(int index = 1; index <= GRID_BOUNDARY; index++){
            if(Collections.frequency(collection, index) > 1) return true;
        }
        return false;
    }

    private static boolean tilesAreNotFilled(int[][] grid){
        for(int xIndex = 0; xIndex < GRID_BOUNDARY; xIndex++){
            for(int yIndex = 0; yIndex < GRID_BOUNDARY; yIndex++){
                if(grid[xIndex][yIndex] == 0) return true;
            }
        }
        return false;
    }
}
