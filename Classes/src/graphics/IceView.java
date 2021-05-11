package graphics;

import game_classes.Material;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * View for the ice material
 */
public class IceView extends MaterialView{
    @Override
    public void Draw(Material material) {

    }

    /**
     * Constructor of the clas
     * @param iv
     */
    public IceView(ImageView iv){
        super(iv);
        image.setImage(new Image("/Pictures/ice.png"));
    }
}
