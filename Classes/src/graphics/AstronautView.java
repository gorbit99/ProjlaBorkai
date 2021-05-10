package graphics;

import game_classes.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.util.ArrayList;

public class AstronautView {
    /**
     * image view of the controller
     * and the astronaut which belong sto the controller
     */
    private final ImageView imageView;
    private final Astronaut astronaut;

    /**
     * constructor of AstronautView class
     * @param astronaut the astronaut which belongs to the controller
     */
    public AstronautView(Astronaut astronaut) {
        imageView = new ImageView(new Image("/Pictures/spaceship.png"));
        GameController.getInstance().getAsteroidFieldGroup().getChildren().add(imageView);
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);
        this.astronaut = astronaut;
    }

    public void DrawAstronaut(Astronaut astronaut) {
        SpaceObjectController spaceObjectController =
                SpaceObjectController.controllerFromSpaceObject(astronaut.getPosition());

        int id = AsteroidView.getNextEntityId(astronaut.getPosition());
        Point position = ((AsteroidView)spaceObjectController.getView()).getEntityPosition(id);

        imageView.setLayoutX(position.x);
        imageView.setLayoutY(position.y);
    }

    /**
     * Decides which button is active during a player's turn
     */
    public void SetButtonStatus() {
        Asteroid asteroid = astronaut.getPosition();
        if (asteroid.GetLayers() == 0)
            GameController.getInstance().getDrillBtn().setDisable(false);

        if (asteroid.GetLayers() == 0 && asteroid.GetCore() != null)
            GameController.getInstance().getMineBtn().setDisable(false);

        if (asteroid.GetLayers() == 0 && asteroid.GetCore() == null)
            GameController.getInstance().getPlaceBtn().setDisable(false);

        ArrayList<Material> receiptRobot = new ArrayList<>();
        receiptRobot.add(new Iron());
        receiptRobot.add(new Coal());
        receiptRobot.add(new Uranium());
        BillOfMaterials billOfMaterialsRobot=new BillOfMaterials(receiptRobot);
        if (billOfMaterialsRobot.IsEnough(astronaut.GetStoredMaterials()))
            GameController.getInstance().getRobotBtn().setDisable(false);


        ArrayList<Material> materialsTeleport = new ArrayList<>();
        materialsTeleport.add(new Iron());
        materialsTeleport.add(new Iron());
        materialsTeleport.add(new Ice());
        materialsTeleport.add(new Uranium());
        BillOfMaterials billOfMaterialsTeleport = new BillOfMaterials(materialsTeleport);

        if (billOfMaterialsTeleport.IsEnough(astronaut.GetStoredMaterials()))
            GameController.getInstance().getTeleportBtn().setDisable(false);

    }
}
