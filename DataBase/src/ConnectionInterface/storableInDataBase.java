package ConnectionInterface;

import java.lang.reflect.Field;
import java.util.ArrayList;

public interface storableInDataBase {

	/**
	 * Este m�todo devuelve todos los atributos que se introducir�n en la base de datos en el orden
	 * en el que est�n en �sta.
	 * @return array de atributos a introducir en la bd.
	 */
	public ArrayList <Field> fieldsToStore();
		
		
		
		
	
}
