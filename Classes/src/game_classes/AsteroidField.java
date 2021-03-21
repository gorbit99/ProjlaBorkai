package game_classes;

import java.util.ArrayList;
public class AsteroidField {
    private ArrayList<Asteroid> asteroids;
    private static AsteroidField instance;

    private AsteroidField() {
        System.out.println("AsteroidField.ctor");
    }

    public static AsteroidField GetInstance() {
        System.out.println("AsteroidField.GetInstance");
        if (instance == null)
            instance = new AsteroidField();
        return instance;
    }

    public void MoveAsteroids() {
    }

    public void AddAsteroid(Asteroid asteroid) {
    }

	public ArrayList<Asteroid> GetAsteroids() {
		System.out.println("AsteroidField.GetAsteroids");
		return this.asteroids;
	}

    public void RemoveAsteroid(Asteroid asteroid) {
    }

	public void HandleSolarStorm() {
		System.out.println("AsteroidField.HandleSolarStorm");
		for (int i = 0; i < asteroids.size(); i++) {
			asteroids.get(i).HandleSolarStorm();
		}
	}
}
