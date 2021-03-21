package game_classes;

/**
 * Ez az abstrakt osztály az őse az összes nyersanyagnak.
 */
public abstract class Material {

	public Material(){
		System.out.println("Material.ctor");
	}
	/**
	 *
	 * @param asteroid
	 */
	public void HandleCloseToSun(Asteroid asteroid) {
		System.out.println("Material.HandleCloseToSun");
	}
}
