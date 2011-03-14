package proyecto.p4.piezaOldWarriorTales;

import java.util.Random;

import proyecto.p4.pieza.Piece;

public abstract class PiezaOldWarriorTales extends Piece{
	//atributos de la pieza
	protected int movement;
	protected int defense;
	protected int attack;
	protected int experience;
	protected int life;
	protected int energy;
	protected int probability;
	protected Orientations orientacion;
	
	//indica si la unidad está ciega o no.
	protected boolean blindness;

	//indica si la unidad está envenenada o no.
	protected boolean poisson;
	
	//indica si puede contraatacar o no
	protected boolean counterattack;

	
	
	
	public PiezaOldWarriorTales(){
		experience=0;
		life=100;
		energy=100;
	}
	
	public void setCounterattack(boolean counterattack) {
		this.counterattack = counterattack;
	}

	public void setOrientacion(Orientations orientacion) {
		this.orientacion = orientacion;
	}
	
	public void setBlindness(boolean blindness) {
		this.blindness = blindness;
	}
	
	public void setPoisson(boolean poisson) {
		this.poisson = poisson;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}

	public void setLife(int life) {
		this.life = life;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public Orientations getOrientacion() {
		return orientacion;
	}
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
	
	public int getProbability() {
		return probability;
	}
	public boolean isCounterattack() {
		return counterattack;
	}
	public boolean isBlind (){
		return blindness;
	}
	public boolean isPoissoned(){
		return poisson;
	}
	/** Metodo que gestiona el ataque de una pieza a otra basandose en la siguiente formula:
	 * vida a restar= ataque (this) - defensa (contraria)
	 * 
	 * @param piezaContraria. pieza a la que se a atacado y a la que se desea restar la vida.
	 * @return int. Vida a restar
	 * 
	 */
 	public int takingLife (PiezaOldWarriorTales piezaContraria){
		return this.attack-piezaContraria.defense;
	}
	
	/** Metodo del interfaz Mooveable:
	 * Indica si puede moverse a la posicion indicada como coordenadas en los parametros
	 * 
	 * @param posX. Coordenada X de la posicion a la que desea moverse
	 * @param posY. Coordenada Y de la posicion a la que desea moverse
	 * @return boolean. True si puede moverse
	 * 
	 */
	@Override
	public boolean canMove(int posx, int posy) {
		//metodo a codificar.
		return false;
	}
	
	/** Metodo que indica si la pieza puede atacar o no.
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
