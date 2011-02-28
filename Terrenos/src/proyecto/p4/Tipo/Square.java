package proyecto.p4.Tipo;

import javax.swing.ImageIcon;

public abstract class Square {

	protected ImageIcon image; //Contiene la imagen del terreno
	protected String name; // Contiene el nombre del terreno

	//Inicializar nombre
	public abstract void iniName();
	
	//Inicializar Imagen
	public abstract void iniImage();
	
	//Devuelve la imagen
	public abstract ImageIcon getImage();
	
	//Devuelve el nombre del terreno
	public abstract String getName();


}
