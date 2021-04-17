package game_classes;

import java.util.ArrayList;

/**
 * represents the which knows the right amount of materials for the creation of an object
 */
public class BillOfMaterials {

	private ArrayList<Material> billOfMaterials;

	public BillOfMaterials(ArrayList<Material> temp) {
		billOfMaterials = temp;
	}
	/**
	 * decides whether there is enough materials to creat an object
	 * @param materials materials to be checked if they are enough
	 * @return true if there is enough materials false if there isn't
	 */
	public boolean IsEnough(ArrayList<Material> materials) {
		ArrayList<Material> materials_temp = (ArrayList<Material>) materials.clone();
		for(int i = 0; i < billOfMaterials.size(); i++) {
			boolean inside = false;

			for(int j = 0; j < materials.size(); j++) {
				if(materials_temp.get(j).getClass().equals(billOfMaterials.get(i).getClass())) {
					inside = true;
					materials_temp.remove(materials_temp.get(j));
					break;
				}
			}

			if(!inside)
				return false;
		}

		return true;
	}
}
