package game_classes;


public class Game {
    private Astronaut players;
    private Worker workers;
    private AsteroidField asteroidField;
    private SolarStorm solarStorm;
    private BillOfMaterials billOfMaterials;
    private static Game instance;

    private Game() {
        TestLogger.EnterFunction("Game.ctor");
        TestLogger.ExitFunction();
    }

    public static Game GetInstance() {
        TestLogger.EnterFunction("Game.GetInstance");
        if (instance == null)
            instance = new Game();
        TestLogger.ExitFunction();
        return instance;
    }

    public void DoRound() {
        TestLogger.EnterFunction("Game.DoRound");
        TestLogger.ExitFunction();
    }

    public void CheckWinOrLose() {
        TestLogger.EnterFunction("Game.CheckWinOrlose");
        TestLogger.ExitFunction();
    }

    public void HandleSolarStorm() {
        TestLogger.EnterFunction("Game.HandleSolarStorm");
        TestLogger.ExitFunction();
    }

    public void AddWorker(Worker worker) {
        TestLogger.EnterFunction("Game.AddWorker");
        TestLogger.ExitFunction();
    }

    public void RemoveWorker(Worker worker) {
        TestLogger.EnterFunction("Game.RemoveWorker");
        TestLogger.ExitFunction();
    }

    public void StartGame() {
        TestLogger.EnterFunction("Game.StartGame");
        TestLogger.ExitFunction();
    }
}
