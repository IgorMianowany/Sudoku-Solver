import buildlogic.SudokuBuildLogic;
import javafx.scene.control.Button;
import userInterface.IUserInterfaceContract;
import javafx.application.Application;
import javafx.stage.Stage;
import userInterface.UserInterfaceImpl;

import java.io.IOException;

public class GUI extends Application {

    private IUserInterfaceContract.View uiImpl;

    @Override
    public void start(Stage primaryStage) throws IOException {
        SudokuSolver sudokuSolver = new SudokuSolver(new int[5][5]);



        uiImpl = new UserInterfaceImpl(primaryStage);
        try{
            SudokuBuildLogic.build(uiImpl);
        }catch (IOException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}