package graphics;

import game_classes.Material;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NoMaterialView extends MaterialView{
    protected NoMaterialView(ImageView iv) {
        super(iv);
        image.setImage(new Image("/Pictures/UFO.png"));
    }

    @Override
    public void Draw(Material material) {

    }
}
