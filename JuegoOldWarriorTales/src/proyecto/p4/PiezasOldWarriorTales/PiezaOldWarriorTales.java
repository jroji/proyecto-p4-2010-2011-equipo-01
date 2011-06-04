package proyecto.p4.PiezasOldWarriorTales;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;


import proyect.Reflectividad;
import proyecto.p4.Mapa.Board;
import proyecto.p4.Mapa.Casilla;
import proyecto.p4.Piece.Piece;
import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;
import proyecto.p4.TerrenosOldWarriorTales.Terrain;
import proyecto.p4.piezaOldWarriorTales.Unidades.Arquero;
import ConnectionInterface.PieceJDBC;
import ConnectionInterface.storableInDataBase;



public abstract class PiezaOldWarriorTales extends Piece implements Orientable{
	//atributos de la pieza
	protected int CodePiece;
	protected int movement;
	protected int defense;
	protected int attack;
	protected int experience;
	protected int life;
	protected int energy;
	protected int probability;
	protected String type;

	//flags que indican si la unidad ha sido movida o a atacado en este turno
	private boolean hasBeenMoved;
	private boolean hasAttacked;
	protected int attackDistance;
	
	//se necesitara el tablero para acceder a las casillas y piezas de el
	protected Board board;
	protected Orientations orientacion;
	//indica si la unidad está ciega o no.
	protected boolean blindness;
	//indica si la unidad está envenenada o no.
	protected boolean poisson;
	//indica si puede contraatacar o no
	protected boolean counterattack;
	//indica las posiciones a las que puede atacar
	protected boolean [][] attackAble;
	//array de habilidades
	protected Hability []habilities;
	

	/**
	 * Constructor que inicializa los atributos 
	 */
	public PiezaOldWarriorTales(){
		experience=0;
		life=100;
		energy=100;
		hasAttacked=false;
		hasBeenMoved=false;
		cargarHabilidades();
		blindness=false;
		poisson=false;
		able_to_move=new boolean[14][13];
		attackAble= new boolean [14][13];
		attackDistance=1;
		
	}
	
	public PiezaOldWarriorTales (Board board){
		this();
		this.board=board;
	}
	public void setOrientation(Orientations orientacion) {
		this.orientacion = orientacion;
	}
	public void setBlindness(boolean blindness) {
		this.blindness = blindness;
	}
	public int getCodePiece() {
		return CodePiece;
	}
	
