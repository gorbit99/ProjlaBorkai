package projlab.skeleton.utils;

import projlab.skeleton.resources.Resource;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Az építéshez kellő nyersanyagokat tároló objektum
 */
public class BillOfResources {

	/**
	 * A szükséges nyersanyagok
	 */
	private final ArrayList<Resource> resources = new ArrayList<>();

	/**
	 * Hozzáad egy nyersanyagot a listához
	 * @param resource A hozzáadandó nyersanyag
	 */
	public void addResource(Resource resource) {
	    FunctionPrinter.enter("BillOfResources", "addResource", this, resource);
		resources.add(resource);
	    FunctionPrinter.exit();
	}

	/**
	 * Ellenőrzi, hogy a megadott lista teljesíti-e a követelményeket
	 * @param resources A meglévő nyersanyagok listája
	 * @return Teljesíti-e a követelményeket a megadott lista
	 */
	public boolean isCompleted(ArrayList<Resource> resources) {
	    FunctionPrinter.enter("BillOfResources", "isCompleted", this, "resources");
	    FunctionPrinter.ask("Kesz van a megadott resource lista? (I/N)");
		boolean completed = new Scanner(System.in).next().equals("I");
	    FunctionPrinter.exit();
	    return completed;
	}
}
