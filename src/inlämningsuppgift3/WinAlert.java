package inlämningsuppgift3;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

public class WinAlert {
    
    public static boolean victory() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Victory!!");
        alert.setHeaderText("Congrats! You did it!");
        alert.setContentText("Want to play again?");
        ButtonType buttonTypeTryAgain = new ButtonType("Try Again");
        ButtonType buttonTypeQuit = new ButtonType("Quit", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeTryAgain, buttonTypeQuit);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeTryAgain) {
            return true;
        }
        else if (result.get() == buttonTypeQuit) {
            return false;
        }
        return false;
    }
    

}
