package proyecto.p4.Tipo;

import javax.swing.ImageIcon;


public class TerrainGrass extends Terrain{
	
	public TerrainGrass (){
	name = "Grass";
	movement = 1;
	//introducir ruta de la imagen
	String ruta="";
	image = new ImageIcon(ruta);
	}
	
}
