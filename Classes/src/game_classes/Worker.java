package game_classes;

import java.util.ArrayList;

/**
 * represents a Worker
 */
public abstract class Worker {
    protected Asteroid position = new Asteroid();

    /**
     * Moves worker to the given SpaceObject
     * @param spaceObject worker will be moved here
     */
    public void TravelTo(SpaceObject spaceObject) {
        TestLogger.EnterFunction("Worker.TravelTo");
        this.position.RemoveWorker(this);
        spaceObject.AddWorker(this);
        TestLogger.ExitFunction();
    }

    /**
     * drills a layer with the help of Asteroid.Drill()
     */
    public void Drill() {
        TestLogger.EnterFunction("Worker.Drill");
        this.position.Drill();
        TestLogger.ExitFunction();
    }

    /**
     * worker waits nothing happens
     */
    public void Wait() {
        TestLogger.EnterFunction("Worker.Wait");
        TestLogger.ExitFunction();
    }

    /**
     * happens when a steroid explodes
     */
    public abstract void Explode();

    /**
     * called when a solar storm occurs
     */
    public void HandleSolarStorm() {
        TestLogger.EnterFunction("Worker.HandleSolarStorm");
        System.out.println("Worker.HandleSolarStorm");
        if (!this.position.CanHideIn())
            this.Die();
        TestLogger.ExitFunction();
    }

    /**
     * called when a worker dies
     * removes worker from asteroid and also from the game
     */
    public void Die() {
        TestLogger.EnterFunction("Worker.Die");
        this.position.RemoveWorker(this);
        Game.GetInstance().RemoveWorker(this);
        TestLogger.ExitFunction();
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
    public abstract Material[] GetStoredMaterials();
}
