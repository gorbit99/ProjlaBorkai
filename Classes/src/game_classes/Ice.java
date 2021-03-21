package game_classes;

public class Ice extends Material{
	public Ice(){
		System.out.println("Ice.ctor");
	}
	public void HandleCloseToSun(Asteroid asteroid) {
		System.out.println("Ice.HandleCloseToSun");
		asteroid.SetCore(null);
	}
}
