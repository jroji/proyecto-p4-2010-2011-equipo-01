package proyecto.p4.Tipo.OldWarriorTales;


import proyecto.p4.TerrenosOldWarriorTales.Terrain;



public class TerrainGrass extends Terrain{
	
	public void iniImage() {
		//introducir ruta de la imagen
		image="/img/hierba.png";
			
	}

	@Override
	public void iniMovement() {
		movement = 1;	
	}

	public void iniName() {
		name = "Grass";
			
	}
	public String toString (){
		return name;
	}
}
