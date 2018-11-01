package inlämningsuppgift3;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Inlämningsuppgift3 extends Application{
    
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, empty;
    
    ArrayList<Button> buttons = new ArrayList();
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sliding Puzzle!");
        
        b1 = new Button("1");   b2 = new Button("2");   b3 = new Button("3");   b4 = new Button("4");
        b5 = new Button("5");   b6 = new Button("6");   b7 = new Button("7");   b8 = new Button("8");
        b9 = new Button("9");   b10 = new Button("10"); b11 = new Button("11"); b12 = new Button("12");
        b13 = new Button("13"); b14 = new Button("14"); b15 = new Button("15"); empty = new Button();
        
        empty.setId("emptySquare");
        
        buttons.add(b1);    buttons.add(b2);    buttons.add(b3);    buttons.add(b4);
        buttons.add(b5);    buttons.add(b6);    buttons.add(b7);    buttons.add(b8);
        buttons.add(b9);    buttons.add(b10);   buttons.add(b11);   buttons.add(b12);
        buttons.add(b13);   buttons.add(b14);   buttons.add(b15);   buttons.add(empty);
        
        GridPane gridLayout = new GridPane();
        int row = 0;
        int col = 0;
        
        Collections.shuffle(buttons);
        
        for (Button button : buttons) {
            gridLayout.add(button, col, row);
            if (col < 3) {
                col++;
            } else {
                col = 0;
                row++;
            }
        }
        
        Scene scene = new Scene(gridLayout);
        primaryStage.setScene(scene);
        
        scene.getStylesheets().add(Inlämningsuppgift3.class.getResource("myStyle.css").toExternalForm());
        
        primaryStage.show();
        
    }
}
