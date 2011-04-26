package proyecto.p4.habilidades;

public class NotEnoughEnergyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -260759008775051515L;
	
	public NotEnoughEnergyException(){
		super ("La pieza no tiene suficiente energia");
	}
	public NotEnoughEnergyException (String msg){
		super(msg);
	}
}
