package graphics;

import game_classes.Asteroid;
import game_classes.SpaceObject;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AsteroidView extends SpaceObjectView{

    private MaterialView coreView;

    public AsteroidView(ImageView imageView, MaterialView coreView){
        super(imageView);
        imageView.setImage(new Image("/Pictures/Asteroida.png"));
        this.coreView = coreView;
        coreView.ShowView(true);
    }

    @Override
    public void Draw(SpaceObject spaceObject) {
        if (((Asteroid)spaceObject).GetLayers() == 0) {
            coreView.ShowView(true);
        }
    }
}
