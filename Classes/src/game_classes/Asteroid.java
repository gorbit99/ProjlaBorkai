package game_classes;


import java.util.ResourceBundle;
import java.util.Scanner;

public class Asteroid extends SpaceObject {
	private int layers;
	private float distanceFromSun;
	private Material core;
	private Asteroid neighbours;
	public void Drill() {
	}
	
	public Material Mine() {
	    TestLogger.EnterFunction("Asteroid.Mine");

	    TestLogger.ExitFunction();
		return null;
	}
	
	public boolean PlaceMaterial(Material material) {
		TestLogger.EnterFunction("Asteroid.PlaceMaterial");

		TestLogger.ExitFunction();
		return true;
	}
	
	public void MoveAsteroid() {
		TestLogger.EnterFunction("Asteroid.MoveAsteroid");

		TestLogger.ExitFunction();
	}
	
	public void Explode() {
	    TestLogger.EnterFunction("Asteroid.Explode");

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

		TestLogger.ExitFunction();
	}
	
	public void RemoveWorker(Worker worker) {
		TestLogger.EnterFunction("Asteroid.RemoveWorker");

		TestLogger.ExitFunction();
	}
	
	public void SetCore(Material material) {
	    TestLogger.EnterFunction("Asteroid.SetCore");

	    TestLogger.ExitFunction();
	}
	
	public void RemoveNeighbour(SpaceObject spaceObject) {
		TestLogger.EnterFunction("Asteroid.RemoveNeighbour");

		TestLogger.ExitFunction();
	}
	
	public void HandleSolarStorm() {
		TestLogger.EnterFunction("Asteroid.HandleSolarStorm");

		TestLogger.ExitFunction();
	}
	
	public boolean IsCloseToSun() {
		TestLogger.EnterFunction("Asteroid.IsCloseToSun");
		TestLogger.ExitFunction();
		return true;
	}


	@Override
	public String toString(){
		return "Asteroid";
	}
}
