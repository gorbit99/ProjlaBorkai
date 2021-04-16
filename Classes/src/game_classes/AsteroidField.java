package game_classes;

import java.util.ArrayList;

/**
 * This class represents the asteroid field of the game. Stores and moves the asteroids.
 */
public class AsteroidField {
	private ArrayList<SpaceObject> spaceObjects;
	private static AsteroidField instance;

	/**
	 * Class constructor
	 */
	private AsteroidField() {
		TestLogger.EnterFunction("AsteroidField.ctor");
		spaceObjects = new ArrayList<>();
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
	public void Move() {
		TestLogger.EnterFunction("AsteroidField.MoveAsteroids");
		for (SpaceObject spaceObject: spaceObjects){
			spaceObject.Move();
		}
		TestLogger.ExitFunction();
	}

	/**
	 * Adds a spaceObject to the AsteroidField
	 * @param spaceObject this spaceObject will be added to the AsteroidField
	 */
	public void AddSpaceObject(SpaceObject spaceObject) {
		TestLogger.EnterFunction("AsteroidField.AddAsteroid");
		spaceObjects.add(spaceObject);
		TestLogger.ExitFunction();
	}

	/**
	 * returns the list of spaceObjects in asteroid field
	 * @return An ArrayList of the spaceObjects in the AsteroidField
	 */
	public ArrayList<SpaceObject> GetObjects() {
		TestLogger.EnterFunction("AsteroidField.GetAsteroids");
		TestLogger.ExitFunction();
		return spaceObjects;
	}

	/**
	 * Removes a spaceObject
	 * @param spaceObject this space object will be removed from the AsteroidField
	 */
	public void RemoveSpaceObject(SpaceObject spaceObject) {
		TestLogger.EnterFunction("AsteroidField.RemoveAsteroid");
		spaceObjects.remove(spaceObject);
		TestLogger.ExitFunction();
	}

	/**
	 * Handles a solarstorm. Calls the HandleSolarStorm method of all Asteroids stored
	 */
	public void HandleSolarStorm() {
		TestLogger.EnterFunction("AsteroidField.HandleSolarStorm");
		for (SpaceObject spaceObject : spaceObjects) {
			spaceObject.HandleSolarStorm();
		}
		TestLogger.ExitFunction();
	}
}
