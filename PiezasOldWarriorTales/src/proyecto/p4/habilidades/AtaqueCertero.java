
package proyecto.p4.habilidades;

import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;

/**
 * Habilidad ataque certero:
 * aumenta la precision de la pieza en 20 y disminuye el daño en 10
 * para el siguiente ataque
 * 
 */
public class AtaqueCertero extends Hability{
	public AtaqueCertero(){
		name="Ataque certero";	
		cost=20;
	}
	public AtaqueCertero(PiezaOldWarriorTales pieza){
		name="Ataque certero";	
		cost=20;
		this.pieza=pieza;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see proyecto.p4.habilidades.Hability#execute(int[][])
	 * coordendas (0,0),(0,1) indican pieza a la que atacar
	 */
	@Override
	public void execute (int [][]coordenadas) throws IllegalArgumentException{
		
		//validacion del formato del array
		if (coordenadas[0].length==2&&coordenadas.length>0){
		//precision+20, daño-10
		pieza.setAttack(pieza.getAttack()-10);
		pieza.setProbability(pieza.getProbability()+20);
		
		//obtener pieza a la que atacar
		PiezaOldWarriorTales pieza_a_atacar=(PiezaOldWarriorTales) pieza.getBoard().getPiece (coordenadas[0][0],coordenadas[0][1]);
		//atacar a la pieza obtenida
		pieza.attack(pieza_a_atacar);
		//devolver los atributos a su estado inicial
		pieza.setAttack(pieza.getAttack()+10);
		
		}else 
			throw new IllegalArgumentException ("El array deve de tener el siguiente formato: coordenadas [n][2] donde n>0");
	}
}
