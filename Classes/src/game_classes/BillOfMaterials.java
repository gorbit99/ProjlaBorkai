package game_classes;

/**
 * represents the which knows the right amount of materials for the creation of an object
 */
public class BillOfMaterials {
	/**
	 * decides whether there is enough materials to creat an object
	 * @param materials materials to be checked if they are enough
	 * @return true if there is enough materials false if there isn't
	 */
	public boolean IsEnough(Material[] materials) {
		TestLogger.EnterFunction("BillOfMaterials.IsEnough");
		String answer = TestLogger.AskQuestion("Is there enough material? (y/n)");
		TestLogger.ExitFunction();
		return answer.equals("y");
	}
}
