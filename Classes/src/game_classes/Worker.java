package game_classes;

public abstract class Worker {
    protected Asteroid position;

    public void TravelTo(SpaceObject spaceObject) {
        System.out.println("Worker.TratvelTo");
        this.position.RemoveWorker(this);
        spaceObject.AddWorker(this);
    }

    public void Drill() {
        System.out.println("Worker.Drill");
        this.position.Drill();
    }

    public void Wait() {
        System.out.println("Worker.Wait");
    }

    public abstract void Explode();

    public void HandleSolarStorm() {
        System.out.println("Worker.HandleSolarStorm");
        if (!this.position.CanHideIn())
            this.Die();
    }

    public void Die() {
        System.out.println("Worker.Die");
        this.position.RemoveWorker(this);
        Game.GetInstance().RemoveWorker(this);
    }

    public abstract void Step();

    public abstract void Move();
}
