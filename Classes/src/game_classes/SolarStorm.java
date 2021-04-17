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
		timeTillHit=Game.RandomNum(10)+10;
	}

	/**
	 * Decreases the object's inner counter, resets it if necessary, returns whether a solarstorm should happen.
	 * @return True if a solarstorm is happening, false otherwise.
	 */
	public boolean Tick() {
		timeTillHit--;
		if(timeTillHit>0)
			return false;
		timeTillHit=Game.RandomNum(10)+10;
		return true;
	}
}
