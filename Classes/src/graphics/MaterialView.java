package graphics;

import game_classes.Material;
import javafx.scene.image.ImageView;

/**
 * Abstract base class for material views
 */
public abstract class MaterialView {
    //todo
    protected ImageView image;
    public abstract void Draw(Material material);
    protected MaterialView(ImageView iv){
        image = iv;
    }

    public void ShowView(boolean show) {
        image.setVisible(show);
    }

    public ImageView getImage() {
        return image;
    }
}
