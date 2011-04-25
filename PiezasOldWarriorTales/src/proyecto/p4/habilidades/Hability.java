package proyecto.p4.habilidades;

import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;

public abstract class Hability {
	protected String name;
	protected int cost;
	protected PiezaOldWarriorTales pieza;
	
	public String toString(){
		return name;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}
	/**
	 * ejecucion de la habilidad
	 * @param coordenadas de las que se sacaran las piezas o 
	 * casillas necesarias para ejecutar la habilidad.
	 * El array devera tener el siguiente formato: coordenadas[n][2]
	 * @throws IllegaArgumentException si el formato del array es incorrecto
	 */
	public abstract void execute (int [][]coordenadas)throws Exception;

}
