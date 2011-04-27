package proyecto.p4.Tipo.OldWarriorTales;

import javax.swing.ImageIcon;


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
		String dir="/img/castillo.png";
		image=new ImageIcon(getClass().getResource(dir));
	}
	
	
	
}