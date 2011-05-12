package proyecto.p4.Tipo.OldWarriorTales;


import proyecto.p4.TerrenosOldWarriorTales.Terrain;


public class TerrainVillage extends Terrain{
	
	@Override
	public void iniImage() {
		//introducir ruta de la imagen
		image="/img/villa.png";
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
