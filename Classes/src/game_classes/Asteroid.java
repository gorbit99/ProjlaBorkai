package game_classes;


import java.util.Scanner;

public class Asteroid extends SpaceObject {
	private int layers;
	private float distanceFromSun;
	private Material core;
	private Asteroid neighbours;
	public void Drill() {
	}
	
	public Material Mine() {
		return null;
	}
	
	public boolean PlaceMaterial(Material material) {
		return true;
	}
	
	public void MoveAsteroid() {
	}
	
	public void Explode() {
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
	}
	
	public void RemoveWorker(Worker worker) {
	}
	
	public void SetCore(Material material) {
	}
	
	public void RemoveNeighbour(SpaceObject spaceObject) {
	}
	
	public void HandleSolarStorm() {
	}
	
	public boolean IsCloseToSun() {
		return true;
	}


	@Override
	public String toString(){
		return "Asteroid";
	}
}
