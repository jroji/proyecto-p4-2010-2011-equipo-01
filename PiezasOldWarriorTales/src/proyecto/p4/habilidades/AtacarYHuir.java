package proyecto.p4.habilidades;

import Proyecto.p4.casilla.Casilla;
import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;
/** 
 * Habilidad Atacar y huir:
 * Permite a una pieza atacar y moverse despues.
 *
 */
public class AtacarYHuir extends Hability {

	public AtacarYHuir() {
		name="Atacar y Huir";
		cost=20;
	}
	public AtacarYHuir(PiezaOldWarriorTales pieza) {
		name="Atacar y Huir";
		cost=20;
		this.pieza=pieza;
	}
	
	/*
	 * (non-Javadoc)
	 * @see proyecto.p4.habilidades.Hability#execute(int[][])
	 * las coordendas (0,0)(0,1) indican la pieza a atacar
	 * las coordenadas (1,0)(1,1) indican la casilla a mover
	 */
	@Override
	public void execute(int[][] coordenadas) throws Exception {
		super.execute(coordenadas);
		//validacion del formato del array
		if (coordenadas[0].length==2&&coordenadas.length>1){
			PiezaOldWarriorTales pieza_a_atacar= (PiezaOldWarriorTales) pieza.getBoard().getPiece(coordenadas[0][0], coordenadas[0][1]);
			Casilla casilla_a_mover=pieza.getBoard().getCasilla(coordenadas[1][0], coordenadas[1][1]);
			Casilla casilla_actual=pieza.getBoard().getCasilla(pieza.getPosition_x(), pieza.getPosition_y());
			pieza.attack(pieza_a_atacar);
			pieza.move(casilla_actual, casilla_a_mover);
		}else 
			throw new IllegalArgumentException ("El array deve de tener el siguiente formato: coordenadas [n][2] donde n>1");

	}

}
