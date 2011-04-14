package pruebas;

import java.lang.reflect.Field;
import java.util.ArrayList;

import ConnectionInterface.storableInDataBase;

public class coche implements storableInDataBase{

	private int mat;
	private String color;
	@Override
	public ArrayList<Field> fieldsToStore() {
		// TODO Auto-generated method stub
		return null;
	}
}
