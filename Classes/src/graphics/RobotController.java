package graphics;

import game_classes.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * Controller for the robot worker
 */
public class RobotController extends WorkerController {

    /**
     * thr robot which belongs to the controller
     * the view of the robot
     */
    private Robot robot;
    private RobotView view;

    /**
     * Contructor of the class
     * @param materials materials necessary to create a robot
     * @param asteroid the asteroid this robot is created on
     */
    public RobotController(ArrayList<Material> materials, Asteroid asteroid) {
        robot = Robot.CreateRobot(materials, asteroid);
        view = new RobotView();
        view.DrawRobot(robot);
        robot.GetChangeEvent().addPropertyChangeListener(this);
    }


    /**
     * Event Handler for property changes
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        view.DrawRobot(robot);
    }
}
