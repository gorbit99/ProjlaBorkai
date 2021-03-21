package game_classes;


import java.util.Scanner;

public class BillOfMaterials {
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
