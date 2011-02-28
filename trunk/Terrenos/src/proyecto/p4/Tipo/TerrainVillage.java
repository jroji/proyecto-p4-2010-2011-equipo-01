package proyecto.p4.Tipo;

import javax.swing.ImageIcon;

public class TerrainVillage extends Terrain{
	
	public TerrainVillage(){
	name = "Village";
	movement = 1;
	//introducir ruta de la imagen
	String ruta="";
	image = new ImageIcon(ruta);
	}
	
}
