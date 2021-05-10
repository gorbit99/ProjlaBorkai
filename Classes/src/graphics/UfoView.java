package graphics;

import game_classes.Ufo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class UfoView {
    private final ImageView imageView;

    public UfoView(){
        imageView = new ImageView(new Image("/Pictures/ufo.png"));
        GameController.getInstance().getAsteroidFieldGroup().getChildren().add(imageView);
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);
    }

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
