package proyecto.p4.Tipo;

import javax.swing.ImageIcon;

public abstract class Terrain {
	
	protected ImageIcon image; //Contiene la imagen del terreno
	protected String name; // Contiene el nombre del terreno
	protected int movement; // Contiene la cantidad de movimiento que disminuye este terreno
	
	//Inicializa el terreno
	public Terrain (){
		iniImage();
		iniName();
		iniMovement();
		
	}

	//Devuelve la imagen 
	public ImageIcon getImage() {
		return image;
	}

	public abstract void iniImage();

	//Devuelve el nombre del terreno
	public String getName() {
		return name;
	}

	public abstract void iniName();

	//Devuelve el movimiento que resta el terreno
	public int getMovement() {
		return movement;
	}

	public abstract void iniMovement() ;

}
