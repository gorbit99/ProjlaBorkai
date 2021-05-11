package graphics;

import game_classes.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {
    /**
     * Fxml elements
     */
    @FXML
    private AnchorPane gameView;

    @FXML
    private HBox inventoryBox;
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
    protected void initialize() {
        Game.GetInstance().StartGame();

    }

    /**
     * Gets the drill button
     *
     * @return the drill button
     */
    public Button getDrillBtn() {
        return drillBtn;
    }

    /**
     * exits the game
     */
    public void exit() {
        System.exit(0);
    }

    /**
     * Gets the place button
     *
     * @return the place button
     */
    public Button getPlaceBtn() {
        return placeBtn;
    }

    /**
     * Gets the Create robot button
     *
     * @return the robot button
     */
    public Button getRobotBtn() {
        return robotBtn;
    }

    /**
     * Gets the mine button
     *
     * @return the mine button
     */
    public Button getMineBtn() {
        return mineBtn;
    }

    /**
     * Gets the create teleport button
     *
     * @return the create teleport button
     */
    public Button getTeleportBtn() {
        return teleportBtn;
    }

    /**
     * Gets the wait button
     *
     * @return the wait button
     */
    public Button getWaitBtn() {
        return waitBtn;
    }

    /**
     * Gets the move button
     *
     * @return the move button
     */
    public Button getMoveBtn() {
        return moveBtn;
    }

    public HBox getInventoryBox() {
        return inventoryBox;
    }

    public Button getReturnToMenu() {
        return returnToMenu;
    }

    /**
     * Gets the player id text
     *
     * @return the player id text
     */
    public Text getPlayerId() {
        return playerId;
    }


    /**
     * Gets the asteroid field group
     *
     * @return asteroid field group
     */
    public Pane getAsteroidFieldGroup() {
        return asteroidFieldGroup;
    }


    //todo ez a baj
    public void Endgame(boolean win, boolean lose) {
        if (win || lose) {
            Parent root = null;
            if (win) {
                try {//todo nem rajzolja ki a kurva anyját
                    root = FXMLLoader.load(getClass().getResource("Win.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("win" + root);
            } else if (lose) {
                try {//todo nem rajzolja ki a kurva anyját
                    System.out.println("bej0v00000000k33333333333333");

                    root = FXMLLoader.load(getClass().getResource("Lose.fxml"));
                    System.out.println("bej0v00000000k");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("lose" + root);
            }

            Scene scene = new Scene(root);
            Stage stage = (Stage) gameView.getScene().getWindow();


            //Stage stage=new Stage();
            stage.setScene(scene);
            stage.show();
        }

    }
}
