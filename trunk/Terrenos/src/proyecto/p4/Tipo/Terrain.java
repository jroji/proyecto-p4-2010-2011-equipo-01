package proyecto.p4.Tipo;

import javax.swing.ImageIcon;

public abstract class Terrain {
	
	protected ImageIcon image;
	protected String name;
	protected int movement;
	
	public Terrain (){
		iniImage();
		iniName();
		iniMovement();
		
	}

	public ImageIcon getImage() {
		return image;
	}

	public abstract void iniImage();

	public String getName() {
		return name;
	}

	public abstract void iniName();

	public int getMovement() {
		return movement;
	}

	public abstract void iniMovement() ;

}
