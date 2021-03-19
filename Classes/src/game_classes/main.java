package game_classes;

import java.util.Scanner;
public class main {
    public static void printUseCases() {
        System.out.println("The following use cases are avilable:\n" +
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
                        "(24) Asteroidfield moves\n" +
                        "(0) Exit program\n" +
                        "Please type the number of the use-case you wish to run!");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        while (number != 0) {
            printUseCases();

            switch (number) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;
                case 12:

                    break;
                case 13:

                    break;
                case 14:

                    break;
                case 15:

                    break;
                case 16:

                    break;
                case 17:

                    break;
                case 18:

                    break;
                case 19:

                    break;
                case 20:

                    break;
                case 21:

                    break;
                case 22:

                    break;
                case 23:

                    break;
                case 24:

                    break;
                default:
                    System.out.println("Error!");
            }


            number = sc.nextInt();
        }
    }
}
