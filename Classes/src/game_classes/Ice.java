package game_classes;

/**
 * This class represents the ice. It extends from material.
 */
public class Ice extends Material{
	/**
	 * This is the constructor of the ice.
	 */
	public Ice(){
		TestLogger.EnterFunction("Ice.ctor");
		TestLogger.ExitFunction();
	}

	/**
	 * This vaporise the ice, when the asteroid is close to the sun.
	 * @param asteroid The asteroid is what contains this material.
	 */
	public void HandleCloseToSun(Asteroid asteroid) {
		TestLogger.EnterFunction("Ice.HandleCloseToSun");
		asteroid.SetCore(null);
		TestLogger.ExitFunction();
	}
	/**
	 *
	 * @return The class name.
	 */
	public String toString(){
		return "Ice";
	}
}
