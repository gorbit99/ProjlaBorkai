package graphics;

import game_classes.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * Controller class for the materials in the game. Connects the view and the model
 */
public class MaterialController implements PropertyChangeListener {
    private MaterialView view;
    private Material material;

    private static ArrayList<MaterialController> materialControllers = new ArrayList<>();

    //TODO ez az osztálydiagrammon privát
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals("exist") || evt.getPropertyName().equals("exposureCount")) {
            view = new NoMaterialView(view.getImage());
            material = null;
            System.out.println("no material");
        }
        view.Draw(material);

    }

    /**
     * constructor of the material controller
     *
     * @param m  the material which will be represented by the controller
     * @param mv view of the controller
     */
    private MaterialController(Material m, MaterialView mv) {
        material = m;
        view = mv;
        if (material != null)
            material.GetChangeEvent().addPropertyChangeListener(this);

        materialControllers.add(this);
    }

    public static MaterialController controllerFromMaterial(Material material) {
        System.out.println(material);
        return materialControllers.stream().filter(x -> x.material == material).findFirst().get();

    }


    public static MaterialController CreateIron(ImageView iv) {

        MaterialView mv = new IronView(iv);
        Iron iron = new Iron();
        return new MaterialController(iron, mv);
    }

    /**
     * Creates an coal controller
     *
     * @param iv the image view the coal will be represented in
     * @return the coal controller
     */
    public static MaterialController CreateCoal(ImageView iv) {
        MaterialView mv = new CoalView(iv);
        Coal coal = new Coal();
        return new MaterialController(coal, mv);
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * Creates a uranium controller
     *
     * @param iv the image view the uranium will be represented in
     * @return the uranium controller
     */
    public static MaterialController CreateUranium(ImageView iv) {
        MaterialView mv = new UraniumView(iv);
        Uranium uranium = new Uranium();
        return new MaterialController(uranium, mv);
    }

    /**
     * Creates an ice controller
     *
     * @param iv the image view the ice will be represented in
     * @return the ice controller
     */
    public static MaterialController CreateIce(ImageView iv) {
        MaterialView mv = new IceView(iv);
        Ice ice = new Ice();
        return new MaterialController(ice, mv);
    }

    /**
     * Creates a no material controller
     *
     * @param iv the image view the absence of a material will be represented in
     * @return the no material controller
     */
    public static MaterialController CreateNoMaterial(ImageView iv) {
        MaterialView mv = new NoMaterialView(iv);
        return new MaterialController(null, mv);
    }

    /**
     * Getter for the view
     *
     * @return the view
     */
    public MaterialView getView() {
        return view;
    }

    /**
     * Getter for the material
     *
     * @return the material
     */
    public Material getMaterial() {
        return material;
    }
}
