package proyecto.p4.habilidades;

import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;

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
			
			pieza.attack(coordenadas[0][0], coordenadas[0][1]);
			pieza.move(coordenadas[1][0], coordenadas[1][1]);
		}else 
			throw new IllegalArgumentException ("El array deve de tener el siguiente formato: coordenadas [n][2] donde n>1");

	}

}
