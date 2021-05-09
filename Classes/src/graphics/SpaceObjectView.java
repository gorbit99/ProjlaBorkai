package graphics;

import game_classes.SpaceObject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class SpaceObjectView {
    protected ImageView imageView;

    //todo ez az osztály az osztálydiagrammon nem absztrakt
    public abstract void Draw(SpaceObject spaceObject);

    public SpaceObjectView(ImageView imageView) {
        this.imageView = imageView;
    }
}
