package game_classes;

import java.util.ArrayList;
import java.util.Random;

public class Robot extends Worker {
    private static BillOfMaterials billOfMaterials;


    private Robot(){
        TestLogger.EnterFunction("Robot.ctor");
        TestLogger.ExitFunction();
    }

    public void Step() {
        TestLogger.EnterFunction("Robot.Step");
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 1 -> this.Move();
            case 2 -> this.Drill();
            default -> this.Wait();
        }
        TestLogger.ExitFunction();
    }

    public void Explode() {
        TestLogger.EnterFunction("Robot.Explode");
        ArrayList<SpaceObject> neighbours = this.position.GetNeighbours();
        this.position.RemoveWorker(this);
        Random random = new Random();
        int to = random.nextInt(neighbours.size());
        neighbours.get(to).AddWorker(this);
        TestLogger.ExitFunction();
    }

    public void Move() {
        TestLogger.EnterFunction("Robot.Move");
        Random random = new Random();
        ArrayList<SpaceObject> neighbours = this.position.GetNeighbours();
        int to = random.nextInt(neighbours.size());
        this.TravelTo(neighbours.get(to));
        TestLogger.ExitFunction();
    }

    public static Robot CreateRobot(Material[] materials){
        TestLogger.EnterFunction("Robot.CreateRobot");
        boolean enough = billOfMaterials.IsEnough(materials);
        TestLogger.ExitFunction();
        if (enough)
            return new Robot();
        return null;
    }

}
