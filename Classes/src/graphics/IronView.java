package graphics;

import game_classes.Material;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * View for the iron material
 */
public class IronView extends MaterialView {

    /**
     * Constructor of the class
     * @param iv
     */
    public IronView(ImageView iv){
        super(iv);
        image.setImage(new Image("/Pictures/iron.png"));
    }


    @Override
    public void Draw(Material material) {

    }
}
