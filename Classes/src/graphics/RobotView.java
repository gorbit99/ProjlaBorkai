package graphics;

import game_classes.Robot;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;


/**
 * View for the robot worker
 */
public class RobotView {
    private final ImageView imageView;

    /**
     * Contructor of the class.
     * Sets the image to the correct one from the Pictures folder
     */
    public RobotView(){
        imageView = new javafx.scene.image.ImageView(new Image("/Pictures/robot.png"));
        GameController.getInstance().getAsteroidFieldGroup().getChildren().add(imageView);
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);
    }

    /**
     * Draws this robot
     * @param robot
     */
    public void DrawRobot(Robot robot){
        SpaceObjectController spaceObjectController =
                SpaceObjectController.controllerFromSpaceObject(robot.getPosition());

        int id = AsteroidView.getNextEntityId(robot.getPosition(),robot);
        Point position = ((AsteroidView)spaceObjectController.getView()).getEntityPosition(id);

        imageView.setLayoutX(position.x);
        imageView.setLayoutY(position.y);
    }
}
