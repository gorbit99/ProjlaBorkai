package projlab.skeleton;

import java.util.Scanner;

/**
 * A program kezdőosztálya
 */
public class Main {


    public static void main(String[] args) {
        // Hozzunk létre egy skeleton modellt, majd kérdezzük meg a felhasználótól a választandó szcenárió id-jét
        Skeleton skeleton = new Skeleton();

        System.out.println("Kerlek valassz szcenariot (1-20):");
        Scanner scanner = new Scanner(System.in);

        int scenario = scanner.nextInt();
        System.out.print("Title: ");


        // Alakítsuk át a megadott indexet egy szcenárióvá
        switch (scenario) {
            case 1:
                skeleton.settlerMoveAsteroid();
                break;
            case 2:
                skeleton.settlerMoveTeleportGate();
                break;
            case 3:
                skeleton.settlerMines();
                break;
            case 4:
                skeleton.buildRobot();
                break;
            case 5:
                skeleton.buildTeleportGate();
                break;
            case 6:
                skeleton.placeDownTeleportGate();
                break;
            case 7:
                skeleton.placeDownNotRadioactiveOrWatericeResource();
                break;
            case 8:
                skeleton.placeDownRadioactive();
                break;
            case 9:
                skeleton.placeDownWaterIce();
                break;
            case 10:
                skeleton.robotMove();
                break;
            case 11:
                skeleton.robotMoveTeleportGate();
                break;
            case 12:
                skeleton.settlerDiggingWatericeAsteroid();
                break;
            case 13:
                skeleton.settlerDiggingRadioactiveAsteroid();
                break;
            case 14:
                skeleton.settlerDiggingNotRadioactiveOrWatericeAsteroid();
                break;
            case 15:
                skeleton.robotDiggingWatericeAsteroid();
                break;
            case 16:
                skeleton.robotDiggingRadioactiveAsteroid();
                break;
            case 17:
                skeleton.robotDiggingNotRadioactiveOrWatericeAsteroid();
                break;
            case 18:
                skeleton.solarFlare();
                break;
            case 19:
                skeleton.giveUp();
                break;
            case 20:
                skeleton.pass();
                break;
        }
    }
}
