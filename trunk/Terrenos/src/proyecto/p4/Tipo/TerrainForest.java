package proyecto.p4.Tipo;

import javax.swing.ImageIcon;

public class TerrainForest extends Terrain{

	@Override
	public void iniImage() {
		//insertar ruta
		String ruta= "";
		image = new ImageIcon(ruta);	
	}

	@Override
	public void iniMovement() {
		movement = 2;
		
	}

	@Override
	public void iniName() {
		name = "Forest";
		
	}
}
