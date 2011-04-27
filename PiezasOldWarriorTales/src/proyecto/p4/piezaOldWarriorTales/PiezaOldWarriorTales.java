package proyecto.p4.piezaOldWarriorTales;

import java.util.Random;

import Proyecto.p4.casilla.Casilla;
import Proyecto.p4.mapa.Board;

import proyecto.p4.habilidades.Hability;
import proyecto.p4.pieza.Piece;
import proyecto.p4.piezaOldWarriorTales.Unidades.Arquero;

public abstract class PiezaOldWarriorTales extends Piece implements Orientable{
	//atributos de la pieza
	protected int movement;
	protected int defense;
	protected int attack;
	protected int experience;
	protected int life;
	protected int energy;
	protected int probability;

	//se necesitara el tablero para acceder a las casillas y piezas de el
	protected Board board;
	
	protected Orientations orientacion;
	
	//indica si la unidad est� ciega o no.
	protected boolean blindness;

	//indica si la unidad est� envenenada o no.
	protected boolean poisson;
	
	//indica si puede contraatacar o no
	protected boolean counterattack;
	
	//array de habilidades
	protected Hability []habilities;

	/**
	 * Constructor que inicializa los atributos energy life y experience
	 */
	public PiezaOldWarriorTales(){
		experience=0;
		life=100;
		energy=100;
		cargarHabilidades();
	}
	public void setOrientation(Orientations orientacion) {
		this.orientacion = orientacion;
	}
	public void setBlindness(boolean blindness) {
		this.blindness = blindness;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public void setPoisson(boolean poisson) {
		this.poisson = poisson;
	}
	public void setExperience(int experience) {
		this.experience = experience;
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
	public void setAttack(int attack) {
		this.attack = attack;
	}

	public void setProbability(int probability) {
		this.probability = probability;
	}
	public void setMovement(int movement) {
		this.movement = movement;
	}
	public Hability[] getHabilities() {
		return habilities;
	}
	public void setHabilities(Hability[] habilities) {
		this.habilities = habilities;
	}

	/**
	 *  devuelve al atributo probability valor inicial
	 */
	public abstract void restartProbability();
	
	/**
	 * Metodo que gestiona el ataque a una pieza
	 * @param piezaAtacada pieza a la que se desea atacar y a la que se restara la vida
	 * @return true si a atacado o false si no a atacado
	 * @throws Exception si no hay una pieza en la posicion indicada
	 */
	public boolean attack (int posX, int posY) throws Exception{
		PiezaOldWarriorTales piezaAtacada=(PiezaOldWarriorTales) board.getPiece(posX, posY);
		if (piezaAtacada==null)
			throw new Exception("no hay una pieza en las coordenadas indicadas");
		//validar que la pieza este en una casilla cercana
		int x= Math.abs(piezaAtacada.getPosition_x()-this.getPosition_x());
		int y= Math.abs(piezaAtacada.getPosition_y()-this.getPosition_y());
		if(x<2&&y<2){
			if (canAttack()){
				takingLife (piezaAtacada);
				return true;
			}else return false;
		}else return false;
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
		//si esta ciego la probabilidad baja al 10%
		if (this.isBlind()){
			return randomNumber<=10;
		}else
			return randomNumber<=this.probability;
	}
	
	/** Metodo que gestiona el ataque de una pieza a otra basandose en la siguiente formula:
	 * vida a restar= ataque (this) - defensa (contraria)
	 * 
	 * @param piezaContraria. pieza a la que se a atacado y a la que se desea restar la vida.
	 */
 	public void takingLife (PiezaOldWarriorTales piezaContraria){
 		int vida_a_restar=this.attack-piezaContraria.defense;
		piezaContraria.setLife(piezaContraria.getLife()-vida_a_restar);
	}
 	
 	/*
 	 * (non-Javadoc)
 	 * @see proyecto.p4.pieza.Piece#move(Proyecto.p4.casilla.Casilla, Proyecto.p4.casilla.Casilla)
 	 */
 	public void move (int x_a_mover, int y_a_mover) throws Exception{
 		Casilla casillaActual=board.getCasilla(this.getPosition_x(), this.getPosition_y());
 		Casilla casillaAMover= board.getCasilla(x_a_mover, y_a_mover);
 		super.move(casillaActual, casillaAMover);
 		//devolvemos el valor inicial a probabilidad
 		restartProbability();
 		//actualizamos el valor probabilidad en funcion de la nueva casilla
 		updateProbability();
 		//actualiza la orientacion
 		actualizarOrientacion(casillaActual.getPosX(), casillaActual.getPosY(),
 				x_a_mover, y_a_mover);
 	}
 	public void actualizarOrientacion (int x_actual, int y_actual,int x_siguiente, int y_siguiente){
 		int x= x_siguiente-x_actual;
 		int y= y_siguiente-y_actual;
 		if (x>0){
 			if (x>=Math.abs(y)){
 				setOrientation(Orientations.East);
 			}else 
 				if(y>0){
 					setOrientation(Orientations.North);
 				}else setOrientation(Orientations.South);
 		}else if (Math.abs(x)>=Math.abs(y)){
				setOrientation(Orientations.West);
			}else 
				if(y>0){
					setOrientation(Orientations.North);
				}else setOrientation(Orientations.South);
 	}
 	
 	/**
 	 * Modifica el atributo probability en funcion de la casiilla en que se encuentra
 	 * @param casilla en la que se encuentra la pieza actualmente
 	 */
 	private void updateProbability(){
 		Casilla casilla= board.getCasilla(getPosition_x(), getPosition_y());
 		if (casilla.getSquare().getClass().getName()=="TerrainGrass"){
			probability-=20;
		}else if (casilla.getSquare().getClass().getName()=="TerrainWater"){
			probability=100;
		}	
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
		int res=getPosition_x()-posx;
		res=Math.abs(res);
		if (res>movement){
			return false;
		}else{
			int res2=getPosition_y()-posy;
			res2=Math.abs(res2);
			res+=res2;
			if (res>movement){
				return false;
			}else return true;
		}
	}
	
	/**
	 * Metodo que carga el array de habilidades de cada pieza
	 * con sus respectivas habilidades.
	 */
	protected abstract void cargarHabilidades();
	
	public void ejecutarHabilidad(int num_habilidad) throws Exception{
		if (habilities==null)
			throw new Exception("Esta pieza no tiene habilidades.");
		if (num_habilidad<habilities.length){
			int [][]coordenadas=habilities[num_habilidad].obtenerCoordenadas();
			habilities[num_habilidad].execute(coordenadas);
		}else 
			throw new Exception("el numero de habilidad deve estar entre 0-"+(habilities.length-1));
	}
	/**
	 * Metodo que se ejecuta al finalizar el turno del jugador
	 */
	public void finalizarTurno(){
		//si la pieza esta envenenada resta diez
		if (this.isPoissoned()){
			this.life-=10;
		}
	}
	/**
	 * prueba orientacion
	 * @param args
	 */
	public static void main (String[]args){
		PiezaOldWarriorTales prueba= new Arquero();
		prueba.actualizarOrientacion(5, 5, 5, 4);
		System.out.println(prueba.getOrientacion());
	}
	

}