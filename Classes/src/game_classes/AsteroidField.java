package game_classes;

public class AsteroidField {
    private Asteroid asteroids;
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

    public Asteroid[] GetAsteroids() {
        return null;
    }

    public void RemoveAsteroid(Asteroid asteroid) {
    }

    public void HandleSolarStorm() {
    }
}
