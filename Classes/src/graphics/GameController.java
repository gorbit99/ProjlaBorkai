package graphics;

import game_classes.Game;
import game_classes.MockIO;
import javafx.fxml.FXML;
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

    /**
     * instance of the game controller
     */
    private static GameController instance;

    /**
     * constructor of the game controller
     */
    public GameController() {
        instance = this;
    }


    /**
     * returns an instance of the game controller
     * @return the instance of the game controller
     */
    public static GameController getInstance() {
        return instance;
    }

    /**
     * initialize function of the game controller class
     */
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
    public void Exit(){
        System.exit(0);
    }
    /**
     * move method of the game
     */
    public void Move(){

    }
    /**
     * wait method of the game
     */
    public void Wait(){

    }
    /**
     * mine method of the game
     */
    public void Mine(){

    }
    /**
     * place method of the game
     */
    public void Place(){

    }
    /**
     * drill method of the game
     */
    public void Drill(){

    }
    /**
     * teleporter creating method of the game
     */
    public void createTeleporter(){

    }
    /**
     * robot creating method of the game
     */
    public void createRobot(){

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
