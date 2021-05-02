package graphics;

import game_classes.SpaceObject;

import javax.swing.text.html.ImageView;

public abstract class SpaceObjectView {
    protected ImageView imageView;
    //todo ez az osztály az osztálydiagrammon nem absztrakt
    public abstract void Draw(SpaceObject spaceObject);
}
