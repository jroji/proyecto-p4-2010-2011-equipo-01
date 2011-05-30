package proyecto.p4.PiezasOldWarriorTales;

public class AlreadyDoneException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4746692284549087005L;

	public AlreadyDoneException ()
	{
		super("The action has already be done in this turn");
	}
	public AlreadyDoneException (String msg)
	{
		super(msg);
	}
}
