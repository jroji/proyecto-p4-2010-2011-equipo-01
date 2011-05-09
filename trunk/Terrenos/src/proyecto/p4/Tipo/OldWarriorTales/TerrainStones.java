package proyecto.p4.Tipo.OldWarriorTales;

import javax.swing.ImageIcon;


public class TerrainStones extends Terrain{
	
	@Override
	public void iniImage() {
		//insertar ruta
		this.image= "/img/piedra.png";
	}

	@Override
	public void iniMovement() {
		this.movement = 2;
		
	}

	@Override
	public void iniName() {
		this.name = "Stones";
		
	}
}
