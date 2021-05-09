package graphics;

import game_classes.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class AstronautView {
    private ImageView imageView;
    private Astronaut astronaut;

    public AstronautView(Astronaut astronaut) {
        imageView.setImage(new Image("/Pictures/spaceship.png"));
        this.astronaut = astronaut;
    }

    public void DrawAstronaut(Astronaut astronaut) {

    }

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
