package proyecto.p4.Tipo.OldWarriorTales;

import javax.swing.ImageIcon;


public class TerrainVillage extends Terrain{
	
	@Override
	public void iniImage() {
		//introducir ruta de la imagen
		this.image ="/img/villa.png";
	}

	@Override
	public void iniMovement() {
		movement = 1;
		
	}

	@Override
	public void iniName() {
		name = "Village";
		
	}
	
}
