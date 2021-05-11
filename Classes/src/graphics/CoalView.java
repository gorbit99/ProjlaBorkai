package graphics;

import game_classes.Material;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * View for the coal material
 */
public class CoalView extends MaterialView {
    /**
     * draw method of the coal view
     * @param material
     */
    @Override
    public void Draw(Material material) {

    }

    /**
     * constructor of the coal view
     * @param iv
     */
    public CoalView(ImageView iv){
        super(iv);
        image.setImage(new Image("/Pictures/coal.png"));
    }
}
