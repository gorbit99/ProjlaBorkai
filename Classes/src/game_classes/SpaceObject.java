package game_classes;

import java.util.ArrayList;

/**
 * represents a space object
 */
public abstract class SpaceObject {

	/**
	 * @param workers contains all the workers who are standing on the space object
	 * @param neighbours contains all the neigbours
	 */
	protected ArrayList<Worker> workers = new ArrayList<Worker>();
	protected ArrayList<SpaceObject> neighbours = new ArrayList<SpaceObject>();

	/**
	 * adds new neighbour
	 * @param spaceObject neighbour to be added to the neighbour list
	 */
	public void AddNeighbour(SpaceObject spaceObject) {
		TestLogger.EnterFunction("SpaceObject.AddNeighbour");
		this.neighbours.add(spaceObject);
		TestLogger.ExitFunction();
	}

	/**
	 * returns all the neighbours
	 * @return all the neighbours of the space object
	 */
	public ArrayList<SpaceObject> GetNeighbours() {
		TestLogger.EnterFunction("SpaceObject.GetNeighbours");
		TestLogger.ExitFunction();
		return this.neighbours;
	}

	/**
	 * removes a neighbour
	 * @param spaceObject space object to be removed
	 */
	public abstract void RemoveNeighbour(SpaceObject spaceObject);

	/**
	 * adds a worker to the worker list
	 * @param worker worker to be added to the neighbour list
	 */
	public abstract void AddWorker(Worker worker);

	/**
	 * removes a worker from workers list
	 * @param worker worker to be removed from workers list
	 */
	public abstract void RemoveWorker(Worker worker);
}
