package projlab.skeleton.resources;

import projlab.skeleton.map.Asteroid;
import projlab.skeleton.utils.FunctionPrinter;

/**
 * A vízjég nyersanyagot jelképező osztály
 */
public class WaterIce extends Resource {
	/**
	 * Ha az aszteroida, amiben a nyersanyag van napközeli és a nyersanyag felszínre kerül,
	 * akkor a nyersanyag úgy reagál, hogy elszublimál(eltűnik)
	 * @param a Az az aszteroida, amiben a nyersanyag van
	 */
	@Override
	public void reaction(Asteroid a) {
		FunctionPrinter.enter("WaterIce", "reaction", this, a);
		a.setResource(null);
		FunctionPrinter.exit();
	}

}
