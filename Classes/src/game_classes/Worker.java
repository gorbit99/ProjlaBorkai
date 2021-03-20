package game_classes;

public abstract class Worker {
	protected SpaceObject position;
	public void TravelTo(SpaceObject spaceObject) {
		System.out.println("Worker.TratvelTo");
		this.position.RemoveWorker(this);
		spaceObject.AddWorker(this);
	}
	
	public void Drill() {
		System.out.println("Worker.Drill");

	}
	
	public void Wait() {
		System.out.println("Worker.Wait");
	}
	
	public void Explode() {
		System.out.println("Worker.Explode");
	}
	
	public void HandleSolarStorm() {
		System.out.println("Worker.HandleSolarStorm");
	}
	
	public void Die(){
		System.out.println("Worker.Die");
		this.position.RemoveWorker(this);

	}
	
	public abstract void Step();
	
	public abstract void Move();
}
