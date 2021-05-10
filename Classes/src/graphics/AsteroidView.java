package graphics;

import game_classes.Asteroid;
import game_classes.SpaceObject;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AsteroidView extends SpaceObjectView{

    private MaterialView coreView;

    /**
     * constructor of asteroid view
     * @param imageView image view of the view
     * @param coreView view of the asteroid's core
     */
    public AsteroidView(ImageView imageView, MaterialView coreView){
        super(imageView);
        imageView.setImage(new Image("/Pictures/Asteroida.png"));
        this.coreView = coreView;
        coreView.ShowView(true);
    }


    /**
     * draw option
     * @param spaceObject
     */
    @Override
    public void Draw(SpaceObject spaceObject) {
        if (((Asteroid)spaceObject).GetLayers() == 0) {
            coreView.ShowView(true);
        }
    }
}
