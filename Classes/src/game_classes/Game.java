package game_classes;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private Astronaut players;
    private ArrayList<Worker> workers;
    private AsteroidField asteroidField;
    private SolarStorm solarStorm;
    private BillOfMaterials billOfMaterials;
    private static Random random;
    private static Game instance;

    private Game() {
        TestLogger.EnterFunction("Game.ctor");
        TestLogger.ExitFunction();
        this.random = new Random();
        workers = new ArrayList<Worker>();
    }

    public static Game GetInstance() {
        TestLogger.EnterFunction("Game.GetInstance");
        if (instance == null)
            instance = new Game();
        TestLogger.ExitFunction();
        return instance;
    }

    public static int RandomNum(int bound) {
        return random.nextInt(bound);
    }

    public void DoRound() {
        TestLogger.EnterFunction("Game.DoRound");
        TestLogger.ExitFunction();
    }

    public void CheckWinOrLose() {
        TestLogger.EnterFunction("Game.CheckWinOrlose");
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

    public void StartGame() {
        TestLogger.EnterFunction("Game.StartGame");
        TestLogger.ExitFunction();
    }
}
