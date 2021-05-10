package graphics;

import game_classes.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {

    @FXML
    private AnchorPane gameView;
    @FXML
    private Pane inventoryPane;
    @FXML
    private Text playerId;
    @FXML
    private Button waitBtn;
    @FXML
    private Pane asteroidFieldGroup;
    @FXML
    private Button placeBtn;
    @FXML
    private Button robotBtn;
    @FXML
    private Button mineBtn;
    @FXML
    private Button teleportBtn;
    @FXML
    private Button drillBtn;
    @FXML
    private Button moveBtn;
    @FXML
    private Button returnToMenu;

    private static GameController instance;

    public GameController() {
        instance = this;
    }

    public static GameController getInstance() {
        return instance;
    }

    @FXML
    protected void initialize(){
        Game.GetInstance().StartGame();

    }

    public Button getDrillBtn() {
        return drillBtn;
    }

    public void exit(){
        System.exit(0);
    }

    public Button getPlaceBtn() {
        return placeBtn;
    }

    public Button getRobotBtn() {
        return robotBtn;
    }

    public Button getMineBtn() {
        return mineBtn;
    }

    public Button getTeleportBtn() {
        return teleportBtn;
    }

    public Button getWaitBtn() {
        return waitBtn;
    }

    public Button getMoveBtn() {
        return moveBtn;
    }

    public Button getReturnToMenu(){return returnToMenu;}

    public Text getPlayerId() {
        return playerId;
    }

    public Pane getInventoryPane() {
        return inventoryPane;
    }

    public Pane getAsteroidFieldGroup() {
        return asteroidFieldGroup;
    }

    public void Endgame(boolean win, boolean lose) {
        if (win || lose) {
            Parent root = new Parent() {};
            if (win) {
                try {//todo nem rajzolja ki a kurva anyját
                    root = FXMLLoader.load(getClass().getResource("Win.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("win" + root);
            } else if (lose) {
                try {//todo nem rajzolja ki a kurva anyját
                    root = FXMLLoader.load(getClass().getResource("Lose.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("lose" + root);
            }

            Scene scene = new Scene(root, Color.ORANGE);
            Stage stage = (Stage) gameView.getScene().getWindow();
            stage.setScene(scene);
        }

    }
}
