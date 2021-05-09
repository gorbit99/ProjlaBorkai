package game_classes;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * represents a Worker
 */
public abstract class Worker {
    protected Asteroid position;
    protected PropertyChangeSupport changeEvent = new PropertyChangeSupport(this);

    public PropertyChangeSupport GetChangeEvent() {
        return changeEvent;
    }

    /**
     * Constructor of the class, every worker has a position.
     *
     * @param position The position to create the worker on
     */
    public Worker(Asteroid position) {
        SetPosition(position);
        Game.GetInstance().AddWorker(this);
        position.AddWorker(this);
    }


    /**
     * returns the position of the worker
     * @return worker's position
     */
    public Asteroid getPosition() {
        return position;
    }

    /**
     * Moves worker to the given SpaceObject
     *
     * @param spaceObject worker will be moved here
     */
    public void TravelTo(SpaceObject spaceObject) {
        SpaceObject old = position;
        this.position.RemoveWorker(this);
        changeEvent.firePropertyChange("position", old, position);
        spaceObject.AddWorker(this);
    }

    /**
     * drills a layer with the help of Asteroid.Drill()
     */
    public void Drill() throws Exception {
        this.position.Drill();
    }

    /**
     * worker waits nothing happens
     */
    public void Wait() {
    }

    /**
     * happens when a steroid explodes
     */
    public abstract void Explode();

    /**
     * called when a solar storm occurs
     */
    public void HandleSolarStorm() {
        if (!this.position.CanHideIn()) {
            this.Die();
        }
    }

    /**
     * called when a worker dies
     * removes worker from asteroid and also from the game
     */
    public void Die() {
        this.position.RemoveWorker(this);
        Game.GetInstance().RemoveWorker(this);
        changeEvent.firePropertyChange("exist", true, false);
    }

    /**
     * Sets the worker's position
     *
     * @param asteroid to be set as position
     */
    public void SetPosition(Asteroid asteroid) {
        SpaceObject old = position;
        this.position = asteroid;
        changeEvent.firePropertyChange("position", old,position);
    }

    /**
     * controls the worker's inside method
     */
    public abstract void Step();

    /**
     * moves worker
     */
    public abstract void Move();

    /**
     * returns the stored material of the worker
     *
     * @return stored materials
     */
    public abstract ArrayList<Material> GetStoredMaterials();

}
