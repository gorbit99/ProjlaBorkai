package graphics;

import game_classes.SpaceObject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Abstract base class for the spaceobjects
 */
public abstract class SpaceObjectView {
    protected ImageView imageView;

    public abstract void Draw(SpaceObject spaceObject);
}
