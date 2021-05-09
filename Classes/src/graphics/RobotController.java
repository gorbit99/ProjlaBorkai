package graphics;

import game_classes.Robot;

import java.beans.PropertyChangeEvent;

public class RobotController extends WorkerController{

    /**
     * thr robot which belongs to the controller
     * the view of the robot
     */
    private Robot robot;
    private RobotView view;


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    /**
     * creating method of the robot's controller
     */
    public static void CreateRobotController(){

    }
}
