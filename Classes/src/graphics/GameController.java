package graphics;

import game_classes.Game;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class GameController {

    @FXML
    private Pane asteroidFieldGroup;
    /**
     * button which represents the placing method
     */
    @FXML
    private Button placeBtn;
    /**
     * button which represents the robot creating method
     */
    @FXML
    private Button robotBtn;
    /**
     * button which represents the mining method
     */
    @FXML
    private Button mineBtn;
    /**
     * button which represents the teleport creating method
     */
    @FXML
    private Button teleportBtn;

    /**
     * representing where the player id appears
     */
    @FXML
    private Text playerText;
    /**
     * button which represents the drilling method
     */
    @FXML
    private Button drillBtn;

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

    /**
     * getter of the drill button
     * @return the drill button
     */
    public Button getDrillBtn() {
        return drillBtn;
    }

    /**
     * exit method of the game
     */
    public void exit(){
        System.exit(0);
    }

    /**
     * getter of the place button
     * @return the place button
     */
    public Button getPlaceBtn() {
        return placeBtn;
    }
    /**
     * getter of the robot creating button
     * @return the robot creating button
     */
    public Button getRobotBtn() {
        return robotBtn;
    }

    /**
     * getter of the mine button
     * @return the mine button
     */
    public Button getMineBtn() {
        return mineBtn;
    }
    /**
     * getter of the teleporter creating button
     * @return the teleporter creating button
     */
    public Button getTeleportBtn() {
        return teleportBtn;
    }
    /**
     * getter of the asteroid field's pane
     * @return pane of the asteroid
     */
    public Pane getAsteroidFieldGroup() {
        return asteroidFieldGroup;
    }
}
