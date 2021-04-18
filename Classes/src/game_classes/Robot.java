package game_classes;

import java.util.ArrayList;

/**
 * represents a robot
 */
public class Robot extends Worker {
    /**
     * contains the materials that you need to build a robot
     */
    private static BillOfMaterials billOfMaterials;

    /**
     * robot constructor
     */
    public Robot(Asteroid position) {
        super(position);
        ArrayList<Material> materials = new ArrayList<Material>();
        materials.add(new Iron());
        materials.add(new Coal());
        materials.add(new Uranium());
        this.billOfMaterials = new BillOfMaterials(materials);
    }

    /**
     * controls the robots movements
     */
    public void Step() {
        boolean successful = false;
        while (!successful) {
            try {
                switch (Game.RandomNum(3)) {
                    case 1:
                        this.Move();
                        break;
                    case 2:
                        this.Drill();
                        break;
                    default:
                        this.Wait();
                        break;
                }
                successful = true;
            } catch (Exception e) {
                System.out.println("szar van");
            }
        }


    }

    /**
     * called when a asteroid explodes
     * moves robot to a random neighbour
     */
    public void Explode() {
        ArrayList<SpaceObject> neighbours = this.position.GetNeighbours();
        this.position.RemoveWorker(this);
        int to = Game.RandomNum(neighbours.size());
        neighbours.get(to).AddWorker(this);
    }

    /**
     * moves robot to a neighbour
     */
    public void Move() {
        ArrayList<SpaceObject> neighbours = this.position.GetNeighbours();
        int to = Game.RandomNum(neighbours.size());
        this.TravelTo(neighbours.get(to));
    }

    /**
     * Returns the materials stored by the robot (nothing)
     *
     * @return null
     */
    public ArrayList<Material> GetStoredMaterials() {
        return null;
    }

    /**
     * creates a robot
     *
     * @param materials materials going to be used for creating the robot
     * @return a new robot if the build was successful otherwise null
     */
    public static Robot CreateRobot(ArrayList<Material> materials, Asteroid position) {
        boolean enough = billOfMaterials.IsEnough(materials);
        if (enough)
            return new Robot(position);
        return null;
    }

}
