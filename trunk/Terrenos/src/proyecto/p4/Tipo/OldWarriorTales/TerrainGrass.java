package proyecto.p4.Tipo.OldWarriorTales;

import javax.swing.ImageIcon;



public class TerrainGrass extends Terrain{
	
	@Override
	public void iniImage() {
		//introducir ruta de la imagen
		String image="/img/hierba.png";
			
	}

	@Override
	public void iniMovement() {
		movement = 1;	
	}

	@Override
	public void iniName() {
		name = "Grass";
			
	}
	
}
