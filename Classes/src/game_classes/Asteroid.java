package game_classes;


/**
 * represent an asteroid. Extends SpaceObject.
 */
public class Asteroid extends SpaceObject {
	/**
	 *The core of the asteroid.
	 */
	private Material core;

	/**
	 * The constructor of the asteroid.
	 */
	public Asteroid(){
	    TestLogger.EnterFunction("Asteroid.ctor");

	    TestLogger.ExitFunction();
	}

	/**
	 * handles, when someone drills the asteroid
	 */
	public void Drill() {
	    TestLogger.EnterFunction("Asteroid.Drill");
	    String answer = TestLogger.AskQuestion("Do I still have layers? (y/n)");
		if (answer.equals("n")){
			if (IsCloseToSun())
				if(core != null)
					core.HandleCloseToSun(this);
		}
	    TestLogger.ExitFunction();
	}

	/**
	 * Handles when its under mining.
	 * @return true, if you can mine this.
	 */
	public Material Mine() {
	    TestLogger.EnterFunction("Asteroid.Mine");
		String answer = TestLogger.AskQuestion("Do I still have layers? (y/n)");
		if (answer.equals("y")){
			TestLogger.ExitFunction();
			return null;
		}
		Material temp = core;
		core = null;
	    TestLogger.ExitFunction();
		return temp;
	}

	/**
	 * Places material to the core. (if it can be done)
	 * @param material This will be the core
	 * @return true, if the method has been done.
	 */
	public boolean PlaceMaterial(Material material) {
		TestLogger.EnterFunction("Asteroid.PlaceMaterial");
		if(material!=null){
			core=material;
			if(IsCloseToSun()){
				core.HandleCloseToSun(this);
			}
		}

		TestLogger.ExitFunction();
		return material==null;
	}

	/**
	 * Changes the distance from the sun.
	 */
	public void MoveAsteroid() {
		TestLogger.EnterFunction("Asteroid.MoveAsteroid");

		if(IsCloseToSun()){
			if (core != null) {
				core.HandleCloseToSun(this);
			}
		}

		TestLogger.ExitFunction();
	}

	/**
	 * Handles, when asteroid explodes.
	 */
	public void Explode() {
	    TestLogger.EnterFunction("Asteroid.Explode");

		for (int i = workers.size() - 1; i >= 0; i--) { //itt honnan van a worker????
			workers.get(i).Explode();
		}

		for (SpaceObject so:neighbours) {
			so.RemoveNeighbour(this);
		}

		AsteroidField.GetInstance().RemoveAsteroid(this);

		TestLogger.ExitFunction();
	}

	/**
	 *
	 * @return true, if you can hide in it
	 */
	public boolean CanHideIn() {
		TestLogger.EnterFunction("Asteroid.CanHideIn");
		String answer = TestLogger.AskQuestion("Can you hide in the asteroid? (y/n)");
		TestLogger.ExitFunction();
		return answer.equals("y");
	}

	/**
	 * Adds worker to the workers list.
	 * @param worker worker to be added to the workers list
	 */
	public void AddWorker(Worker worker) {
		TestLogger.EnterFunction("Asteroid.AddWorker");
		workers.add(worker);
		worker.SetPosition(this);
		TestLogger.ExitFunction();
	}

	/**
	 * Removes worker from workers list.
	 * @param worker worker to be removed from workers list
	 */
	public void RemoveWorker(Worker worker) {
		TestLogger.EnterFunction("Asteroid.RemoveWorker");
		workers.remove(worker);
		TestLogger.ExitFunction();
	}

	/**
	 * Sets material to core.
	 * @param material
	 */
	public void SetCore(Material material) {
	    TestLogger.EnterFunction("Asteroid.SetCore");
		core = material;
	    TestLogger.ExitFunction();
	}

	/**
	 * Removes spaceobject from neighbours
	 * @param spaceObject space object to be removed
	 */
	public void RemoveNeighbour(SpaceObject spaceObject) {
		TestLogger.EnterFunction("Asteroid.RemoveNeighbour");
		neighbours.remove(spaceObject);
		TestLogger.ExitFunction();
	}

	/**
	 * Handles, when the solarstorm hits this
	 */
	public void HandleSolarStorm() {
		TestLogger.EnterFunction("Asteroid.HandleSolarStorm");
		if(!CanHideIn()){
			for (Worker w: workers) {
				w.Die();
			}
		}
		TestLogger.ExitFunction();
	}

	/**
	 *
	 * @return true, if it is close to the sun
	 */
	public boolean IsCloseToSun() {
		TestLogger.EnterFunction("Asteroid.IsCloseToSun");
		String answer = TestLogger.AskQuestion("Am I close to the sun? (y/n)");
		TestLogger.ExitFunction();
		return answer.equals("y");
	}

	/**
	 * Gets the material inside the core of the asteroid
	 * @return The material in the core
	 */
	public Material GetCore() {
		TestLogger.EnterFunction("Asteroid.GetCore");
		TestLogger.ExitFunction();
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
