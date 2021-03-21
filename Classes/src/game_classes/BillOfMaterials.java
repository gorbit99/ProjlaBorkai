package game_classes;

import java.util.Scanner;

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
		Scanner sc = new Scanner(System.in);
		System.out.println("Is there enough material? (y/n)");
		String answer = sc.nextLine();
		sc.close();
		TestLogger.ExitFunction();
		return answer.equals("y");
	}
}
