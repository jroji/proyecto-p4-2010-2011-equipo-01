package proyecto.p4.Tipo.OldWarriorTales;

import javax.swing.ImageIcon;


public class TerrainStones extends Terrain{
	
	@Override
	public void iniImage() {
		//insertar ruta
		String image= "/img/piedra.png";	
	}

	@Override
	public void iniMovement() {
		movement = 2;
		
	}

	@Override
	public void iniName() {
		name = "Stones";
		
	}
}
