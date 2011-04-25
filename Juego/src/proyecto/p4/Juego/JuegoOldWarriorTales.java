package proyecto.p4.Juego;

import java.lang.reflect.Field;
import java.util.ArrayList;

import pruebas.cliente;

import ConnectionInterface.PieceJDBC;
import ConnectionInterface.storableInDataBase;

public class JuegoOldWarriorTales extends Juego implements storableInDataBase{
	
	public JuegoOldWarriorTales (){
		name="Old Warrior Tales";
		rutaImagen= "??";
	}

	

@Override
public ArrayList<Field> fieldsToStore() throws SecurityException,
		NoSuchFieldException {
	ArrayList<Field> array= new ArrayList<Field>();
	array.add(this.getClass().getDeclaredField("identificador"));
	

	return array;
}

public static void main (String []args) throws Exception{
	PieceJDBC co=new PieceJDBC();
	JuegoOldWarriorTales j= new JuegoOldWarriorTales();
	ArrayList<Object> juego= co.getAll("JuegoOldWarriorTales", j.getClass().getCanonicalName());

	for(int i=0; i<juego.size();i++)
	System.out.println(juego.get(i));
	
	j.setIdentificador(1);
	
	co.insert("JuegoOldWarriorTales", j);


}

}
