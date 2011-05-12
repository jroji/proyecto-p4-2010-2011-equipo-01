package proyecto.p4.PiezasOldWarriorTales.Habilidades;

import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;


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
	 * @throws NotEnoughEnergyException si la pieza no tiene suficiente 
	 * energia como para ejecutar la habilidad.
	 */
	public void execute (int [][]coordenadas)throws Exception{
		if (!enoughEnergy())
			throw new NotEnoughEnergyException();
	}
	
	/**
	 * Metodo que indica si la pieza tiene suficiente energia como para ejecutar la habilidad
	 * @return true si a pieza tiene suficiente energia como para ejecutar la habilidad
	 */
	protected boolean enoughEnergy (){
		if (pieza.getEnergy()>=cost){
			return true;
		}else
			return false;
	}
	public int [][] obtenerCoordenadas(){
		//implementar metodo en cada subclase
		return null;
	}

}
