package game_classes;

public abstract class Material {

	public Material(){
		TestLogger.EnterFunction("Material.ctor");
		TestLogger.ExitFunction();
	}

	public void HandleCloseToSun(Asteroid asteroid) {
		TestLogger.EnterFunction("Material.HandleCloseToSun");
		TestLogger.ExitFunction();
	}
}
