package graphics;

import game_classes.*;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class RobotController extends WorkerController {

    /**
     * thr robot which belongs to the controller
     * the view of the robot
     */
    private Robot robot;
    private RobotView view;

    public RobotController(Asteroid asteroid) {
        robot = new Robot(asteroid);

        view = new RobotView();
        view.DrawRobot(robot);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        view.DrawRobot(robot);
    }
}
