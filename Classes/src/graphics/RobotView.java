package graphics;

import game_classes.Robot;
import javafx.scene.image.Image;

import javax.swing.text.html.ImageView;

public class RobotView {
    private ImageView imageView;

    public RobotView(javafx.scene.image.ImageView imageView){
        imageView.setImage(new Image("/Pictures/robot.png"));
    }
    public void DrawRobot(Robot robot){

    }
}
