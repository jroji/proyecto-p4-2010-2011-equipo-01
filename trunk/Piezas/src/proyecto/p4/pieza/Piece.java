package proyecto.p4.pieza;

import javax.swing.ImageIcon;

/* Clase padre de las piezas de todos los juegos.
 * Es abstracta, puesto que no se quiere permitir instanciar objetos de este tipo, sino
 * de sus clases hijas.
 * 
 * @implements Moveable 
 * 
 */
public abstract class Piece implements Moveable{
	public enum Colours {blanco, negro};
	private int position_x;
	private int position_y;
	
	//color que indica el bando al que pertenece la pieza
	private Colours color;
	private ImageIcon imagen;
	
	//array bidimensional booleano que indica las casillas a las que se puede mover
	private boolean [][] able_to_move;
	
	
	
	/** Metodo que modifica el atributo able_to_move escribiendo true en las posiciones a las que 
	 * puede moverse la pieza y false en las que no en base al resultado devuelto por el metodo
	 * canMove.
	 * 
	 * @see Moveable.#canMove
	 */
	public void setAbleToMove (){
		for (int i =0; i<able_to_move.length;i++)
		{
			for(int j=0; j<able_to_move[i].length;j++)
				able_to_move [i][j]= canMove (i,j);
		}
	}

}
