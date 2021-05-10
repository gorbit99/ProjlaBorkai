package game_classes;

import graphics.SpaceObjectController;

import java.util.ArrayList;

/**
 * This class represents the asteroid field of the game. Stores and moves the asteroids.
 */
public class AsteroidField {
    /**
     * Number of asteroids in a row
     */
    private static final int asteroidFieldWidth = 5;

    /**
     * Number of asteroids in a column
     */
    private static final int asteroidFieldHeight = 3;

    /**
     * contains all the spaceObjects in the asteroid field
     */
    private final ArrayList<SpaceObject> spaceObjects;

    /**
     * The asteroid field instance in the game
     */
    private static AsteroidField instance;

    /**
     * Class constructor
     */
    private AsteroidField() {
        spaceObjects = new ArrayList<>();
    }

    private void init() {
        ArrayList<SpaceObjectController> controllers = new ArrayList<>();
        for (int i = 0; i < asteroidFieldWidth * asteroidFieldHeight; i++) {
            controllers.add(SpaceObjectController.createAsteroidController(i));
        }

        for (int i = 0; i < AsteroidField.GetInstance().GetObjects().size(); i++) {
            if (i % asteroidFieldWidth != asteroidFieldWidth - 1) {
                int id = i + 1;
                AsteroidField.GetInstance().GetObjects().get(i).AddNeighbour(AsteroidField.GetInstance().GetObjects().get(id));
                AsteroidField.GetInstance().GetObjects().get(id).AddNeighbour(AsteroidField.GetInstance().GetObjects().get(i));
            }
            if (i / asteroidFieldWidth != asteroidFieldHeight - 1) {
                int id = i + asteroidFieldWidth;
                AsteroidField.GetInstance().GetObjects().get(i).AddNeighbour(AsteroidField.GetInstance().GetObjects().get(id));
                AsteroidField.GetInstance().GetObjects().get(id).AddNeighbour(AsteroidField.GetInstance().GetObjects().get(i));
            }
        }

        for (SpaceObjectController controller : controllers) {
            controller.getView().Draw(controller.getSpaceObject());
        }
    }

    /**
     * @return the instance of the class
     */
    public static AsteroidField GetInstance() {
        if (instance == null) {
            instance = new AsteroidField();
            instance.init();
        }
        return instance;
    }

    /**
     * Moves all Asteroids in the AsteroidField by calling their MoveAsteroid() method
     */
    public void Move() {
        for (SpaceObject spaceObject : spaceObjects) {
            spaceObject.Move();
        }
    }

    /**
     * Adds a spaceObject to the AsteroidField
     *
     * @param spaceObject this spaceObject will be added to the AsteroidField
     */
    public void AddSpaceObject(SpaceObject spaceObject) {
        spaceObjects.add(spaceObject);
    }

    /**
     * returns the list of spaceObjects in asteroid field
     *
     * @return An ArrayList of the spaceObjects in the AsteroidField
     */
    public ArrayList<SpaceObject> GetObjects() {
        return spaceObjects;
    }

    /**
     * Removes a spaceObject
     *
     * @param spaceObject this space object will be removed from the AsteroidField
     */
    public void RemoveSpaceObject(SpaceObject spaceObject) {
        spaceObjects.remove(spaceObject);
    }

    /**
     * chooses a random asteroid than solar storm happens on that asteroid
     * and on all its neighbours
     */
    public void HandleSolarStorm() {
        SpaceObject object = this.spaceObjects.get(Game.RandomNum(this.spaceObjects.size()));
        object.HandleSolarStorm();
        for (SpaceObject so : object.GetNeighbours()) {
            so.HandleSolarStorm();
        }
    }

    /**
     * Gets the number of asteroids in a row
     *
     * @return The number of asteroids in a row
     */
    public static int getAsteroidFieldWidth() {
        return asteroidFieldWidth;
    }

    /**
     * Gets the number of asteroids in a column
     *
     * @return The number of asteroids in a column
     */
    public static int getAsteroidFieldHeight() {
        return asteroidFieldHeight;
    }
}
