package inlämningsuppgift3;

import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.control.Button;

public class CheckIfSolved {

    private Button buttonEmpty = new Button("");
    private ArrayList<Button> gkjnfld = new ArrayList();
    
    public boolean solved(ArrayList<Button> buttons, Button empty) {
        
        gkjnfld.clear();
        
        for (Button button : buttons) {
            gkjnfld.add(button);
        }
        
        gkjnfld.remove(empty);
        int i = 1;
        for (Button button : gkjnfld) {
            
            if (!button.getText().equals(String.valueOf(i))) {
                return false; 
            }
            i++;
        }
        
        return true;
    }

}
