package pruebas;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

import ConnectionInterface.PieceJDBC;
import ConnectionInterface.storableInDataBase;

public class cliente implements storableInDataBase{

	private int dni;
	private String nom;
	private coche coche;
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	
	public String toString (){
		return dni+" "+nom;
	}
	
public static void main (String []arts) throws Exception{
	PieceJDBC co=new PieceJDBC();
	co.nombreTablas();
	cliente c1= new cliente ();
	c1.dni=544;
	c1.nom="julen";
	//co.insert("cliente", c1);
	System.out.println(co.remove(c1));
	
	ArrayList<storableInDataBase> perro= co.getAll("cliente", "pruebas.cliente");

	for(int i=0; i<perro.size();i++)
	System.out.println(perro.get(i));


	


}

@Override
public ArrayList<Field> fieldsToStore() throws SecurityException, NoSuchFieldException {
	ArrayList<Field> array= new ArrayList<Field>();
		array.add(this.getClass().getDeclaredField("dni"));
		array.add(this.getClass().getDeclaredField("nom"));
	
	return array;
}

@Override
public int insertIntoDataBase() {
	// TODO Auto-generated method stub
	return 0;
}


@Override
public ArrayList<storableInDataBase> takeOutFromDataBase() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public int deleteFromDataBase() {
	// TODO Auto-generated method stub
	return 0;
}

//@Override
//public int insertIntoDataBase() {
//	// TODO Auto-generated method stub
//	return 0;
//}
}
