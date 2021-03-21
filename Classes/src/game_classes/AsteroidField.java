package game_classes;

import java.util.ArrayList;
public class AsteroidField {
	private ArrayList<Asteroid> asteroids;
	private static AsteroidField instance;
	
	private AsteroidField() {
		TestLogger.EnterFunction("AsteroidField.ctor");
		TestLogger.ExitFunction();
	}

	public static AsteroidField GetInstance() {
	    TestLogger.EnterFunction("AsteroidField.GetInstance");
		if (instance == null)
			instance = new AsteroidField();
		TestLogger.ExitFunction();
		return instance;
	}

	public void MoveAsteroids() {
		TestLogger.EnterFunction("AsteroidField.MoveAsteroids");
		for (Asteroid asteroid : asteroids){
			asteroid.MoveAsteroid();
		}
		TestLogger.ExitFunction();
	}
	
	public void AddAsteroid(Asteroid asteroid) {
		TestLogger.EnterFunction("AsteroidField.AddAsteroid");
		asteroids.add(asteroid);
		TestLogger.ExitFunction();
	}
	
	public ArrayList<Asteroid> GetAsteroids() {
		TestLogger.EnterFunction("AsteroidField.GetAsteroids");
		TestLogger.ExitFunction();
		return asteroids;
	}
	
	public void RemoveAsteroid(Asteroid asteroid) {
		TestLogger.EnterFunction("AsteroidField.RemoveAsteroid");
		asteroids.remove(asteroid);
		TestLogger.ExitFunction();
	}
	
	public void HandleSolarStorm() {
		TestLogger.EnterFunction("AsteroidField.HandleSolarStorm");
		for (Asteroid asteroid : asteroids) {
			asteroid.HandleSolarStorm();
		}
		TestLogger.ExitFunction();
	}
}
