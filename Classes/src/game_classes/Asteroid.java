package game_classes;


import java.util.ArrayList;
import java.util.Random;

/**
 * represent an asteroid. Extends SpaceObject.
 */
public class Asteroid extends SpaceObject {
	/**
	 *The core of the asteroid.
	 */
	private Material core;
	/**
	 *The distance between the sun and the asteroid
	 */
	private float distanceFromSun;
	/**
	 *The number of layers not drilled through in the asteroid's crust
	 */
	private int layers;


	/**
	 * The constructor of the asteroid.
	 */
	public Asteroid(){
		this.layers = 0;
		this.distanceFromSun = 0;
		this.core = null;
	}

	/**
	 * handles, when someone drills the asteroid
	 * @throws Exception when there are no layers left to drill
	 */
	public void Drill() throws Exception {
		if (layers == 0) throw new Exception("No layers left");
		if (layers > 0) layers--;
		if (layers == 0 && IsCloseToSun() && core != null)
			core.HandleCloseToSun(this);
	}

	/**
	 * Handles when its under mining.
	 * @return the material in the asteroid if you can mine this, null otherwise.
	 */
	public Material Mine(){
		if (layers != 0 || core == null) return null;
		Material temp = core;
		SetCore(null);
		return temp;
	}

	/**
	 * Places material to the core. (if it can be done)
	 * @param material This will be the core
	 * @return true, if the method has been done.
	 */
	public boolean PlaceMaterial(Material material) {
		if (core == null) {
			SetCore(material);
			core.HandleCloseToSun(this);
			return true;
		}
		return false;
	}

	/**
	 * Changes the distance from the sun.
	 */
	public void Move() {
		distanceFromSun = Game.RandomNum(5);
	}

	/**
	 * Handles, when asteroid explodes.
	 */
	public void Explode() {
		for (int i = workers.size() - 1; i >= 0; i--){
			workers.get(i).Explode();
		}
		for (SpaceObject so: neighbours){
			so.RemoveNeighbour(this);
		}
		AsteroidField.GetInstance().RemoveSpaceObject(this);
	}

	/**
	 *
	 * @return true, if you can hide in it
	 */
	public boolean CanHideIn() {
		return layers == 0 && core == null;
	}

	/**
	 * Adds worker to the workers list.
	 * @param worker worker to be added to the workers list
	 */
	public void AddWorker(Worker worker) {
		workers.add(worker);
		worker.SetPosition(this);
	}

	/**
	 * Removes worker from workers list.
	 * @param worker worker to be removed from workers list
	 */
	public void RemoveWorker(Worker worker) {
		workers.remove(worker);
	}

	/**
	 * Sets material to core.
	 * @param material the new core of the asteroid.
	 */
	public void SetCore(Material material) {
		core = material;
	}

	/**
	 * Removes spaceobject from neighbours
	 * @param spaceObject space object to be removed
	 */
	public void RemoveNeighbour(SpaceObject spaceObject) {
		neighbours.remove(spaceObject);
		if (neighbours.size() == 0){
			ArrayList<SpaceObject> potentialNeighbours = spaceObject.GetNeighbours();
			if (potentialNeighbours.size() > 1) {
				SpaceObject obj = potentialNeighbours.get(Game.RandomNum(potentialNeighbours.size() - 1));
				this.AddNeighbour(obj);
				return;
			}
			SpaceObject so;
			potentialNeighbours = AsteroidField.GetInstance().GetObjects();
			do {
				so = potentialNeighbours.get(Game.RandomNum(potentialNeighbours.size() - 1));
			} while (so == this);
			this.AddNeighbour(so);
		}
	}

	/**
	 * Handles, when the solarstorm hits this
	 */
	public void HandleSolarStorm() {
		if (!CanHideIn())
			for (Worker w: workers)
				w.Die();
	}

	/**
	 *
	 * @return true, if it is close to the sun
	 */
	public boolean IsCloseToSun() {
		return distanceFromSun < 2.5f;
	}

	/**
	 * Gets the material inside the core of the asteroid
	 * @return The material in the core
	 */
	public Material GetCore() {
		return core;
	}

	/**
	 *
	 * @return The name of the class.
	 */
	@Override
	public String toString(){
		return "Asteroid";
	}

}
