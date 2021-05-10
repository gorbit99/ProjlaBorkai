package graphics;

import game_classes.Material;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class IronView extends MaterialView {//TODO

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
