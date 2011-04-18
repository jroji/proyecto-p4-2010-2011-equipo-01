package proyecto.p4.Tipo.OldWarriorTales;

import javax.swing.ImageIcon;



public class TerrainGrass extends Terrain{
	
	@Override
	public void iniImage() {
		//introducir ruta de la imagen
		String ruta="/img/hierba.png";
		image = new ImageIcon(getClass().getResource(ruta));
			
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
