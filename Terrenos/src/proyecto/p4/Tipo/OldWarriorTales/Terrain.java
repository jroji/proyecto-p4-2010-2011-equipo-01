package proyecto.p4.Tipo.OldWarriorTales;

import proyecto.p4.Tipo.Square;

public abstract class Terrain extends Square {
	
	protected int movement;
	
	public Terrain (){
		super();
		iniMovement();
		
	}

	
	public abstract void iniImage();

	public abstract void iniName();

	public int getMovement() {
		return movement;
	}

	public abstract void iniMovement() ;

}
