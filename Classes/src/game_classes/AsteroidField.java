package game_classes;

import java.util.ArrayList;

/**
 * This class represents the asteroid field of the game. Stores and moves the asteroids.
 */
public class AsteroidField {
	private ArrayList<Asteroid> asteroids;
	private static AsteroidField instance;

	/**
	 * Class constructor
	 */
	private AsteroidField() {
		TestLogger.EnterFunction("AsteroidField.ctor");
		TestLogger.ExitFunction();
	}

	/**
	 * @return the instance of the class
	 */
	public static AsteroidField GetInstance() {
	    TestLogger.EnterFunction("AsteroidField.GetInstance");
		if (instance == null)
			instance = new AsteroidField();
		TestLogger.ExitFunction();
		return instance;
	}

	/**
	 * Moves all Asteroids in the AsteroidField by calling their MoveAsteroid() method
	 */
	public void MoveAsteroids() {
		TestLogger.EnterFunction("AsteroidField.MoveAsteroids");
		for (Asteroid asteroid : asteroids){
			asteroid.MoveAsteroid();
		}
		TestLogger.ExitFunction();
	}

	/**
	 * Adds an Asteroid to the AsteroidField
	 * @param asteroid this Asteroid will be added to the AsteroidField
	 */
	public void AddAsteroid(Asteroid asteroid) {
		TestLogger.EnterFunction("AsteroidField.AddAsteroid");
		asteroids.add(asteroid);
		TestLogger.ExitFunction();
	}

	/**
	 * Get the Asteroids
	 * @return An ArrayList of the asteroids in the AsteroidField
	 */
	public ArrayList<Asteroid> GetAsteroids() {
		TestLogger.EnterFunction("AsteroidField.GetAsteroids");
		TestLogger.ExitFunction();
		return asteroids;
	}

	/**
	 * Removes an Asteroid
	 * @param asteroid this Asteroid will be removed from the AsteroidField
	 */
	public void RemoveAsteroid(Asteroid asteroid) {
		TestLogger.EnterFunction("AsteroidField.RemoveAsteroid");
		asteroids.remove(asteroid);
		TestLogger.ExitFunction();
	}

	/**
	 * Handles a solarstorm. Calls the HandleSolarStorm method of all Asteroids stored
	 */
	public void HandleSolarStorm() {
		TestLogger.EnterFunction("AsteroidField.HandleSolarStorm");
		for (Asteroid asteroid : asteroids) {
			asteroid.HandleSolarStorm();
		}
		TestLogger.ExitFunction();
	}
}
