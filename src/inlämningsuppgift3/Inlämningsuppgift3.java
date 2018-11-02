package inlämningsuppgift3;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Inlämningsuppgift3 extends Application {
    
    Stage window;
    Scene scene, victoryScene;
    
    GridPane board = new GridPane();
    FlowPane menu = new FlowPane();
    BorderPane layout = new BorderPane();
    
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, empty;
    Button restart, quit;
    
    ArrayList<Button> buttons = new ArrayList();
    
    TileClicked tileClicked = new TileClicked();
    CheckIfSolved checkIfSolved = new CheckIfSolved();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        board.getStyleClass().add("board");
        
        window = primaryStage;
        window.setTitle("Sliding Puzzle!");
        
        restart = new Button("Restart");  restart.setId("meny");
        quit = new Button("Quit");        quit.setId("meny");
        
        menu.getChildren().add(restart);
        menu.getChildren().add(quit);
        
        b1 = new Button("1");   b2 = new Button("2");   b3 = new Button("3");   b4 = new Button("4");
        b5 = new Button("5");   b6 = new Button("6");   b7 = new Button("7");   b8 = new Button("8");
        b9 = new Button("9");   b10 = new Button("10"); b11 = new Button("11"); b12 = new Button("12");
        b13 = new Button("13"); b14 = new Button("14"); b15 = new Button("15"); empty = new Button("");
        
        empty.setId("emptySquare");
        
        buttons.add(b1);    buttons.add(b2);    buttons.add(b3);    buttons.add(b4);
        buttons.add(b5);    buttons.add(b6);    buttons.add(b7);    buttons.add(b8);
        buttons.add(b9);    buttons.add(b10);   buttons.add(b11);   buttons.add(b12);
        buttons.add(b13);   buttons.add(b14);   buttons.add(b15);   buttons.add(empty);
        
        
        GenerateBoard.generate(board, buttons);
        
        b1.setOnAction(tileClicked);     b2.setOnAction(tileClicked);     b3.setOnAction(tileClicked);     b4.setOnAction(tileClicked);
        b5.setOnAction(tileClicked);     b6.setOnAction(tileClicked);     b7.setOnAction(tileClicked);     b8.setOnAction(tileClicked);
        b9.setOnAction(tileClicked);     b10.setOnAction(tileClicked);    b11.setOnAction(tileClicked);    b12.setOnAction(tileClicked);
        b13.setOnAction(tileClicked);    b14.setOnAction(tileClicked);    b15.setOnAction(tileClicked);
        
        
        restart.setOnAction((event) -> { GenerateBoard.generate(board, buttons); });
        quit.setOnAction((event) -> { System.exit(0); });
        
        
        layout.setTop(menu);
        layout.setCenter(board);
        scene = new Scene(layout);
        window.setScene(scene);
        scene.getStylesheets().add(Inlämningsuppgift3.class.getResource("myStyle.css").toExternalForm());
        window.show();
    }
    
    public class TileClicked implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            
            int clickedButtonPosition = buttons.indexOf(event.getSource());
            
            int top = clickedButtonPosition - 4;   int bottom = clickedButtonPosition + 4;
            int left = clickedButtonPosition - 1;   int right = clickedButtonPosition + 1;  
            
            int emptyButtonPosition = buttons.indexOf(empty);
            
            if ((emptyButtonPosition == top) || (emptyButtonPosition == bottom) 
                    || (emptyButtonPosition == left) || (emptyButtonPosition == right)) {
                
                Collections.swap(buttons, clickedButtonPosition, buttons.indexOf(empty));
            }
            
            GenerateBoard.updateBoard(board, buttons);

            if (checkIfSolved.solved(buttons, empty)) {
                if (WinAlert.victory()) {
                    GenerateBoard.generate(board, buttons);
                    
                } else { System.exit(0); }    
            }
        }
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
