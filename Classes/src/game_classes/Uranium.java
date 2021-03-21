package game_classes;

public class Uranium extends Material{
	public Uranium(){
		TestLogger.EnterFunction("Uranium.ctor");
		TestLogger.ExitFunction();
	}
	public void HandleCloseToSun(Asteroid asteroid) {
		TestLogger.EnterFunction("Uranium.HandleCloseToSun");
		asteroid.Explode();
		TestLogger.ExitFunction();
	}
}
