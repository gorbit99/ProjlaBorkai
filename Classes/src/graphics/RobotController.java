package graphics;

import game_classes.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
        robot.GetChangeEvent().addPropertyChangeListener(this);
    }

    /*PropertyChangeListener AstronautChange = new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            System.out.println("astronautchange");
            view.DrawAstronaut(astronaut);
            if (evt.getPropertyName().equals("ActiveAstronaut") && evt.getNewValue() == astronaut) {
                view.SetButtonStatus();

            }
        }
    };*/

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        view.DrawRobot(robot);
    }
}
