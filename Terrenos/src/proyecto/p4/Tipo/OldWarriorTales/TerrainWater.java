package proyecto.p4.Tipo.OldWarriorTales;

import javax.swing.ImageIcon;


public class TerrainWater extends Terrain{

	@Override
	public void iniImage() {
		//insertar ruta de la imagen
		this.image="/img/agua.png";
	}

	@Override
	public void iniMovement() {
		movement = 2;
			
	}

	@Override
	public void iniName() {
		name = "Water";
				
	}
}
