package proyecto.p4.Tipo.OldWarriorTales;

import javax.swing.ImageIcon;



public class TerrainGrass extends Terrain{
	
	@Override
	public void iniImage() {
		//introducir ruta de la imagen
		this.image="/img/hierba.png";
	}

	@Override
	public void iniMovement() {
		this.movement = 1;	
	}

	@Override
	public void iniName() {
		this.name = "Grass";
			
	}
	
}
