package game_classes;


import java.util.Scanner;

public class Asteroid extends SpaceObject {
	private Material core;
	public Asteroid(){
	    TestLogger.EnterFunction("Asteroid.ctor");

	    TestLogger.ExitFunction();
	}

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
	
	public void MoveAsteroid() {
		TestLogger.EnterFunction("Asteroid.MoveAsteroid");

		if(IsCloseToSun()){
			core.HandleCloseToSun(this);
		}

		TestLogger.ExitFunction();
	}
	
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

	public boolean CanHideIn() {
		TestLogger.EnterFunction("Asteroid.CanHideIn");
		Scanner sc = new Scanner(System.in);
		System.out.println("Can you hide in the asteroid? (y/n)");
		String answer = sc.nextLine();
		sc.close();
		TestLogger.ExitFunction();
		return answer.equals("y");
	}
	
	public void AddWorker(Worker worker) {
		TestLogger.EnterFunction("Asteroid.AddWorker");
		workers.add(worker);
		TestLogger.ExitFunction();
	}
	
	public void RemoveWorker(Worker worker) {
		TestLogger.EnterFunction("Asteroid.RemoveWorker");
		workers.remove(worker);
		TestLogger.ExitFunction();
		workers.remove(worker);
	}
	
	public void SetCore(Material material) {
	    TestLogger.EnterFunction("Asteroid.SetCore");
		core = material;
	    TestLogger.ExitFunction();
	}
	
	public void RemoveNeighbour(SpaceObject spaceObject) {
		TestLogger.EnterFunction("Asteroid.RemoveNeighbour");
		neigbours.remove(spaceObject);
		TestLogger.ExitFunction();
	}
	
	public void HandleSolarStorm() {
		TestLogger.EnterFunction("Asteroid.HandleSolarStorm");
		if(!CanHideIn()){
			for (Worker w: workers) {
				w.Die();
			}
		}
		TestLogger.ExitFunction();
	}
	
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
	 * Gets the material inside the core of the asteroid
	 * @return The material in the core
	 */
	public Material GetCore() {
		TestLogger.EnterFunction("Asteroid.GetCore");
		TestLogger.ExitFunction();
		return core;
	}

	@Override
	public String toString(){
		return "Asteroid";
	}
}
