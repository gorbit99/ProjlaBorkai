package game_classes;


import java.util.Scanner;

public class Asteroid extends SpaceObject {
	private Material core;
	public Asteroid(){
		System.out.println("Asteroid.ctor");
	}

	public void Drill() {
		System.out.println("Asteroid.Drill");

		Scanner sc = new Scanner(System.in);
		System.out.println("Do I still have layers? (y/n)");
		String answer = sc.nextLine();
		sc.close();
		if (answer.equals("y")){
			if (IsCloseToSun())
				core.HandleCloseToSun(this);
		}
	}
	
	public Material Mine() {
		System.out.println("Asteroid.Mine");

		Scanner sc = new Scanner(System.in);
		System.out.println("Is 1 or more layer on me? (y/n)");
		String answer = sc.nextLine();
		sc.close();
		if (answer.equals("y")){
			return null;
		}
		core=null;
		return core;
	}
	
	public boolean PlaceMaterial(Material material) {
		System.out.println("Asteroid.PlaceMaterial");

		if(material!=null){
			core=material;
			if(IsCloseToSun()){
				core.HandleCloseToSun(this);
			}
		}

		return material==null;
	}
	
	public void MoveAsteroid() {
		System.out.println("Asteroid.MoveAsteroid");

		if(IsCloseToSun()){
			core.HandleCloseToSun(this);
		}
	}
	
	public void Explode() {
		System.out.println("Asteroid.Explode");

		for (Worker w:workers) { //itt honnan van a worker????
			w.Explode();
		}

		for (SpaceObject so:neigbours) {
			so.RemoveNeighbour(this);
		}

		AsteroidField.GetInstance().RemoveAsteroid(this);
	}

	public boolean CanHideIn() {
		System.out.println("Asteroid.CanHideIn");
		Scanner sc = new Scanner(System.in);
		System.out.println("Can you hide in the asteroid? (y/n)");
		String answer = sc.nextLine();
		sc.close();
		if (answer.equals("y"))
			return true;

		return false;
	}
	
	public void AddWorker(Worker worker) {
		System.out.println("Asteroid.AddWorker");
		workers.add(worker);
	}
	
	public void RemoveWorker(Worker worker) {
		System.out.println("Asteroid.RemoveWorker");
		workers.remove(worker);
	}
	
	public void SetCore(Material material) {
		System.out.println("Asteroid.SetCore");
		core=material;
	}
	
	public void RemoveNeighbour(SpaceObject spaceObject) {
		System.out.println("Asteroid.RemoveNeighbour");
		neigbours.remove(spaceObject);
	}
	
	public void HandleSolarStorm() {
		System.out.println("Asteroid.HandleSolarStorm");
		if(!CanHideIn()){
			for (Worker w: workers) {
				w.Die();
			}
		}
	}
	
	public boolean IsCloseToSun() {
		System.out.println("Asteroid.IsCloseToSun");

		Scanner sc = new Scanner(System.in);
		System.out.println("Am I close to the sun? (y/n)");
		String answer = sc.nextLine();
		sc.close();
		if (answer.equals("y"))
			return true;
		return false;
	}


	@Override
	public String toString(){
		return "Asteroid";
	}
}
