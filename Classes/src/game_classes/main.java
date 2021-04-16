package game_classes;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static Astronaut a;
    static Robot r;

    /**
     * Print the usecases dialog for the tester
     */
    public static void printUseCases() {
        System.out.println("The following use cases are available:\n" +
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
                        "(13) Astronaut create robot\n" +
                        "(14) Astronaut wait\n" +
                        "(15) Robot moves to asteroid\n" +
                        "(16) Robot moves to teleporter\n" +
                        "(17) Robot drills regular\n" +
                        "(18) Robot drills radioactive\n" +
                        "(19) Robot drills vaporizing\n" +
                        "(20) Robot waits\n" +
                        "(21) Solarstorm happens\n" +
                        "(22) Asteroidfield moves\n" +
                        "(0) Exit program\n" +
                        "Please type the number of the use-case you wish to run!");
    }

    /**
     * The main function
     * @param args Program arguments
     */
    public static void main(String[] args) {
        printUseCases();

        Scanner sc = new Scanner(System.in);
        boolean correctEntered = false;
        int number = 0;
        while (!correctEntered) {
            try {
                number = sc.nextInt();
                correctEntered = true;
            } catch (Exception e) {
                System.out.println("You entered something that wasn't a number!");
            }
        }

        while (number != 0) {

            switch (number) {
                //Astronaut moves to Asteroid
                case 1:
                    TestScenario1();
                    a.Move();
                    break;
                //Astronaut moves to Teleporter
                case 2:
                    TestScenario1();
                    a.Move();
                    break;
                //Astronaut drill regular
                case 3:
                    TestScenario1();
                    a.Drill();
                    break;
                //Astronaut drill radioactive
                case 4:
                    TestScenario2();
                    a.Drill();
                    break;
                //Astronaut drill vaporizing
                case 5:
                    TestScenario3();
                    a.Drill();
                    break;
                //Astronaut mine asteroid
                case 6:
                    TestScenario1();
                    a.Mine();
                    break;
                //Astronaut places regular
                case 7:
                    TestScenario4();
                    a.PlaceMaterial();
                    break;
                //Astronaut places radioactive
                case 8:
                    TestScenario4();
                    a.PlaceMaterial();
                    break;
                //Astronaut places vaporizing
                case 9:
                    TestScenario4();
                    a.PlaceMaterial();
                    break;
                //Astronaut places teleporter
                case 10:
                    TestScenario1();
                    a.PlaceTeleporter();
                    break;
                //Astronaut places second teleporter
                case 11:
                    TestScenario5();
                    a.PlaceTeleporter();
                    break;
                //Astronaut creates teleporter pair
                case 12:
                    TestScenario2();
                    a.CreateTeleporter();
                    break;
                //Astronaut creates robot
                case 13:
                    TestScenario2();
                    a.CreateRobot();
                    break;
                //Astronaut wait
                case 14:
                    TestScenario1();
                    a.Wait();
                    break;
                //Robot moves to asteroid
                case 15:
                    TestScenario1();
                    r.Move();
                    break;
                //Robot moves to Teleporter
                case 16:
                    TestScenario1();
                    r.Move();
                    break;
                //Robot drills regular
                case 17:
                    TestScenario1();
                    r.Drill();
                    break;
                //Robot drills radioactive
                case 18:
                    //Robot drills radioactive
                    TestScenario2();
                    r.Drill();
                    break;
                //Robot drills vaporizing
                case 19:
                    TestScenario3();
                    r.Drill();
                    break;
                //Robot waits
                case 20:
                    TestScenario1();
                    r.Wait();
                    break;
                //SolarStorm happens
                case 21:
                    TestScenario6();
                    Game.GetInstance().HandleSolarStorm();
                    break;
                //Asteroidfield moves
                case 22:
                    TestScenario1();
                    AsteroidField.GetInstance().Move();
                    break;
                default:
                    System.out.println("You entered an incorrect testcase number!");
            }

            Reset();
            String ans = TestLogger.AskQuestion("Do you want to continue? (y/n)");
            if (ans.equals("n")) {
                break;
            }
            printUseCases();
            number = sc.nextInt();
        }
    }

    /**
     * Initializing for the 1st scenario
     */
    static void TestScenario1() {
        System.out.println("Initializing");
        Game.GetInstance();
        AsteroidField af = AsteroidField.GetInstance();
        Asteroid as = new Asteroid();
        Asteroid bs = new Asteroid();
        Coal c = new Coal();
        Teleporter t1 = new Teleporter();
        Teleporter t2 = new Teleporter();
        Teleporter t3 = new Teleporter();
        Teleporter t4 = new Teleporter();
        r = new Robot();
        a = new Astronaut();
        af.AddAsteroid(as);
        af.AddAsteroid(bs);
        as.SetCore(c);
        t1.LinkTo(t2);
        t2.LinkTo(t1);
        t3.LinkTo(t4);
        t4.LinkTo(t3);
        t1.Place(as);
        t2.Place(bs);
        ArrayList<Teleporter> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        a.SetTeleporters(list);
        Game.GetInstance().AddWorker(a);
        Game.GetInstance().AddWorker(r);
        a.TravelTo(as);
        r.TravelTo(as);
        as.AddNeighbour(bs);
        bs.AddNeighbour(as);
        System.out.println("\nTest starts here");
    }

    /**
     * Initializing for the 2nd scenario
     */
    static void TestScenario2() {
        System.out.println("Initializing");
        Game.GetInstance();
        AsteroidField af = AsteroidField.GetInstance();
        Asteroid as = new Asteroid();
        Asteroid bs = new Asteroid();
        Uranium u = new Uranium();
        r = new Robot();
        a = new Astronaut();
        af.AddAsteroid(as);
        af.AddAsteroid(bs);
        as.SetCore(u);
        Game.GetInstance().AddWorker(a);
        Game.GetInstance().AddWorker(r);
        a.TravelTo(as);
        r.TravelTo(as);
        as.AddNeighbour(bs);
        bs.AddNeighbour(as);
        System.out.println("\nTest starts here");
    }

    /**
     * Initializing for the 3rd scenario
     */
    static void TestScenario3() {
        System.out.println("Initializing");
        Game.GetInstance();
        AsteroidField.GetInstance();
        Asteroid as = new Asteroid();
        Ice i = new Ice();
        r = new Robot();
        a = new Astronaut();
        AsteroidField.GetInstance().AddAsteroid(as);
        as.SetCore(i);
        Game.GetInstance().AddWorker(a);
        Game.GetInstance().AddWorker(r);
        a.TravelTo(as);
        r.TravelTo(as);
        System.out.println("\nTest starts here");
    }

    /**
     * Initializing for the 4th scenario
     */
    static void TestScenario4() {
        System.out.println("Initializing");
        Game.GetInstance();
        AsteroidField.GetInstance();
        Asteroid as = new Asteroid();
        a = new Astronaut();
        AsteroidField.GetInstance().AddAsteroid(as);
        Game.GetInstance().AddWorker(a);
        a.TravelTo(as);
        Ice i = new Ice();
        Uranium u = new Uranium();
        Coal c = new Coal();
        a.SetStoredMaterials(new Material[]{i, c, u});
        System.out.println("\nTest starts here");
    }

    /**
     * Initializing for the 5th scenario
     */
    static void TestScenario5() {
        System.out.println("Initializing");
        Game.GetInstance();
        AsteroidField.GetInstance();
        Asteroid as = new Asteroid();
        Asteroid bs = new Asteroid();
        Teleporter t1 = new Teleporter();
        Teleporter t2 = new Teleporter();
        a = new Astronaut();
        AsteroidField.GetInstance().AddAsteroid(as);
        AsteroidField.GetInstance().AddAsteroid(bs);
        t1.LinkTo(t2);
        t2.LinkTo(t1);
        t1.Place(as);
        ArrayList<Teleporter> teleporters = new ArrayList<>();
        teleporters.add(t2);
        a.SetTeleporters(teleporters);
        Game.GetInstance().AddWorker(a);
        a.TravelTo(bs);
        as.AddNeighbour(bs);
        bs.AddNeighbour(as);
        System.out.println("\nTest starts here");
    }

    /**
     * Initializing for the 6th scenario
     */
    static void TestScenario6() {
        System.out.println("Initializing");
        Game.GetInstance();
        AsteroidField.GetInstance();
        Asteroid as = new Asteroid();
        Asteroid bs = new Asteroid();
        Robot r1 = new Robot();
        Astronaut a1 = new Astronaut();
        AsteroidField.GetInstance().AddAsteroid(as);
        AsteroidField.GetInstance().AddAsteroid(bs);
        Game.GetInstance().AddWorker(a1);
        Game.GetInstance().AddWorker(r1);
        a1.TravelTo(as);
        r1.TravelTo(as);
        Astronaut a2 = new Astronaut();
        Robot r2 = new Robot();
        a2.TravelTo(bs);
        r2.TravelTo(bs);
        as.AddNeighbour(bs);
        bs.AddNeighbour(as);
        System.out.println("\nTest starts here");
    }

    /**
     * Destroys every object created in a use-case.
     */
    static void Reset() {
        System.out.println("\nClearing created objects");
        Game.GetInstance().GetWorkers().clear();
        AsteroidField.GetInstance().GetObjects().clear();
        a = null;
        r = null;
    }
}

