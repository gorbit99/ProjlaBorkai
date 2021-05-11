package graphics;

import game_classes.Material;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * View clas for the uranium material
 */
public class UraniumView extends MaterialView{
    @Override
    public void Draw(Material material) {

    }

    /**
     * Constructor of the class
     * @param iv the imageview this uranium will be drawn to
     */
    public UraniumView(ImageView iv){
        super(iv);
        image.setImage(new Image("/Pictures/uranium.png"));
    }
}
