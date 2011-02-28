package proyecto.p4.Tipo;

import javax.swing.ImageIcon;

public abstract class Terrain extends Square {
	
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

	//Devuelve el nombre del terreno
	public String getName() {
		return name;
	}

	//Devuelve el movimiento que resta el terreno
	public int getMovement() {
		return movement;
	}

	//Inicializa el movimiento que resta cada tipo de terreno.
	public abstract void iniMovement() ;

}
