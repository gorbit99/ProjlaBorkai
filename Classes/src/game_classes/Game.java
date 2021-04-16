package game_classes;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents the game.
 */
public class Game {
    /**
     * This list contains workers.
     */
    private ArrayList<Worker> workers;
    /**
     * This is the solarstorm. It will make solarstorms.
     */
    private SolarStorm solarStorm;
    /**
     * This is the bill of materials, that you need to build a base.
     */
    private BillOfMaterials billOfMaterials;
    /**
     * This helps to make random things.
     */
    private static Random random;
    /**
     * This makes this class singleton.
     */
    private static Game instance;

    /**
     * This is the game's constructor.
     */
    private Game() {
        TestLogger.EnterFunction("Game.ctor");
        TestLogger.ExitFunction();
        this.random = new Random();
        workers = new ArrayList<Worker>();
    }

    /**
     * This helps the singleton.
     * @return
     */
    public static Game GetInstance() {
        TestLogger.EnterFunction("Game.GetInstance");
        if (instance == null)
            instance = new Game();
        TestLogger.ExitFunction();
        return instance;
    }

    /**
     * This makes random number.
     * @param bound This is the highest number, you can create.
     * @return Random number.
     */
    public static int RandomNum(int bound) {
        return random.nextInt(bound);
    }

    /**
     * This makes a round in the game.
     */
    public void DoRound() {
        TestLogger.EnterFunction("Game.DoRound");
        for (Worker w : workers){
            w.Step();
            CheckWinOrLose();
        }
        AsteroidField.GetInstance().Move();
        boolean solarStormHappens = solarStorm.Tick();
        if (solarStormHappens){
            HandleSolarStorm();
        }
        CheckWinOrLose();

        TestLogger.ExitFunction();
    }

    /**
     * This check the end of the game.
     */
    public void CheckWinOrLose() {
        TestLogger.EnterFunction("Game.CheckWinOrlose");
        ArrayList<SpaceObject> spaceObjects = AsteroidField.GetInstance().GetObjects();
        ArrayList<Material> materials = new ArrayList<>();
        for(SpaceObject object : spaceObjects){
            materials.add(object.GetCore());
        }
        for(Worker w : workers){
            Material[] m = w.GetStoredMaterials();
            for (int i = 0; i < m.length; i++){
                materials.add(m[i]);
            }
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
     * This starts the game
     */
    public void StartGame() {
        TestLogger.EnterFunction("Game.StartGame");
        TestLogger.ExitFunction();
    }

    /**
     * Returns the workers of th game
     * @return workers
     */
    public ArrayList<Worker> GetWorkers() {
        TestLogger.EnterFunction("Game.GetWorkers");
        TestLogger.ExitFunction();
        return workers;
    }
}