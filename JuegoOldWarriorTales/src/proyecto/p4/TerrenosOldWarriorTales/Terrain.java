package proyecto.p4.TerrenosOldWarriorTales;

import proyecto.p4.Mapa.*;

public abstract class Terrain extends Square {
	
	protected int movement;
	
	public Terrain (){
		super();
		iniMovement();
		
	}
	public abstract void iniMovement() ;

}
