package ConnectionInterface;

import java.lang.reflect.Field;
import java.util.ArrayList;

public interface storableInDataBase {

	/**
	 * Este método devuelve todos los atributos que se introducirán en la base de datos en el orden
	 * en el que están en ésta.
	 * @return array de atributos a introducir en la bd.
	 */
	public ArrayList <Field> fieldsToStore();
		
		
		
		
	
}
