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
    private SolarStorm solarStorm = new SolarStorm();
    /**
     * This is the bill of materials, that you need to build a base.
     */
    private BillOfMaterials billOfMaterials;
    /**
     * This helps to make random nums
     */
    private static Random random = new Random();
    /**
     * the instance of the singleton class
     */
    private static Game instance;
    /**
     * represents if the players won or not
     * true if they won
     */
    private boolean win;
    /**
     * represents if the players lost or not
     * true if they lost
     */
    private boolean lose;

    /**
     * This is the game's constructor.
     */
    private Game() {
        this.random = new Random();
        workers = new ArrayList<>();
        if (billOfMaterials == null) {
            ArrayList<Material> materials = new ArrayList<>();
            materials.add(new Iron());
            materials.add(new Iron());
            materials.add(new Coal());
            materials.add(new Coal());
            materials.add(new Uranium());
            materials.add(new Uranium());
            materials.add(new Ice());
            materials.add(new Ice());
            billOfMaterials = new BillOfMaterials(materials);
        }
    }

    /**
     * This helps the singleton.
     *
     * @return
     */
    public static Game GetInstance() {
        if (instance == null)
            instance = new Game();
        return instance;
    }

    /**
     * This makes random number.
     *
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
        for (Worker worker : this.workers) {
            worker.Step();
            CheckWinOrLose();
        }
        AsteroidField.GetInstance().Move();
        if (this.solarStorm.Tick())
            AsteroidField.GetInstance().HandleSolarStorm();
        CheckWinOrLose();
    }

    /**
     * This check the end of the game.
     */
    public void CheckWinOrLose() {
        ArrayList<Material> materialSum = new ArrayList<>();
        for (SpaceObject object : AsteroidField.GetInstance().GetObjects()) {
            for (Worker worker : object.GetWorkers()) {
                for (Material material : worker.GetStoredMaterials()) {
                    materialSum.add(material);

                }
            }
        }
        if (this.billOfMaterials.IsEnough(materialSum)) {
            this.win = true;
            return;
        }
        ArrayList<Material> coreSum = new ArrayList<>();

        for (SpaceObject object : AsteroidField.GetInstance().GetObjects()) {
            if (object.GetCore() != null)
                coreSum.add(object.GetCore());
        }
        if (!this.billOfMaterials.IsEnough(coreSum)) {
            this.lose = true;
        }

    }

    /**
     * Handles a solar storm
     */
    public void HandleSolarStorm() {
        AsteroidField.GetInstance().HandleSolarStorm();
    }

    /**
     * Registers a worker in the game
     *
     * @param worker The worker to register
     */
    public void AddWorker(Worker worker) {
        workers.add(worker);
    }

    /**
     * Removes a worker from the game
     *
     * @param worker The worker to remove
     */
    public void RemoveWorker(Worker worker) {
        workers.remove(worker);
    }

    /**
     * function that starts the game
     */
    public void StartGame() {

    }

    /**
     * Returns the workers of th game
     * @return workers
     */
    public ArrayList<Worker> GetWorkers() {
        return workers;
    }

    /**
     * returns the solar storm of the game
     * @return solarstorm of the game
     */
    public SolarStorm GetSolarStorm() {
        return solarStorm;
    }
}