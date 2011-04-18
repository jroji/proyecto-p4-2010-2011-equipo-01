package pruebas;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

import ConnectionInterface.PieceJDBC;
import ConnectionInterface.storableInDataBase;

public class cliente implements storableInDataBase{

	public int dni;
	public String nom;
	
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
		return dni+nom;
	}
	
public static void main (String []arts) throws Exception{
	PieceJDBC co=new PieceJDBC();
	ArrayList<Object> perro= co.getAll("cliente", "pruebas.cliente");

	for(int i=0; i<perro.size();i++)
	System.out.println(perro.get(i));
	
	cliente c1= new cliente ();
	c1.dni=55434556;
	c1.nom="Yo";
	co.insert("cliente", c1);


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
}
