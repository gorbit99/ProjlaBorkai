package game_classes;
import java.util.ArrayList;
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
        System.out.println("Initialization:");
        Astronaut a = new Astronaut();
        Robot r = new Robot();
        Game g = Game.GetInstance();
        AsteroidField af = AsteroidField.GetInstance();
        System.out.println("----------------------Starting point--------------------");
        printUseCases();
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        while (number != 0) {
            printUseCases();

            switch (number) {
                case 1:
                    a.Move();
                    break;
                case 2:
                    a.Move();
                    break;
                case 3:
                    a.Drill();
                    break;
                case 4:
                    a.Drill();
                    break;
                case 5:
                    a.Drill();
                    break;
                case 6:
                    a.Mine();
                    break;
                case 7:
                    a.PlaceMaterial();
                    break;
                case 8:
                    a.PlaceMaterial();
                    break;
                case 9:
                    a.PlaceMaterial();
                    break;
                case 10:
                    a.PlaceTeleporter();
                    break;
                case 11:
                    a.PlaceTeleporter();
                    break;
                case 12:
                    a.CreateTeleporter();
                    break;
                case 13:
                    a.CreateTeleporter();
                    break;
                case 14:
                    a.CreateRobot();
                    break;
                case 15:
                    a.CreateRobot();
                    break;
                case 16:
                    a.Wait();
                    break;
                case 17:
                    r.Move();
                    break;
                case 18:
                    r.Move();
                    break;
                case 19:
                    r.Drill();
                    break;
                case 20:
                    r.Drill();
                    break;
                case 21:
                    r.Drill();
                    break;
                case 22:
                    r.Wait();
                    break;
                case 23:
                    g.HandleSolarStorm();
                    break;
                case 24:
                    af.MoveAsteroids();
                    break;
                default:
                    System.out.println("Error!");
            }

            number = sc.nextInt();
        }
    }

    void TestScenario3() {
        Game.GetInstance();
        AsteroidField.GetInstance();
        Asteroid as = new Asteroid();
        Ice i = new Ice();
        Robot r = new Robot();
        Astronaut a = new Astronaut();
        AsteroidField.GetInstance().AddAsteroid(as);
        as.SetCore(i);
        Game.GetInstance().AddWorker(a);
        Game.GetInstance().AddWorker(r);
        as.AddWorker(a);
        as.AddWorker(r);
    }

    void TestScenario4() {
        Game.GetInstance();
        AsteroidField.GetInstance();
        Asteroid as = new Asteroid();
        Astronaut a = new Astronaut();
        AsteroidField.GetInstance().AddAsteroid(as);
        Game.GetInstance().AddWorker(a);
        as.AddWorker(a);
    }

    void TestScenario5() {
        Game.GetInstance();
        AsteroidField.GetInstance();
        Asteroid as = new Asteroid();
        Asteroid bs = new Asteroid();
        Teleporter t1 = new Teleporter();
        Teleporter t2 = new Teleporter();
        Astronaut a = new Astronaut();
        AsteroidField.GetInstance().AddAsteroid(as);
        AsteroidField.GetInstance().AddAsteroid(bs);
        t1.LinkTo(t2);
        t2.LinkTo(t1);
        t1.Place(as);
        ArrayList<Teleporter> teleporters = new ArrayList<>();
        teleporters.add(t2);
        a.SetTeleporters(teleporters);
        Game.GetInstance().AddWorker(a);
        bs.AddWorker(a);
    }

    void TestScenario6() {
        Game.GetInstance();
        AsteroidField.GetInstance();
        Asteroid as = new Asteroid();
        Asteroid bs = new Asteroid();
        Robot r1 = new Robot();
        Astronaut a1 = new Astronaut();
        AsteroidField.GetInstance().AddAsteroid(as);;
        AsteroidField.GetInstance().AddAsteroid(bs);;
        Game.GetInstance().AddWorker(a1);
        Game.GetInstance().AddWorker(r1);
        as.AddWorker(a1);
        as.AddWorker(r1);
        Astronaut a2 = new Astronaut();
        Robot r2 = new Robot();
        bs.AddWorker(a2);
        bs.AddWorker(r2);
    }
}
