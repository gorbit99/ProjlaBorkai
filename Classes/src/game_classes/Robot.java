package game_classes;

import java.util.ArrayList;
import java.util.Random;

public class Robot extends Worker {
    private BillOfMaterials billOfMaterials;

    public void Step() {
        System.out.println("Robot.Step");
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 1:
                this.Move();
                break;
            case 2:
                this.Drill();
                break;
            default:
                this.Wait();
        }
    }

    public void Explode() {
        System.out.println("Robot.Explode");
        ArrayList<SpaceObject> neighbours = this.position.GetNeighbours();
        this.position.RemoveWorker(this);
        Random random=new Random();
        int to = random.nextInt(neighbours.size());
        neighbours.get(to).AddWorker(this);
    }

    public void Move() {
        System.out.println("Robot.Move");
        Random random=new Random();
        ArrayList<SpaceObject> neighbours = this.position.GetNeighbours();
        int to = random.nextInt(neighbours.size());
        this.TravelTo(neighbours.get(to));
    }

}
