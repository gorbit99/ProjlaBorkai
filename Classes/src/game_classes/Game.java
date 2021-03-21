package game_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This class conducts the game.
 */
public class Game {
    private ArrayList<Worker> workers;
    private SolarStorm solarStorm;
    private BillOfMaterials billOfMaterials;
    private static Random random;
    private static Game instance;

    /**
     * Constructor of the class
     */
    private Game() {
        TestLogger.EnterFunction("Game.ctor");
        TestLogger.ExitFunction();
        this.random = new Random();
        workers = new ArrayList<Worker>();
    }

    /**
     * @return the instance of the class
     */
    public static Game GetInstance() {
        TestLogger.EnterFunction("Game.GetInstance");
        if (instance == null)
            instance = new Game();
        TestLogger.ExitFunction();
        return instance;
    }

    /**
     * Creates a random number
     * @param bound upper bound of the number
     * @return a random number
     */
    public static int RandomNum(int bound) {
        return random.nextInt(bound);
    }

    /**
     *  Conducts a round in the game. Makes every worker do it's step, moves all asteroids, checks if the game is still winnable
     */
    public void DoRound() {
        TestLogger.EnterFunction("Game.DoRound");
        for (Worker w : workers){
            w.Step();
            CheckWinOrLose();
        }
        AsteroidField.GetInstance().MoveAsteroids();
        boolean solarStormHappens = solarStorm.Tick();
        if (solarStormHappens){
            HandleSolarStorm();
        }
        CheckWinOrLose();

        TestLogger.ExitFunction();
    }

    /**
     * Checks whether the game is still winnable
     */
    public void CheckWinOrLose() {
        TestLogger.EnterFunction("Game.CheckWinOrLose");
        ArrayList<Asteroid> asteroids = AsteroidField.GetInstance().GetAsteroids();
        ArrayList<Material> materials = new ArrayList<>();
        for(Asteroid aS : asteroids){
            materials.add(aS.GetCore());
        }
        for(Worker w : workers){
            Material[] m = w.GetStoredMaterials();
            Collections.addAll(materials, m);
        }
        billOfMaterials.IsEnough((Material[]) materials.toArray());
        TestLogger.ExitFunction();
    }

    /**
     * Handles a solar storm
     */
    public void HandleSolarStorm() {
        TestLogger.EnterFunction("Game.HandleSolarStorm");
        AsteroidField.GetInstance().HandleSolarStorm();
        TestLogger.ExitFunction();
    }

    /**
     * Registers a worker in the game
     * @param worker The worker to register
     */
    public void AddWorker(Worker worker) {
        TestLogger.EnterFunction("Game.AddWorker");
        workers.add(worker);
        TestLogger.ExitFunction();
    }

    /**
     * Removes a worker from the game
     * @param worker The worker to remove
     */
    public void RemoveWorker(Worker worker) {
        TestLogger.EnterFunction("Game.RemoveWorker");
        workers.remove(worker);
        TestLogger.ExitFunction();
    }

    /**
     * Starts the game.
     */
    public void StartGame() {
        TestLogger.EnterFunction("Game.StartGame");
        TestLogger.ExitFunction();
    }
}
