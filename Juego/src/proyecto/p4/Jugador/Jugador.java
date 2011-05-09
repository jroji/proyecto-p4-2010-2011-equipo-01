package proyecto.p4.Jugador;

import java.lang.reflect.Field;
import java.util.ArrayList;

import ConnectionInterface.PieceJDBC;
import ConnectionInterface.storableInDataBase;

public class Jugador implements storableInDataBase{
private String nick;
private String avatar;

public Jugador(){
	nick="";
	avatar="";
}
public Jugador(String nick, String avatar){
	this.nick=nick;
	this.avatar=avatar;
}

public String getNick() {
	return nick;
}


public void setNick(String nick) {
	this.nick = nick;
}


public String getAvatar() {
	return avatar;
}


public void setAvatar(String avatar) {
	this.avatar = avatar;
}


public ArrayList <Field> fieldsToStore() throws SecurityException, NoSuchFieldException{
	ArrayList<Field> array= new ArrayList<Field>();
	array.add(this.getClass().getDeclaredField("nick"));
	array.add(this.getClass().getDeclaredField("avatar"));

return array;
}


/**
 * Pruebas DataBase
 * @param arts
 * @throws Exception
 */
public static void main (String []arts) throws Exception{
	PieceJDBC co1=new PieceJDBC();
	String a= "C:/Users/Raquel/workspace/Juego/src/proyecto/p4/Jugador";
	Jugador c1= new Jugador ();
	ArrayList<storableInDataBase> player= co1.getAll("jugador",c1.getClass().getCanonicalName());

	for(int i=0; i<player.size();i++)
	System.out.println(player.get(i));
	
	
	c1.nick="o";
	c1.avatar="direccionavatar";
	co1.insert("Jugador", c1);


}
@Override
public int deleteFromDataBase() {
	// TODO Auto-generated method stub
	return 0;
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

}
