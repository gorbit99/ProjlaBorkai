package graphics;

import game_classes.Ufo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

/**
 * View for the ufos
 */
public class UfoView {
    private final ImageView imageView;

    /**
     * Constructor of the class
     */
    public UfoView(){
        imageView = new ImageView(new Image("/Pictures/ufo.png"));
        GameController.getInstance().getAsteroidFieldGroup().getChildren().add(imageView);
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);
    }

    /**
     * Draws this ufo to the appropriate location
     * @param ufo the ufo to be drawn
     */
    public void DrawUfo(Ufo ufo){
        GameController.getInstance().getPlayerId().setText("UFO");

        SpaceObjectController spaceObjectController =
                SpaceObjectController.controllerFromSpaceObject(ufo.getPosition());

        int id = AsteroidView.getNextEntityId(ufo.getPosition(),ufo);
        Point position = ((AsteroidView)spaceObjectController.getView()).getEntityPosition(id);

        imageView.setLayoutX(position.x);
        imageView.setLayoutY(position.y);
    }
}
