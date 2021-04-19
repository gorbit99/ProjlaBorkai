package game_classes;

import java.util.ArrayList;

/**
 * This class represents the asteroid field of the game. Stores and moves the asteroids.
 */
public class AsteroidField {

    /**
     * contains all the spaceObjects in the asteroid field
     */
    private final ArrayList<SpaceObject> spaceObjects;
    private static AsteroidField instance;

    /**
     * Class constructor
     */
    private AsteroidField() {
        spaceObjects = new ArrayList<>();
    }

    /**
     * @return the instance of the class
     */
    public static AsteroidField GetInstance() {
        if (instance == null)
            instance = new AsteroidField();
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
}
