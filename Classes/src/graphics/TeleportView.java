package graphics;

import game_classes.SpaceObject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TeleportView extends SpaceObjectView {

    public TeleportView(ImageView imageView){
        super(imageView);
        imageView.setImage(new Image("/Pictures/portal.png"));
    }

    @Override
    public void Draw(SpaceObject spaceObject) {

    }
}
