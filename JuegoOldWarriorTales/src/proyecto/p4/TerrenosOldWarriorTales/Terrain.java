package proyecto.p4.TerrenosOldWarriorTales;

import proyecto.p4.Mapa.Square;

public abstract class Terrain extends Square {
	
	protected int movement;
	
	public Terrain (){
		super();
		iniMovement();
		
	}
	public abstract void iniMovement() ;

}
