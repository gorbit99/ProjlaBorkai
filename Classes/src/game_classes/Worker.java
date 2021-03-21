package game_classes;

public abstract class Worker {
    protected Asteroid position = new Asteroid();

    public void TravelTo(SpaceObject spaceObject) {
        TestLogger.EnterFunction("Worker.TravelTo");
        this.position.RemoveWorker(this);
        spaceObject.AddWorker(this);
        TestLogger.ExitFunction();
    }

    public void Drill() {
        TestLogger.EnterFunction("Worker.Drill");
        this.position.Drill();
        TestLogger.ExitFunction();
    }

    public void Wait() {
        TestLogger.EnterFunction("Worker.Wait");
        TestLogger.ExitFunction();
    }

    public abstract void Explode();

    public void HandleSolarStorm() {
        TestLogger.EnterFunction("Worker.HandleSolarStorm");
        System.out.println("Worker.HandleSolarStorm");
        if (!this.position.CanHideIn())
            this.Die();
        TestLogger.ExitFunction();
    }

    public void Die() {
        TestLogger.EnterFunction("Worker.Die");
        this.position.RemoveWorker(this);
        Game.GetInstance().RemoveWorker(this);
        TestLogger.ExitFunction();
    }

    public abstract void Step();

    public abstract void Move();
}
