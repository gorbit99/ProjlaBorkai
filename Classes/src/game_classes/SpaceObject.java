package game_classes;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * represents a space object
 */
public abstract class SpaceObject {
    protected PropertyChangeSupport changeEvent;

    public PropertyChangeSupport GetChangeEvent() {
        return changeEvent;
    }

    public SpaceObject() {
        AsteroidField.GetInstance().AddSpaceObject(this);
    }

    /**
     * Contains all the workers who are standing on the space object
     */
    protected final ArrayList<Worker> workers = new ArrayList<>();
    /**
     * Contains all the neighbours
     */
    protected final ArrayList<SpaceObject> neighbours = new ArrayList<>();

    /**
     * adds new neighbour
     *
     * @param spaceObject neighbour to be added to the neighbour list
     */
    public void AddNeighbour(SpaceObject spaceObject) {
        this.neighbours.add(spaceObject);
        changeEvent.firePropertyChange("neighbour", null, spaceObject);
    }


    /**
     * return all the workers on the space object
     *
     * @return all the workers on the space objects
     */
    public ArrayList<Worker> GetWorkers() {
        return workers;
    }

    /**
     * returns all the neighbours
     *
     * @return all the neighbours of the space object
     */
    public ArrayList<SpaceObject> GetNeighbours() {
        return this.neighbours;
    }

    /**
     * removes a neighbour
     *
     * @param spaceObject space object to be removed
     */
    public abstract void RemoveNeighbour(SpaceObject spaceObject);

    /**
     * adds a worker to the worker list
     *
     * @param worker worker to be added to the worker list
     */
    public abstract void AddWorker(Worker worker);

    /**
     * removes a worker from workers list
     *
     * @param worker worker to be removed from workers list
     */
    public abstract void RemoveWorker(Worker worker);

    /**
     * moves the space object
     * called once every round
     */
    public abstract void Move();

    /**
     * called when a solar storm reached a space object
     */
    public abstract void HandleSolarStorm();

    /**
     * returns core of the space object
     *
     * @return core of the space object
     */
    public abstract Material GetCore();
}
