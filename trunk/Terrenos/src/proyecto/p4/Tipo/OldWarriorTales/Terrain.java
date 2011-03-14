package proyecto.p4.Tipo.OldWarriorTales;

import Proyecto.p4.Tipo.Square;

public abstract class Terrain extends Square {
	
	protected int movement;
	
	public Terrain (){
		super();
		iniMovement();
		
	}
	public abstract void iniMovement() ;

}
