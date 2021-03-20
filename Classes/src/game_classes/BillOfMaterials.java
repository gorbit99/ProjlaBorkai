package game_classes;


import java.util.Scanner;

public class BillOfMaterials {
	public boolean IsEnough(Material[] materials) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Is there enough material? (y/n)");
		String answer = sc.nextLine();
		sc.close();
		if (answer.equals("y"))
			return true;

		return false;
	}
}