	public String getType(){
		return type;
	}
	public void setCodePiece(int codePiece) {
		CodePiece = codePiece;
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
	public boolean isHasBeenMoved() {
		return hasBeenMoved;
	}
	public void setHasBeenMoved(boolean hasBeenMoved) {
		this.hasBeenMoved = hasBeenMoved;
	}
	public boolean isHasAttacked() {
		return hasAttacked;
	}
	public void setHasAttacked(boolean hasAttacked) {
		this.hasAttacked = hasAttacked;
	}
	public void setPosition(int positionX, int positionY) {
		super.setPosition(positionX, positionY);
		setAttackAble();
		
	}
	/**
	 *  devuelve al atributo probability valor inicial
	 */
	public abstract void restartProbability();
	
	/**
	 * Metodo que gestiona el ataque a una pieza
	 * @param piezaAtacada pieza a la que se desea atacar y a la que se restara la vida
	 * @return true si a quitado vida o false si no
	 * @throws Exception si no hay una pieza en la posicion indicada
	 * @throws AlreadyDoneException si la pieza ya atacado en este turno
	 */
	public boolean attack (int posX, int posY) throws Exception{
		//copmrueba si la pieza ya a atacado en este turno
		if (hasAttacked){
			throw new AlreadyDoneException ("the piece has already attacked");
		}
		else
		{
			//extraer de board la pieza a atacar en base a las coordenadas recibidas como parametro
			PiezaOldWarriorTales piezaAtacada=(PiezaOldWarriorTales) board.getPiece(posX, posY);
			
			//comprobar si hay pieza en las coordenadas indicadas
			if (piezaAtacada==null)
				throw new Exception("no hay una pieza en las coordenadas indicadas");
			
			
			if(attackAble[posX][posY]){
				//flag de attack a true
				hasAttacked=true;
				
				//comprobar si hacierta en el ataque (probabilidades)
				if (canAttack()){
					takingLife (piezaAtacada);
					return true;
				}else return false;
			}else throw new Exception("La pieza es demasiado lejana");
			
		}
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
	public void setAttackAble ()
	{
		for (int i =0; i<attackAble.length;i++)
		{
			for(int j=0; j<attackAble[i].length;j++)
				attackAble[i][j]= canAttack(i,j);
		}
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
 		//comprueba si ya a movido en este turno
 		if (hasBeenMoved){
 			throw new AlreadyDoneException ("the piece has already move in this turn");
 		}
 		else
 		{
	 		//extraccion de la casilla actual y la casilla a la que se va a mover
	 		Casilla casillaActual=board.getCasilla(this.getPosition_x(), this.getPosition_y());
	 		Casilla casillaAMover= board.getCasilla(x_a_mover, y_a_mover);
	 		//mover de la casilla actual a la casilla a mover
	 		super.move(casillaActual, casillaAMover);
	 		
	 		//flag de movimiento a true
	 		hasBeenMoved=true;
	 		
	 		//devolvemos el valor inicial a probabilidad
	 		restartProbability();
	 		
	 		//actualizamos el valor probabilidad en funcion de la nueva casilla
	 		updateProbability();
	 		
	 		//actualiza la orientacion
	 		actualizarOrientacion(casillaActual.getPosX(), casillaActual.getPosY(),
	 				x_a_mover, y_a_mover);
 		}
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
 		if (casilla.getSquare().getClass().getName()=="Castle"){
			probability=100;
		}else if (casilla.getSquare().getClass().getName()=="TerrainWater"){
			probability-=10;
		}else if(casilla.getSquare().getClass().getName()=="Stones"){
			probability-=20;
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
	
	public boolean canAttack (int posx, int posy)
	{
		int res=getPosition_x()-posx;
		res=Math.abs(res);
		if (res>attackDistance){
			return false;
		}else{
			int res2=getPosition_y()-posy;
			res2=Math.abs(res2);
			res+=res2;
			if (res>attackDistance){
				return false;
			}else return true;
		}
	}
	/**
	 * Metodo que se ejecuta al finalizar el turno del jugador
	 */
	public void finalizarTurno(){
		//si la pieza esta envenenada resta diez
		if (this.isPoissoned()){
			this.life-=10;
		}
		//devolver a falso los flag de ataque y movimiento
		hasAttacked=false;
		hasBeenMoved=false;
	}
	
	public String toString (){
		return this.getClass().getSimpleName();
	}
	
	/**
	 * Método que se encarga de borrar de la base de datos una pieza del juego Old Warrior Tales.
	 * @return valueToReturn que indica el número de piezas borradas de la base de datos.
	 */
	@SuppressWarnings("finally")
	@Override
	
	public int deleteFromDataBase() {
		PieceJDBC p;
		int valueToReturn=0;
			try {
				
				p = new PieceJDBC();
				valueToReturn+=p.remove("PiezaOldWarriorTales", this);
				
				
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null,"Error al borrar1","Error",JOptionPane.OK_OPTION,null);  
				e.printStackTrace();
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Error al borrar2","Error",JOptionPane.OK_OPTION,null);  
				e.printStackTrace();
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Error al borrar3","Error",JOptionPane.OK_OPTION,null);  
				e.printStackTrace();
			}
			finally{
				return valueToReturn;
			}
	}

	/**
	 * Método que se encarga de insertar una nueva pieza en la base de datos 
	 * @return un entero que indica el número de filas insertadas en la tabla.
	 */
	@Override
	public int insertIntoDataBase() {
		
		PieceJDBC p;
		try {
			p = new PieceJDBC();
			p.insert("PiezaOldWarriorTales", this);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			//Si salta la excepción de SQLException será porque ya existe en la base de datos la pieza 
			//especificada por lo que se le dirá si desea sobrescribir el pieza o no.
			Object [] option ={"SI","NO"};
			e.printStackTrace();
			int pane=JOptionPane.showOptionDialog(null,
				    "¿Desea sobrescribir? ","Sobrescribir",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
			
			//si desea sobrescribir borrará de la base de datos la pieza con la misma clave primera que la que 
			//se pretende escribir e insertará la nueva pieza.
			if(pane==0){
				deleteFromDataBase();
				return insertIntoDataBase();
				
			}
			
			else{
				return 0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
		}
	
	/**
	 * Método que se encarga de decidir que atributos se guardarán en la base de datos.
	 * @throws SecurityException indica una violación de la seguridad.
	 * @throws NoSuchFielException indica que la clase no tiene el atributo con el nombre especificado.
	 * @return array es un ArrayList que contiene aquellos atributos que se guardarán en la base de datos.
	 */ 
	 
	public ArrayList <Field> fieldsToStore() throws SecurityException, NoSuchFieldException{
		ArrayList<Field> array= new ArrayList<Field>();
		
		Field [] fields;
		if(!this.getClass().getSimpleName().equals("PiezaOldWarriorTales")){
			array.add(this.getClass().getSuperclass().getDeclaredField("life"));
			array.add(this.getClass().getSuperclass().getDeclaredField("energy"));
			array.add(this.getClass().getSuperclass().getDeclaredField("experience"));
			array.add(this.getClass().getSuperclass().getDeclaredField("blindness"));
			array.add(this.getClass().getSuperclass().getDeclaredField("poisson"));
			//enum
			array.add(this.getClass().getSuperclass().getDeclaredField("orientacion"));
			array.add(this.getClass().getSuperclass().getSuperclass().getDeclaredField("color"));
			array.add(this.getClass().getSuperclass().getDeclaredField("type"));
			array.add(this.getClass().getSuperclass().getDeclaredField("hasBeenMoved"));
			array.add(this.getClass().getSuperclass().getDeclaredField("hasAttacked"));
			array.add(this.getClass().getSuperclass().getSuperclass().getDeclaredField("nombreJuego"));
			array.add(this.getClass().getSuperclass().getSuperclass().getDeclaredField("position_y"));
			array.add(this.getClass().getSuperclass().getSuperclass().getDeclaredField("position_x"));


		}
		else{
			array.add(this.getClass().getDeclaredField("life"));
			array.add(this.getClass().getDeclaredField("energy"));
			array.add(this.getClass().getDeclaredField("experience"));
			array.add(this.getClass().getDeclaredField("blindness"));
			array.add(this.getClass().getDeclaredField("poisson"));
			//enum
			array.add(this.getClass().getDeclaredField("orientacion"));
			array.add(this.getClass().getSuperclass().getDeclaredField("color"));
			array.add(this.getClass().getDeclaredField("type"));
			array.add(this.getClass().getDeclaredField("hasBeenMoved"));
			array.add(this.getClass().getDeclaredField("hasAttacked"));
			array.add(this.getClass().getSuperclass().getDeclaredField("name"));
			array.add(this.getClass().getSuperclass().getDeclaredField("position_y"));
			array.add(this.getClass().getSuperclass().getDeclaredField("position_x"));
			
		}


	return array;
	}
	
	/**
	 * Método que se encarga de devolver el contenido de la tabla PiezaOldWarriorTales de la base
	 * de datos
	 * @return array que será el array que contenta toda la información de dicha tabla.
	 */
	
	@Override
	
	public ArrayList<storableInDataBase> takeOutFromDataBase() {
		PieceJDBC p;
		ArrayList<Object>instancias=Reflectividad.instanciarDireccion("Piezas");
		ArrayList<PiezaOldWarriorTales>piezas= new ArrayList<PiezaOldWarriorTales>();
		
		for(Object o: instancias)
		{
			if(o instanceof PiezaOldWarriorTales)
				piezas.add((PiezaOldWarriorTales) o);
		}
		try {
			p = new PieceJDBC();
			ArrayList<storableInDataBase> array= p.getAll("PiezaOldWarriorTales",this.getClass().getName());		
			
			for (storableInDataBase stor: array)
			{
				boolean encontrado=false;
				int i =0;
				do
				{
					if (((PiezaOldWarriorTales)stor).type.equals(piezas.get(i).type))
					{
						PiezaOldWarriorTales piezaNueva= piezas.get(i).getClass().newInstance();
						piezaNueva.setCodePiece(((PiezaOldWarriorTales)stor).getCodePiece());
						piezaNueva.setColor(((PiezaOldWarriorTales)stor).getColor());
						piezaNueva.setPosition(((PiezaOldWarriorTales)stor).getPosition_x(), ((PiezaOldWarriorTales)stor).getPosition_y());
						piezaNueva.setOrientation(((PiezaOldWarriorTales)stor).getOrientacion());
						piezaNueva.setLife(((PiezaOldWarriorTales)stor).getLife());
						piezaNueva.setLife(((PiezaOldWarriorTales)stor).getLife());
						piezaNueva.setEnergy(((PiezaOldWarriorTales)stor).getEnergy());
						piezaNueva.setExperience(((PiezaOldWarriorTales)stor).getExperience());
						piezaNueva.setBlindness(((PiezaOldWarriorTales)stor).isBlind());
						piezaNueva.setPoisson(((PiezaOldWarriorTales)stor).isPoissoned());
						piezaNueva.setHasBeenMoved(((PiezaOldWarriorTales)stor).isHasBeenMoved());
						piezaNueva.setHasAttacked(((PiezaOldWarriorTales)stor).isHasAttacked());
						piezaNueva.setNombreJuego(((PiezaOldWarriorTales)stor).getNombreJuego());
						stor=piezaNueva;
						
					}
					i++;
				}while (encontrado==false && i<piezas.size());
			}
			
			return array;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al cargar1","Error",JOptionPane.OK_OPTION,null);  
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al cargar2","Error",JOptionPane.OK_OPTION,null);  
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error al cargar: \n" + e.getMessage(),"Error",JOptionPane.OK_OPTION,null);  
		}
		//si salta la excepción devolverá un arrayList vacío.
		return new ArrayList <storableInDataBase>();
		
		
	}

	public boolean[][] getAttackAble() {
		return attackAble;
	}

	public void setAttackAble(boolean[][] attackAble) {
		this.attackAble = attackAble;
	}

	public void mostrar(){
		System.out.println("PIEZA......................");
		System.out.println("CodePiece: "+CodePiece);
		System.out.println("color: "+getColor());
		System.out.println("position_x: "+getPosition_x());
		System.out.println("position_y: "+getPosition_y());
		System.out.println("orientacion: "+orientacion);
		System.out.println("life: "+life);
		System.out.println("energy: "+energy);
		System.out.println("experience: "+experience);
		System.out.println("blindnes: "+blindness);
		System.out.println("poisson: "+poisson);
	}
	public static void main (String []args)
	{
		Arquero a= new Arquero();
		System.out.println(a.canAttack());
	}
}