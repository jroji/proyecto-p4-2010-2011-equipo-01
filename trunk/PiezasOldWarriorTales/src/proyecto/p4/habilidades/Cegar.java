package proyecto.p4.habilidades;

import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;

/**
 * Habilidad Cegar:
 * Cambia a true el atributo blind de una pieza.
 */
public class Cegar extends Hability{

	public Cegar() {
		name="cegar";
		cost=20;
	}
	public Cegar(PiezaOldWarriorTales pieza) {
		name="cegar";
		cost=20;
		this.pieza=pieza;
	}
	/*
	 * (non-Javadoc)
	 * @see proyecto.p4.habilidades.Hability#execute(int[][])
	 * las coordenadas (0,0)(0,1)indican la pieza a cegar
	 */
	@Override
	public void execute(int[][] coordenadas) throws Exception {
		super.execute(coordenadas);
		if (coordenadas[0].length==2&&coordenadas.length>1){
			((PiezaOldWarriorTales)pieza.getBoard().getPiece(coordenadas[0][0], coordenadas[0][1])).
			setBlindness(true);
			
		}else 
			throw new IllegalArgumentException ("El array deve de tener el siguiente formato: coordenadas [n][2] donde n>1");

	}

}
