package game_classes;

/**
 * This class represents the SolarStorms in the game.
 */
public class SolarStorm {

	/**
	 * parameter that stores the number of rounds
	 * left until the next solar storm
	 */
	private int timeTillHit;

	/**
	 * Constructor of the class.
	 */
	public SolarStorm(){
		TestLogger.EnterFunction("SolarStorm.ctor");
		TestLogger.ExitFunction();
	}

	/**
	 * Decreases the object's inner counter, resets it if necessary, returns whether a solarstorm should happen.
	 * @return True if a solarstorm is happening, false otherwise.
	 */
	public boolean Tick() {
		TestLogger.EnterFunction("SolarStorm.Tick");
		String answer = TestLogger.AskQuestion("Is there a solarstorm? (y/n)");
		TestLogger.ExitFunction();
		return answer.equals("y");
	}
}
