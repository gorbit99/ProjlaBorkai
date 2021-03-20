package game_classes;


public class Game {
    private Astronaut players;
    private Worker workers;
    private AsteroidField asteroidField;
    private SolarStorm solarStorm;
    private BillOfMaterials billOfMaterials;
    private static Game instance;

    private Game() {
        System.out.println("Game.ctor");

    }

    public static Game GetInstance() {
        if (instance == null)
            instance = new Game();
        return instance;
    }

    public void DoRound() {
    }

    public void CheckWinOrLose() {
    }

    public void HandleSolarStorm() {
    }

    public void AddWorker(Worker worker) {
    }

    public void RemoveWorker(Worker worker) {
    }

    public void StartGame() {
    }
}
