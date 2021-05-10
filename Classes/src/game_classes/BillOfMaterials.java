package game_classes;

import java.util.ArrayList;

/**
 * represents the which knows the right amount of materials for the creation of an object
 */
public class BillOfMaterials {

    /**
     * The list of necessary materials for a specific construction
     */
    private final ArrayList<Material> billOfMaterials;

    /**
     * Constructor of the class
     * @param temp The list of necessary elements
     */
    public BillOfMaterials(ArrayList<Material> temp) {
        billOfMaterials = temp;
    }

    /**
     * decides whether there is enough materials to create an object
     *
     * @param materials materials to be checked if they are enough
     * @return true if there is enough materials false if there isn't
     */
    public boolean IsEnough(ArrayList<Material> materials) {
        ArrayList<Material> materials_temp = new ArrayList<>(materials);
        ArrayList<Material> deleted = new ArrayList<>();
        for (Material billOfMaterial : billOfMaterials) {
            boolean inside = false;

            for (int j = 0; j < materials_temp.size(); j++) {
                if (materials_temp.get(j).getClass().equals(billOfMaterial.getClass())) {
                    inside = true;
                    deleted.add(materials_temp.get(j));
                    materials_temp.remove(j);
                    break;
                }
            }

            if (!inside)
                return false;
        }

        for (Material material : deleted) {
            materials.remove(material);
        }

        return true;
    }
}
