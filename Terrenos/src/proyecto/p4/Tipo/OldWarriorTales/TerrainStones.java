package proyecto.p4.Tipo.OldWarriorTales;

import proyecto.p4.TerrenosOldWarriorTales.Terrain;


public class TerrainStones extends Terrain{
	
	@Override
	public void iniImage() {
		//insertar ruta
		image= "/img/piedra.png";	
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
