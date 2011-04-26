package proyecto.p4.habilidades;

import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;
import Proyecto.p4.casilla.Casilla;

/**
 * Habilidad Sprint:
 * aumenta el atributo movements en dos para el siguiente movimiento
 *
 */
public class Sprint extends Hability {
	
	public Sprint(){
		name="Sprint";
		cost=20;
	}
	public Sprint (PiezaOldWarriorTales pieza){
		name="Sprint";
		cost=20;
		this.pieza=pieza;
	}
	/*
	 * (non-Javadoc)
	 * @see proyecto.p4.habilidades.Hability#execute(int[][])
	 * coordenadas (0,0),(0,1) indican casilla a mover
	 * @throws Exception si no se puede mover a la casilla indicada
	 */
	@Override
	public void execute(int[][] coordenadas) throws Exception {
		super.execute(coordenadas);
			//validacion del formato del array
			if (coordenadas[0].length==2&&coordenadas.length>0){
				//modificacion de atributos; atributo movement +2
				pieza.setMovement(pieza.getMovement()+2);
				//obtener casilla actual y a mover
				Casilla actual=pieza.getBoard().getCasilla(pieza.getPosition_x(), pieza.getPosition_y());
				Casilla a_mover= pieza.getBoard().getCasilla(coordenadas[0][0], coordenadas[0][1]);
				//mover pieza
				pieza.move(actual, a_mover);
				//devolver valor de atributos a estado incial
				pieza.setMovement(pieza.getMovement()+2);
			}else 
				throw new IllegalArgumentException ("El array deve de tener el siguiente formato: coordenadas [n][2] donde n>0");
		
	}
	


}
