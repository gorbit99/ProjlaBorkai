package game_classes;

/**
 * This class represents the material. This is the parent class of all materials.
 */
public abstract class Material {
	/**
	 * This is the constructor of the material.
	 */
	public Material(){
		TestLogger.EnterFunction("Material.ctor");
		TestLogger.ExitFunction();
	}
	/**
	 * This method handles, when the material gets closes to the sun.
	 * @param asteroid The asteroid is what contains this material.
	 */
	public void HandleCloseToSun(Asteroid asteroid) {
		TestLogger.EnterFunction("Material.HandleCloseToSun");
		TestLogger.ExitFunction();
	}
}
