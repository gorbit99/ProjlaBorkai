package graphics;

import game_classes.SpaceObject;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AsteroidView extends SpaceObjectView{

    public AsteroidView(ImageView imageView){
        super(imageView);
        imageView.setImage(new Image("/Pictures/Asteroida.png"));
    }


    @Override
    public void Draw(SpaceObject spaceObject) {

    }
}
