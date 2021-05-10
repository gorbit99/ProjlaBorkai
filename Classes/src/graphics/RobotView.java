package graphics;

import game_classes.Robot;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class RobotView {
    private final ImageView imageView;

    public RobotView(){
        imageView = new javafx.scene.image.ImageView(new Image("/Pictures/robot.png"));
        GameController.getInstance().getAsteroidFieldGroup().getChildren().add(imageView);
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);
    }
    public void DrawRobot(Robot robot){
        SpaceObjectController spaceObjectController =
                SpaceObjectController.controllerFromSpaceObject(robot.getPosition());

        int id = AsteroidView.getNextEntityId(robot.getPosition());
        Point position = ((AsteroidView)spaceObjectController.getView()).getEntityPosition(id);

        imageView.setLayoutX(position.x);
        imageView.setLayoutY(position.y);
    }
}
