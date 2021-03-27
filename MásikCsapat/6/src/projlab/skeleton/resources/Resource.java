package projlab.skeleton.resources;

import projlab.skeleton.map.Asteroid;
import projlab.skeleton.utils.FunctionPrinter;

/**
 * A nyersanyagokat jelképező absztrakt osztály
 */
public abstract class Resource {
	/**
	 * A napközeli aszteroidán felszínre kerülő nyersanyag reakcióját feldolgozó metódus
	 * @param a Az az aszteroida, amiben a nyersanyag van
	 */
	public void reaction(Asteroid a) {
		FunctionPrinter.enter("Resource", "reaction", this, a);
		FunctionPrinter.exit();
	}
}
