package graphics;

import game_classes.Material;

import javax.swing.text.html.ImageView;

public abstract class MaterialView {
    //todo
    protected ImageView image;
    public abstract void Draw(Material material);
}
