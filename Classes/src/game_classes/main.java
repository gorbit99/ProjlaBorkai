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

        printUseCases();
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        while (number != 0) {

            switch (number) {
                case 1:
                    TestScenario1();
                    break;
                case 2:
                    TestScenario1();
                    break;
                case 3:
                    TestScenario1();
                    break;
                case 4:
                    TestScenario2();
                    break;
                case 5:
                    TestScenario3();
                    break;
                case 6:
                    TestScenario1();
                    break;
                case 7:
                    TestScenario4();
                    break;
                case 8:
                    TestScenario4();
                    break;
                case 9:
                    TestScenario4();
                    break;
                case 10:
                    TestScenario1();
                    break;
                case 11:
                    TestScenario5();
                    break;
                case 12:
                    TestScenario2();
                    break;
                case 13:
                    TestScenario1();
                    break;
                case 14:
                    TestScenario2();
                    break;
                case 15:
                    TestScenario1();
                    break;
                case 16:
                    TestScenario1();
                    break;
                case 17:
                    TestScenario1();
                    break;
                case 18:
                    TestScenario1();
                    break;
                case 19:
                    TestScenario1();
                    break;
                case 20:
                    TestScenario2();
                    break;
                case 21:
                    TestScenario3();
                    break;
                case 22:
                    TestScenario1();
                    break;
                case 23:
                    TestScenario6();
                    break;
                case 24:
                    TestScenario1();
                    break;
                default:
                    System.out.println("Error!");
            }

            printUseCases();
            number = sc.nextInt();
        }
    }

    public static void TestScenario1() {
        Game.GetInstance();
        AsteroidField af = AsteroidField.GetInstance();
        Asteroid as = new Asteroid();
        Asteroid bs = new Asteroid();
        Coal c = new Coal();
        Teleporter t1 = new Teleporter();
        Teleporter t2 = new Teleporter();
        Teleporter t3 = new Teleporter();
        Teleporter t4 = new Teleporter();
        Robot r = new Robot();
        Astronaut a = new Astronaut();
        af.AddAsteroid(as);
        af.AddAsteroid(bs);
        as.SetCore(c);
        t1.LinkTo(t2);
        t2.LinkTo(t1);
        t3.LinkTo(t4);
        t4.LinkTo(t3);
        t1.Place(as);
        t1.Place(bs);
        ArrayList<Teleporter> list = new ArrayList<Teleporter>();
        list.add(t1);
        list.add(t2);
        a.SetTeleporters(list);
        Game.GetInstance().AddWorker(a);
        Game.GetInstance().AddWorker(r);
        as.AddWorker(a);
        as.AddWorker(r);
    }

    public static void TestScenario2() {
        Game.GetInstance();
        AsteroidField af = AsteroidField.GetInstance();
        Asteroid as = new Asteroid();
        Asteroid bs = new Asteroid();
        Uranium u = new Uranium();
        Robot r = new Robot();
        Astronaut a = new Astronaut();
        af.AddAsteroid(as);
        af.AddAsteroid(bs);
        as.SetCore(u);
        Game.GetInstance().AddWorker(a);
        Game.GetInstance().AddWorker(r);
        as.AddWorker(a);
        as.AddWorker(r);
    }


    public static void TestScenario3() {
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

    public static void TestScenario4() {
        Game.GetInstance();
        AsteroidField.GetInstance();
        Asteroid as = new Asteroid();
        Astronaut a = new Astronaut();
        AsteroidField.GetInstance().AddAsteroid(as);
        Game.GetInstance().AddWorker(a);
        as.AddWorker(a);
    }

    public static void TestScenario5() {
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

    public static void TestScenario6() {
        Game.GetInstance();
        AsteroidField.GetInstance();
        Asteroid as = new Asteroid();
        Asteroid bs = new Asteroid();
        Robot r1 = new Robot();
        Astronaut a1 = new Astronaut();
        AsteroidField.GetInstance().AddAsteroid(as);
        ;
        AsteroidField.GetInstance().AddAsteroid(bs);
        ;
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

