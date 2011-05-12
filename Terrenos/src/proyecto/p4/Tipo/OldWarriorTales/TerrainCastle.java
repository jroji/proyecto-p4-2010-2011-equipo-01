package proyecto.p4.Tipo.OldWarriorTales;


import proyecto.p4.TerrenosOldWarriorTales.Terrain;


public class TerrainCastle extends Terrain{

	@Override
	public void iniMovement() {
		movement=1;
	}

	@Override
	public void iniName() {
		name="Castle";
		
	}

	@Override
	public void iniImage() {
		//inicializar
		image="/img/castillo.png";
	}
	
	
	
}
