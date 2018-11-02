package inlämningsuppgift3;

import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class GenerateBoard {
    

    
    public static void generate(GridPane board,  ArrayList<Button> buttons) {
        
        board.getChildren().clear();
        Collections.shuffle(buttons);
        int row = 0;
        int col = 0;
        
        for (Button button : buttons) {
            board.add(button, col, row);
            if (col < 3) {
                col++;
            } else {
                col = 0;
                row++;
            }
        }
    }
    
    public static void updateBoard(GridPane board,  ArrayList<Button> buttons) {
        
        board.getChildren().clear();
        int row = 0;
        int col = 0;
        
        for (Button button : buttons) {
            board.add(button, col, row);
            if (col < 3) {
                col++;
            } else {
                col = 0;
                row++;
            }
        }
    }
}
