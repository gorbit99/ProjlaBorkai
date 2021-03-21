package game_classes;
import java.util.Scanner;

/**
 * This class represents an asteroid. It extends from SpaceObject.
 */
public class Asteroid extends SpaceObject {
	/**
	 * This is the core of the asteroid.
	 */
	private Material core;

	/**
	 * This is constructor of asteroid.
	 */
	public Asteroid(){
	    TestLogger.EnterFunction("Asteroid.ctor");

	    TestLogger.ExitFunction();
	}

	/**
	 * This handles when a worker is drilling this.
	 */
	public void Drill() {
	    TestLogger.EnterFunction("Asteroid.Drill");
		Scanner sc = new Scanner(System.in);
		System.out.println("Do I still have layers? (y/n)");
		String answer = sc.nextLine();
		sc.close();
		if (answer.equals("y")){
			if (IsCloseToSun())
				core.HandleCloseToSun(this);
		}
	    TestLogger.ExitFunction();
	}

	/**
	 *
	 * @return The core of the material. (null if you can't mine it)
	 */
	public Material Mine() {
	    TestLogger.EnterFunction("Asteroid.Mine");
		Scanner sc = new Scanner(System.in);
		System.out.println("Do I still have layers? (y/n)");
		String answer = sc.nextLine();
		sc.close();
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
	 * This places the material to the core. (If it can be done.)
	 * @param material This will be the core of the material.
	 * @return Returns false if the core wasn't empty.
	 */
	public boolean PlaceMaterial(Material material) {
		TestLogger.EnterFunction("Asteroid.PlaceMaterial");
		if(core==null){
			TestLogger.ExitFunction();
			return false;
		}
		if(material!=null){
			core=material;
			if(IsCloseToSun()){
				core.HandleCloseToSun(this);
			}
		}
		TestLogger.ExitFunction();
		return true;
	}

	/**
	 * Moves the asteroid. Change the distance from the sun.
	 */
	public void MoveAsteroid() {
		TestLogger.EnterFunction("Asteroid.MoveAsteroid");

		if(IsCloseToSun()){
			core.HandleCloseToSun(this);
		}

		TestLogger.ExitFunction();
	}

	/**
	 * Handles, when this explodes.
	 */
	public void Explode() {
	    TestLogger.EnterFunction("Asteroid.Explode");

		for (Worker w:workers) { //itt honnan van a worker????
			w.Explode();
		}

		for (SpaceObject so:neigbours) {
			so.RemoveNeighbour(this);
		}

		AsteroidField.GetInstance().RemoveAsteroid(this);

		TestLogger.ExitFunction();
	}

	/**
	 *
	 * @return true if, the asteroid has empty core and 0 layers
	 */
	public boolean CanHideIn() {
		TestLogger.EnterFunction("Asteroid.CanHideIn");
		Scanner sc = new Scanner(System.in);
		System.out.println("Can you hide in the asteroid? (y/n)");
		String answer = sc.nextLine();
		sc.close();
		TestLogger.ExitFunction();
		return answer.equals("y");
	}

	/**
	 * Adds the worker to workers list.
	 * @param worker
	 */
	public void AddWorker(Worker worker) {
		TestLogger.EnterFunction("Asteroid.AddWorker");
		workers.add(worker);
		TestLogger.ExitFunction();
	}

	/**
	 * Removes worker from worker list.
	 * @param worker worker to be removed from workers list
	 */
	public void RemoveWorker(Worker worker) {
		TestLogger.EnterFunction("Asteroid.RemoveWorker");
		workers.remove(worker);
		TestLogger.ExitFunction();
		System.out.println("Asteroid.RemoveWorker");
		workers.remove(worker);
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
	 * Removes spaceObject from neighbour list.
	 * @param spaceObject space object to be removed
	 */
	public void RemoveNeighbour(SpaceObject spaceObject) {
		TestLogger.EnterFunction("Asteroid.RemoveNeighbour");
		neigbours.remove(spaceObject);
		TestLogger.ExitFunction();
	}

	/**
	 * This method handles if, solarstorm hits the asteroid.
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
	 * @return true if, this is close to the sun
	 */
	public boolean IsCloseToSun() {
		TestLogger.EnterFunction("Asteroid.IsCloseToSun");
		Scanner sc = new Scanner(System.in);
		System.out.println("Am I close to the sun? (y/n)");
		String answer = sc.nextLine();
		sc.close();
		TestLogger.ExitFunction();
		return answer.equals("y");
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
