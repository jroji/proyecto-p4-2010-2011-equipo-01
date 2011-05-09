package proyecto.p4.Tipo.OldWarriorTales;

import javax.swing.ImageIcon;


public class TerrainCastle extends Terrain{

	@Override
	public void iniMovement() {
		this.movement=1;
	}

	@Override
	public void iniName() {
		this.name="Castle";
		
	}

	@Override
	public void iniImage() {
		//inicializar
		this.image="/img/castillo.png";
	}
	
	
	
}
