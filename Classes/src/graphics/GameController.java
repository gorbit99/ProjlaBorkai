package graphics;

import game_classes.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class GameController {


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

    public Text getPlayerId() {
        return playerId;
    }

    public Pane getInventoryPane() {
        return inventoryPane;
    }

    public Pane getAsteroidFieldGroup() {
        return asteroidFieldGroup;
    }
}
