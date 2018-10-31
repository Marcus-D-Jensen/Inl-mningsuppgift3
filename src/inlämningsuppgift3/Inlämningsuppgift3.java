package inlämningsuppgift3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Inlämningsuppgift3 extends Application{

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15;
    Label empty;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sliding Puzzle!");
        
        b1 = new Button("1");   b2 = new Button("2");   b3 = new Button("3");   b4 = new Button("4");
        b5 = new Button("5");   b6 = new Button("6");   b7 = new Button("7");   b8 = new Button("8");
        b9 = new Button("9");   b10 = new Button("10"); b11 = new Button("11"); b12 = new Button("12");
        b13 = new Button("13"); b14 = new Button("14"); b15 = new Button("15"); empty = new Label();
        
        GridPane layout = new GridPane();
        
        layout.add(b1,0,0);     layout.add(b2,1,0);     layout.add(b3, 2, 0);       layout.add(b4, 3, 0);
        layout.add(b5,0,1);     layout.add(b6,1,1);     layout.add(b7, 2, 1);       layout.add(b8, 3, 1);
        layout.add(b9,0,2);     layout.add(b10,1,2);    layout.add(b11, 2, 2);      layout.add(b12, 3, 2);
        layout.add(b13,0,3);    layout.add(b14,1,3);    layout.add(b15, 2, 3);      layout.add(empty, 3, 3);
        
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        
        scene.getStylesheets().add(Inlämningsuppgift3.class.getResource("myStyle.css").toExternalForm());
        
        primaryStage.show();
        
    }
}
