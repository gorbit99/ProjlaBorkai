package game_classes;

public class Uranium extends Material{
	public Uranium(){
		System.out.println("Uranium.ctor");
	}
	public void HandleCloseToSun(Asteroid asteroid) {
		System.out.println("Uranium.HandleCloseToSun");
		asteroid.Explode();
	}
}
