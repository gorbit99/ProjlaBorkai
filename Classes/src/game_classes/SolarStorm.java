package game_classes;

import java.util.Scanner;

public class SolarStorm {

	public SolarStorm(){
		TestLogger.EnterFunction("SolarStorm.ctor");
		TestLogger.ExitFunction();
	}
	public boolean Tick() {
		TestLogger.EnterFunction("SolarStorm.Tick");
		Scanner sc = new Scanner(System.in);
		System.out.println("Is there a solarstorm? (y/n)");
		String answer = sc.nextLine();
		sc.close();
		TestLogger.ExitFunction();
		return answer.equals("y");
	}
}
