package game_classes;

import java.util.Scanner;

/**
 * This class represents the SolarStorms in the game.
 */
public class SolarStorm {

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
		Scanner sc = new Scanner(System.in);
		System.out.println("Is there a solarstorm? (y/n)");
		String answer = sc.nextLine();
		sc.close();
		TestLogger.ExitFunction();
		return answer.equals("y");
	}
}
