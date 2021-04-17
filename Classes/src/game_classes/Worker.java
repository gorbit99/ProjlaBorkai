package game_classes;


import java.util.ArrayList;

/**
 * represents a Worker
 */
public abstract class Worker {
    protected Asteroid position;


    /**
     * Constructor of the class, every worker has a position.
     * @param position
     */
    public Worker(Asteroid position){
        SetPosition(position);
        Game.GetInstance().AddWorker(this);
    }


    /**
     * Moves worker to the given SpaceObject
     * @param spaceObject worker will be moved here
     */
    public void TravelTo(SpaceObject spaceObject) {
        this.position.RemoveWorker(this);
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
    public void Wait() {}

    /**
     * happens when a steroid explodes
     */
    public abstract void Explode();

    /**
     * called when a solar storm occurs
     */
    public void HandleSolarStorm() {
        if (!this.position.CanHideIn())
            this.Die();
    }

    /**
     * called when a worker dies
     * removes worker from asteroid and also from the game
     */
    public void Die() {
        this.position.RemoveWorker(this);
        Game.GetInstance().RemoveWorker(this);
    }

    /**
     * Sets the worker's position
     * @param asteroid to be set as position
     */
    public void SetPosition(Asteroid asteroid) {
        this.position = asteroid;
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
     * @return stored materials
     */
    public abstract ArrayList<Material> GetStoredMaterials();
}
