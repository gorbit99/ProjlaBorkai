package game_classes;

import java.util.Scanner;
public class main {
    public static void printUseCases() {
        System.out.print("The following use cases are avilable:\n" +
                        "(1) Astronaut moves to asteroid\n" +
                        "(2) Astronaut moves to Teleporter\n" +
                        "(3) Astronaut drill regular\n" +
                        "(4) Astronaut drill radioactive\n" +
                        "(5) Astronaut drill vaporizing\n" +
                        "(6) Astronaut mine asteroid\n" +
                        "(7) Astronaut places regular\n" +
                        "(8) Astronaut places radioactive\n" +
                        "(9) Astronaut places vaporizing\n" +
                        "(10) Astronaut places teleporter\n" +
                        "(11) Astronaut places second teleporter\n" +
                        "(12) Astronaut creates teleporter pair\n" +
                        "(13) Astronaut create teleporter pair not enough materials\n" +
                        "(14) Astronaut create robot\n" +
                        "(15) Astronaut creates robot not enough materials\n" +
                        "(16) Astronaut wait\n" +
                        "(17) Robot moves to asteroid\n" +
                        "(18) Robot moves to teleporter\n" +
                        "(19) Robot drills regular\n" +
                        "(20) Robot drills radioactive\n" +
                        "(21) Robot drills vaporizing\n" +
                        "(22) Robot waits\n" +
                        "(23) Solarstorm happens\n" +
                        "(24) Asteroidfield moves\n");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        while (number != 0) {

            printUseCases();


            number = sc.nextInt();
        }
    }
}
