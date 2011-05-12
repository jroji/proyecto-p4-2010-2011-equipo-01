package proyecto.p4.habilidades;

import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;


/**
 * Habilidad Envenenar:
 * Cambia el atributo poisson de una pieza a true.
 *
 */
public class Envenenar extends Hability {

	public Envenenar() {
		name="Envenenar";
		cost=20;
	}
	public Envenenar(PiezaOldWarriorTales pieza) {
		name="Envenenar";
		cost=20;
		this.pieza=pieza;
	}

	/*
	 * (non-Javadoc)
	 * @see proyecto.p4.habilidades.Hability#execute(int[][])
	 * coordenadas (0,0)(0,1) indican pieza a envenenar.
	 */
	@Override
	public void execute(int[][] coordenadas) throws Exception  {
		super.execute(coordenadas);
			if (coordenadas[0].length==2&&coordenadas.length>0){
				PiezaOldWarriorTales pieza=(PiezaOldWarriorTales) this.pieza.getBoard().getPiece(coordenadas[0][0], coordenadas[0][1]);
				pieza.setPoisson(true);
				}else
					throw new IllegalArgumentException ("El array deve de tener el siguiente formato: coordenadas [n][2] donde n>0");

	}

}
