package graphics;

import game_classes.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class GameController {

    @FXML
    private Button placeBtn;
    @FXML
    private Button robotBtn;
    @FXML
    private Button mineBtn;
    @FXML
    private Button teleportBtn;
    @FXML
    private Button exitBtn;
    @FXML
    private Text playerText;
    @FXML
    private Button drillBtn;
    @FXML
    private Button moveBtn;


    @FXML
    protected void initialize(){
        Game.GetInstance().StartGame();

    }

    public Button getDrillBtn() {
        return drillBtn;
    }

    public Button getMoveBtn() {
        return moveBtn;
    }

    public void exit(){
        System.exit(0);
    }
}
