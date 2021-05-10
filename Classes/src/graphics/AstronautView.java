package graphics;

import game_classes.*;
import javafx.event.EventType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.util.ArrayList;

public class AstronautView {
    /**
     * image view of the controller
     * and the astronaut which belong sto the controller
     */
    private final ImageView imageView;
    private final Astronaut astronaut;
    private final AstronautController astronautController;

    private boolean move_ButtonSubscribe = true; //todo ehhez még nincs semmi
    private boolean drill_ButtonSubscribe = false;
    private boolean mine_ButtonSubscribe = false;
    private boolean place_ButtonSubscribe = false;
    private boolean crtRobot_ButtonSubscribe = false;
    private boolean crtTeleport_ButtonSubscribe = false;
    private boolean wait_ButtonSubscribe = false; //todo ehhez még nincs semmi
    private Asteroid oldPosition = null;

    /**
     * constructor of AstronautView class
     *
     * @param astronaut the astronaut which belongs to the controller
     */
    public AstronautView(Astronaut astronaut, AstronautController astronautController) {
        imageView = new ImageView(new Image("/Pictures/spaceship.png"));
        GameController.getInstance().getAsteroidFieldGroup().getChildren().add(imageView);
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);
        this.astronaut = astronaut;
        this.astronautController = astronautController;
    }

    public void DrawAstronaut(Astronaut astronaut) {
        SpaceObjectController spaceObjectController =
                SpaceObjectController.controllerFromSpaceObject(astronaut.getPosition());

        int id = AsteroidView.getNextEntityId(astronaut.getPosition());
        Point position = ((AsteroidView) spaceObjectController.getView()).getEntityPosition(id);

        imageView.setLayoutX(position.x);
        imageView.setLayoutY(position.y);
    }

    /**
     * Decides which button is active during a player's turn
     */
    public void SetButtonStatus() {
        GameController.getInstance().getPlayerId().setText("P" + astronaut.getAstronautId());

        Asteroid asteroid = astronaut.getPosition();

        GameController.getInstance().getWaitBtn().setOnAction(this.astronautController.WaitEventHandler);
        GameController.getInstance().getMoveBtn().setOnAction(this.astronautController.MoveEventHandler);


        if (asteroid.GetLayers() != 0) {
            GameController.getInstance().getDrillBtn().setDisable(false);
            GameController.getInstance().getDrillBtn().setOnAction(this.astronautController.DrillEventHandler);

            drill_ButtonSubscribe = true;
        }
        //GameController.getInstance().getDrillBtn().setOnAction(this.astronautController.DrillEventHandler);
        if (asteroid.GetLayers() == 0 && asteroid.GetCore() != null) {
            GameController.getInstance().getMineBtn().setDisable(false);
            GameController.getInstance().getMineBtn().setOnAction(this.astronautController.MineEventHandler);
            mine_ButtonSubscribe = true;
        }

        if (asteroid.GetLayers() == 0 && asteroid.GetCore() == null && astronaut.GetStoredMaterials().size() != 0) {
            GameController.getInstance().getPlaceBtn().setDisable(false);
            GameController.getInstance().getPlaceBtn().setOnAction(this.astronautController.PlaceEventHandler);
            place_ButtonSubscribe = true;
        }

        ArrayList<Material> receiptRobot = new ArrayList<>();
        receiptRobot.add(new Iron());
        receiptRobot.add(new Coal());
        receiptRobot.add(new Uranium());
        BillOfMaterials billOfMaterialsRobot = new BillOfMaterials(receiptRobot);
        if (billOfMaterialsRobot.IsEnough(astronaut.GetStoredMaterials())) {
            GameController.getInstance().getRobotBtn().setDisable(false);
            //GameController.getInstance().getRobotBtn().setOnAction(this.astronautController.RobotEventHandler);
            crtRobot_ButtonSubscribe = true;
        }


        ArrayList<Material> materialsTeleport = new ArrayList<>();
        materialsTeleport.add(new Iron());
        materialsTeleport.add(new Iron());
        materialsTeleport.add(new Ice());
        materialsTeleport.add(new Uranium());
        BillOfMaterials billOfMaterialsTeleport = new BillOfMaterials(materialsTeleport);
        if (billOfMaterialsTeleport.IsEnough(astronaut.GetStoredMaterials())) {
            GameController.getInstance().getTeleportBtn().setDisable(false);
            //GameController.getInstance().getTeleportBtn().setOnAction(this.astronautController.TeleportEventHandler);
            crtTeleport_ButtonSubscribe = true;
        }
    }

    public void Unsubscribe() {

        astronaut.GetChangeEvent().firePropertyChange("InActiveAstronaut", null, this);


        GameController.getInstance().getMoveBtn().setOnAction(null);
        GameController.getInstance().getWaitBtn().setOnAction(null);


        if (drill_ButtonSubscribe) {
            GameController.getInstance().getDrillBtn().setOnAction(null);
            GameController.getInstance().getDrillBtn().setDisable(true);

        }
        if (mine_ButtonSubscribe) {
            GameController.getInstance().getMineBtn().setOnAction(null);
            GameController.getInstance().getMineBtn().setDisable(true);

        }
        if (place_ButtonSubscribe) {
            GameController.getInstance().getPlaceBtn().setOnAction(null);
            GameController.getInstance().getPlaceBtn().setDisable(true);

        }
        if (crtRobot_ButtonSubscribe) {
            //GameController.getInstance().getRobotBtn(,this.astronautController.???)
            //GameController.getInstance().getDrillBtn().setDisable(false);
        }
        if (crtTeleport_ButtonSubscribe) {
            // GameController.getInstance().getTeleportBtn()
            //            GameController.getInstance().getDrillBtn().setDisable(false);
        }

    }

    public void SubscribeToSpaceObjects(){
        oldPosition = astronaut.getPosition();
        ArrayList<SpaceObject> neighbours = oldPosition.GetNeighbours();

        for (SpaceObject so : neighbours){
            SpaceObjectController.controllerFromSpaceObject(so).getView().imageView.setOnMouseClicked(event -> astronautController.TravelToWrapper(so));
        }
    }

    public void UnSubscribeFromSpaceObjects(){
        for(SpaceObject so : oldPosition.GetNeighbours()){
            SpaceObjectController soc = SpaceObjectController.controllerFromSpaceObject(so);
            soc.getView().imageView.setOnMouseClicked(null);
        }
    }

    private void drawInventory() {
        ArrayList<Material> inventory = astronaut.GetStoredMaterials();
        int size = inventory.size();
        if (size == 0)
            return;


    }
}
