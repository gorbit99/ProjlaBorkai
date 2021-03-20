package game_classes;

import java.util.ArrayList;

public abstract class SpaceObject {
	//nem így van az umlen ezt meg kell ebszélni
	protected ArrayList<Worker> workers;
	protected ArrayList<SpaceObject> neigbours;


	public void AddNeighbour(SpaceObject spaceObject) {
		System.out.println("SpaceObject.AddNeighbour");
	}
	
	public ArrayList<SpaceObject> GetNeighbours() {
		System.out.println("SpaceObject.GetNeighbours");
		return this.neigbours;
	}
	
	public abstract void RemoveNeighbour(SpaceObject spaceObject);
	
	public abstract void AddWorker(Worker worker);

	//szintén meg kell beszélni mert so ként van tárolva a workernél és ott kellene rajta removolni
	//és a teleporternek ez meg nem kell viszont
	public abstract void RemoveWorker(Worker worker);
}
