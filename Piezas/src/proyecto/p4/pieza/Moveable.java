package proyecto.p4.pieza;

/** Interfaz moveable que implementaran las clases que puedan moverse por el tablero
 * con un unico metodo Moveable.
 * 
 */
public interface Moveable {
	
	/** Indica si puede moverse a la posicion indicada como coordenadas en los parametros
	 * 
	 * @param posX. Coordenada X de la posicion a la que desea moverse
	 * @param posY. Coordenada Y de la posicion a la que desea moverse
	 * @return boolean. True si puede moverse
	 */
	public boolean canMove (int posX, int posY);
}
