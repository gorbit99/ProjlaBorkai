package graphics;

import game_classes.Material;
import javafx.scene.image.ImageView;

public abstract class MaterialView {
    //todo
    protected ImageView image;
    public abstract void Draw(Material material);
    protected MaterialView(ImageView iv){
        image = iv;
    }
}
