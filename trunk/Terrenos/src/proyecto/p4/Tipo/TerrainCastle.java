package proyecto.p4.Tipo;

import javax.swing.ImageIcon;

public class TerrainCastle extends Terrain{
	
	public TerrainCastle (){
		
		name = "Castle";
		movement = 1;
		//introducir ruta de la imagen
		String ruta="";
		image = new ImageIcon(ruta);	
	}
	
}
