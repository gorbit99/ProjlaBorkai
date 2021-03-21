package game_classes;

/**
 * This class represents the uranium. It extends from material.
 */
public class Uranium extends Material{
	/**
	 * This is the constructor of the ice.
	 */
	public Uranium(){
		TestLogger.EnterFunction("Uranium.ctor");
		TestLogger.ExitFunction();
	}

	/**
	 * This method makes the asteroid explode.
	 * @param asteroid The asteroid is what contains this material.
	 */
	public void HandleCloseToSun(Asteroid asteroid) {
		TestLogger.EnterFunction("Uranium.HandleCloseToSun");
		asteroid.Explode();
		TestLogger.ExitFunction();
	}

	/**
	 *
	 * @return The class name.
	 */
	public String toString(){
		return "Uranium";
	}
}
