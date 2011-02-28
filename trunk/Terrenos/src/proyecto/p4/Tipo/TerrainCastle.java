package proyecto.p4.Tipo;

import javax.swing.ImageIcon;

public class TerrainCastle extends Terrain{

	//Inicializa el movimiento que resta cada terreno
	@Override
	public void iniMovement() {
		movement=1;
	}

	//Inicializa el nombre del terreno
	@Override
	public void iniName() {
		name="Castle";
		
	}
	
	//Inicializa la imagen del terreno
	@Override
	public void iniImage() {
		//inicializar
		String dir="";
		image=new ImageIcon(dir);
	}
	
	
	
}
