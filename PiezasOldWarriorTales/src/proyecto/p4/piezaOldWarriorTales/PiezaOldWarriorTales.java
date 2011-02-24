package proyecto.p4.piezaOldWarriorTales;

import java.util.Random;

import proyecto.p4.pieza.Piece;

public abstract class PiezaOldWarriorTales extends Piece{
	//atributos de la pieza
	private int movement;
	private int defense;
	private int attack;
	private int experience;
	private int life;
	private int energy;
	private int probability;
	
	//indica si la unidad está ciega o no.
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
	public boolean isBlind (){
		return blindness;
	}
	public boolean isPoissoned(){
		return poison;
	}
	/* Metodo que gestiona el ataque de una pieza a otra basandose en la siguiente formula:
	 * vida a restar= ataque (this) - defensa (contraria)
	 * 
	 * @param piezaContraria. pieza a la que se a atacado y a la que se desea restar la vida.
	 * @return int. Vida a restar
	 * 
	 */
 	public int takingLife (PiezaOldWarriorTales piezaContraria){
		return this.attack-piezaContraria.defense;
	}
	public int getProbability() {
		return probability;
	}
	
	@Override
	public boolean canMove(int posx, int posy) {
		//metodo a codificar.
		return false;
	}
	/* Metodo que indica si la pieza puede atacar o no.
	 * Para ello genera un numero aleatorio entre 0 y 100 y lo compara con su atributo probability,
	 * devolviendo true si y solo si el resultado del numero aleatorio generado es igual o menor 
	 * a ese atributo.
	 * 
	 * @return boolean. indicativo de si la pieza puede atacar o no
	 */
	public boolean canAttack (){
		Random random= new Random();
		int randomNumber=random.nextInt(100);
		return randomNumber<=this.probability;
	}

}
