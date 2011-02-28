package proyecto.p4.Tipo;

import javax.swing.ImageIcon;

public class TerrainWater extends Terrain{

	//Inicializa la imagen del terreno
	@Override
	public void iniImage() {
		String ruta= "";
		image = new ImageIcon(ruta);
	}

	//Inicializa el movimiento que resta cada terreno
	@Override
	public void iniMovement() {
		movement = 2;
			
	}

	//Inicializa el nombre del terreno
	@Override
	public void iniName() {
		name = "Water";
				
	}
}
