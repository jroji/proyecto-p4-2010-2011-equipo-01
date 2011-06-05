package proyecto.p4.Tipo.OldWarriorTales;


import proyecto.p4.TerrenosOldWarriorTales.Terrain;


public class TerrainWater extends Terrain{

	@Override
	public void iniImage() {
		//insertar ruta de la imagen
		image= "/img/water.gif";;
	}

	@Override
	public void iniMovement() {
		movement = 2;
			
	}

	@Override
	public void iniName() {
		terrain = "Water";
				
	}
}
