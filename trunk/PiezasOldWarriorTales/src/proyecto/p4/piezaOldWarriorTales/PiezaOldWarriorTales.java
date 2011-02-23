package proyecto.p4.piezaOldWarriorTales;

import java.util.Random;

import proyecto.p4.pieza.Piece;

public abstract class PiezaOldWarriorTales extends Piece{
	private int movement;
	private int defense;
	private int attack;
	private int experience;
	private int life;
	private int energy;
	private int probability;
	
	//indica si la unidad está envenenada o no.
	private boolean blindness;

	//indica si la unidad está envenenada o no.
	private boolean poison;

	//indica si puede contraatacar o no
	private boolean counterattack;
	
	public int getMovement() {
		return movement;
	}
	public int getDefense() {
		return defense;
	}
	public int getAttack() {
		return attack;
	}
	public int getExperience() {
		return experience;
	}
	public int getLife() {
		return life;
	}
	public int getEnergy() {
		return energy;
	}
	public boolean isCounterattack() {
		return counterattack;
	}
	public int takingLife (PiezaOldWarriorTales piezaContraria){
		return this.attack-piezaContraria.defense;
	}
	@Override
	public boolean canMove(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	/*Metodo que indica si la pieza puede atacar o no
	 * 
	 */
	public boolean canAttack (){
		Random random= new Random();
		int randomNumber=random.nextInt(100);
		return randomNumber<=this.probability;
	}

}
