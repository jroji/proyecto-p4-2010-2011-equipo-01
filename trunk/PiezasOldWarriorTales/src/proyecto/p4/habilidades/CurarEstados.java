package proyecto.p4.habilidades;

import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;


/**
 * Habilidad curar estados:
 * cambia a false los atributos blind y poisson de una pieza.
 * 
 */
public class CurarEstados extends Hability {

	public CurarEstados() {
		name="Curar estados";
		cost=20;
	}
	public CurarEstados(PiezaOldWarriorTales pieza) {
		name="Curar estados";
		cost=20;
		this.pieza=pieza;
	}
	@Override
	public void execute(int[][] coordenadas) throws Exception {
		super.execute(coordenadas);
		if (coordenadas[0].length==2&&coordenadas.length>1){
			((PiezaOldWarriorTales)pieza.getBoard().getPiece(coordenadas[0][0], coordenadas[0][1])).
			setBlindness(false);
			((PiezaOldWarriorTales)pieza.getBoard().getPiece(coordenadas[0][0], coordenadas[0][1])).
			setPoisson(false);
		}else 
			throw new IllegalArgumentException ("El array deve de tener el siguiente formato: coordenadas [n][2] donde n>1");
	}


}
