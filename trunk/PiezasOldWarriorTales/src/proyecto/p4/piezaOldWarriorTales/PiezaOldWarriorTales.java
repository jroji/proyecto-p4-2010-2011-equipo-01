package proyecto.p4.piezaOldWarriorTales;

import proyecto.p4.pieza.Piece;

public abstract class PiezaOldWarriorTales extends Piece{
	private int movement;
	private int defense;
	private int attack;
	private int experience;
	private int life;
	private int energy;
	//indica si puede contraatacar o no
	private boolean counterattack;
	
	@Override
	public boolean canMove(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
