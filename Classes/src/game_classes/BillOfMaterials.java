package game_classes;

/**
 * represents the which knows the right amount of materials for the creation of an object
 */
public class BillOfMaterials {

	Material[] billOfMaterials;

	public BillOfMaterials(Material[] temp) {
		billOfMaterials = temp;
	}
	/**
	 * decides whether there is enough materials to creat an object
	 * @param materials materials to be checked if they are enough
	 * @return true if there is enough materials false if there isn't
	 */
	public boolean IsEnough(Material[] materials) {
		Material[] materials_temp = materials.clone();
		for(int i = 0; i < billOfMaterials.length; i++) {
			boolean inside = false;

			for(int j = 0; j < materials.length; j++) {
				if(materials_temp[j].getClass().equals(billOfMaterials[i].getClass()) && materials_temp[j] != null) {
					inside = true;
					materials_temp[j] = null;
					break;
				}
			}

			if(!inside)
				return false;
		}

		return true;
	}
}
