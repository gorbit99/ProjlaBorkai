package game_classes;

public class Ice extends Material{
	public Ice(){
		TestLogger.EnterFunction("Ice.ctor");
		TestLogger.ExitFunction();
	}

	public void HandleCloseToSun(Asteroid asteroid) {
		TestLogger.EnterFunction("Ice.HandleCloseToSun");
		asteroid.SetCore(null);
		TestLogger.ExitFunction();
	}
}
