package projlab.skeleton.participants;

import projlab.skeleton.entities.Robot;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;

/**
 * A mesterséges intelligenciát kezelő, singleton osztály
 */
public class AI extends Participant {

    /**
     * Az AI singleton instance-e
     */
    private static AI instance;

    /**
     * Az AI robotjai
     */
    private final ArrayList<Robot> robots = new ArrayList<>();

    /**
     * Privát konstruktor a singletonság kedvéért
     */
    private AI() { }

    /**
     * A singleton design pattern getInstance metódusa
     * @return Az osztály singleton instance-e
     */
    public static AI getInstance() {
        if (instance == null)
            instance = new AI();
        return instance;
    }

    /**
     * Hozzáad egy robotot a robotok listájához
     * @param robot A hozzáadandó robot
     */
    public void addRobot(Robot robot) {
        FunctionPrinter.enter("AI", "addRobot", this, robot);
        robots.add(robot);
        FunctionPrinter.exit();
    }

    /**
     * Eltávolít egy robotot a robotok listájából
     * @param robot Az eltávolítandó robot
     */
    public void removeRobot(Robot robot) {
        FunctionPrinter.enter("AI", "removeRobot", this, robot);
        robots.remove(robot);
        FunctionPrinter.exit();
    }

}
