package inlämningsuppgift3;

import java.util.ArrayList;
import javafx.scene.control.Button;

public class CheckIfSolved {
    
    private ArrayList<Button> tempButtons = new ArrayList();
    
    public boolean solved(ArrayList<Button> buttons, Button empty) {
        
        
        tempButtons.clear();
        
        for (Button button : buttons) {
            tempButtons.add(button);
        }
        
        tempButtons.remove(empty);
        int i = 1;
        for (Button button : tempButtons) {
            
            if (!button.getText().equals(String.valueOf(i))) {
                return false; 
            }
            i++;
        }
        
        return true;
    }

}
