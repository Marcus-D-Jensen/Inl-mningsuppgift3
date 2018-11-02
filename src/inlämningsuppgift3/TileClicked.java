package inlämningsuppgift3;

import java.util.ArrayList;
import java.util.Collections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class TileClicked implements EventHandler<ActionEvent> {
   
    GridPane board;
    ArrayList<Button> buttons;
    Button tempButton = new Button("");
    int emptyButtonPosition;
    
    public TileClicked(GridPane board, ArrayList<Button> buttons, int emptyButtonPosition) {
        this.board = board;
        this.buttons = buttons;
        this.emptyButtonPosition = emptyButtonPosition;
        
    }

    @Override
    public void handle(ActionEvent event) {
        
        int buttonPosition = buttons.indexOf(event.getSource());
        int over = buttonPosition - 4;   int under = buttonPosition + 4;
        int right = buttonPosition + 1;  int left = buttonPosition - 1;
        
        
        
        if ((emptyButtonPosition == over) || (emptyButtonPosition == under) || (emptyButtonPosition == left) || (emptyButtonPosition == right)) {
                Collections.swap(buttons, buttonPosition, emptyButtonPosition);
            }
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
