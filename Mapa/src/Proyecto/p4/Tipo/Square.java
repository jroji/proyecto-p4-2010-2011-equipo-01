package Proyecto.p4.Tipo;

import javax.swing.ImageIcon;

public abstract class Square {

	protected ImageIcon image; //Contiene la imagen del terreno
	protected String name; // Contiene el nombre del terreno
	
	public Square (){
		iniName();
		iniImage();
	}

	//Inicializar nombre
	public abstract void iniName();
	
	//Inicializar Imagen
	public abstract void iniImage();
	
	//Devuelve la imagen
	public  ImageIcon getImage(){
		return image;
	}
	
	//Devuelve el nombre del terreno
	public String getName(){
		return name;
	}


}
