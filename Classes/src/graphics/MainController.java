package graphics;

import game_classes.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private AnchorPane menuView;

    /**
     * starting method of the game
     * @throws IOException
     */
    public void Start() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
        Scene scene = new Scene(root, Color.ORANGE);
        String css = this.getClass().getResource("gameStyle.css").toExternalForm();
        scene.getStylesheets().add(css);


        Stage stage = (Stage)menuView.getScene().getWindow();
        stage.setScene(scene);
        Game.GetInstance().DoRound();
    }

}
