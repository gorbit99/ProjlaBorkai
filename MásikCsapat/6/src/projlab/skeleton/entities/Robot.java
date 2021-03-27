package projlab.skeleton.entities;

import projlab.skeleton.map.Field;
import projlab.skeleton.participants.AI;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;

/**
 * A robot entitást jelképező
 */
public class Robot extends Entity {

	/**
	 * A robot konstruktora
	 */
	public Robot() {
		FunctionPrinter.enter("Robot", "<<create>>", this);
		FunctionPrinter.register(this, "robot");
		// Automatikusan adjuk hozzá a robotot az AI-hoz
		AI.getInstance().addRobot(this);
		FunctionPrinter.exit();
	}

	/**
	 * Lekezeli a robot felrobbanását
	 */
	public void explode() {
	    FunctionPrinter.enter("Robot", "explode", this);
		ArrayList<Field> neighbors = location.getNeighbors();
		// Ha van szomszédos aszteroida, rakjuk át rá a robotot, egyébként haljon meg
	    if (neighbors.isEmpty()) {
	    	die();
		} else {
	    	move(neighbors.get(0));
		}
	    FunctionPrinter.exit();
	}

	/**
	 * A robot halálát implementáló metódus
	 */
	@Override
	public void die() {
		FunctionPrinter.enter("Robot", "die", this);
		super.die();
		AI.getInstance().removeRobot(this);
		FunctionPrinter.exit();
	}
}
