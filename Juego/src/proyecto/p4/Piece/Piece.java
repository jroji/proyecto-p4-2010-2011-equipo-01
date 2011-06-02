package proyecto.p4.Piece;

import javax.swing.ImageIcon;

import ConnectionInterface.storableInDataBase;

import proyecto.p4.Mapa.Casilla;


/** Clase padre de las piezas de todos los juegos.
 * Es abstracta, puesto que no se quiere permitir instanciar objetos de este tipo, sino
 * de sus clases hijas.
 * 
 * @implements Moveable 
 * 
 */
public abstract class Piece implements Moveable, storableInDataBase{
	private int position_x;
	private int position_y;
	private ImageIcon imagen;	
	//color que indica el bando al que pertenece la pieza
	private Colours color;
	//array bidimensional booleano que indica las casillas a las que se puede mover
	protected boolean [][] able_to_move;


	//METODOS:
	
	
	public boolean[][] getAble_to_move() {
		return able_to_move;
	}

	public void setAble_to_move(boolean[][] able_to_move) {
		this.able_to_move = able_to_move;
	}
	
	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}
	
	public Colours getColor() {
		return color;
	}

	public void setColor(Colours color) {
		this.color = color;
	}

	public int getPosition_x() {
		return position_x;
	}

	public int getPosition_y() {
		return position_y;
	}

	/**
	 * Modifica las coordenadas de la pieza y actualiza el array able_to_move
	 * @param positionX
	 * @param positionY
	 */
	public void setPosition(int positionX, int positionY) {
		this.position_x = positionX;
		this.position_y = positionY;
		setAbleToMove();
	}
	
	/**
	 * Metodo que mueve la pieza de una casilla a otra
	 * 
	 * @param casillaActual Casilla en la que la pieza se encuentra actualmente
	 * @param casillaAMover Casilla a la que se quiere mover la pieza
	 * @throws Exception si no puede moverse a la casilla deseada
	 */
	protected void move (Casilla casillaActual, Casilla casillaAMover) throws Exception{
		
		//se comprueba si la pieza puede moverse hasta la casilla a mover
		if (able_to_move[casillaAMover.getPosX()][casillaAMover.getPosY()]){
			
			//se comprueba que la casilla a mover este vacia
			if (casillaAMover.getPiece()==null){
				//se modifican las coordenadas de la pieza
				setPosition(casillaAMover.getPosX(),casillaAMover.getPosY());
				
				//se modica el atributo pieza de las dos casillas
				casillaAMover.setPiece(this);
				casillaActual.setPiece(null);
				
			}else throw new Exception("no puede moverse a la casilla, casilla ocupada");
		}else throw new Exception("no puede moverse a la casilla, fuera de alcance");
	}

	/** Metodo que modifica el atributo able_to_move escribiendo true en las posiciones a las que 
	 * puede moverse la pieza y false en las que no en base al resultado devuelto por el metodo
	 * canMove.
	 * 
	 * @see Moveable.#canMove
	 */
	private void setAbleToMove (){
		for (int i =0; i<able_to_move.length;i++)
		{
			for(int j=0; j<able_to_move[i].length;j++)
				able_to_move [i][j]= canMove (i,j);
		}
	}
	
}
