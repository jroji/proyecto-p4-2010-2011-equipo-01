package proyecto.p4.Jugador;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ConnectionInterface.PieceJDBC;
import ConnectionInterface.storableInDataBase;

public class Jugador implements storableInDataBase{
private String Nick;
private String avatar;

public Jugador(){
	Nick="";
	avatar="";
}
public Jugador(String nick, String avatar){
	this.Nick=nick;
	this.avatar=avatar;
}

public String getNick() {
	return Nick;
}


public void setNick(String nick) {
	this.Nick = nick;
}


public String getAvatar() {
	return avatar;
}


public void setAvatar(String avatar) {
	this.avatar = avatar;
}


public ArrayList <Field> fieldsToStore() throws SecurityException, NoSuchFieldException{
	ArrayList<Field> array= new ArrayList<Field>();
	array.add(this.getClass().getDeclaredField("Nick"));
	array.add(this.getClass().getDeclaredField("avatar"));

return array;
}

@SuppressWarnings("finally")
@Override
public int deleteFromDataBase() {
	PieceJDBC p;
	int valueToReturn=0;
		try {
			p = new PieceJDBC();
			valueToReturn+=p.remove("Jugador", this);
			
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error al borrar1","Error",JOptionPane.OK_OPTION,null);  
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Error al borrar2","Error",JOptionPane.OK_OPTION,null);  
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error al borrar3","Error",JOptionPane.OK_OPTION,null);  
			
		}
		finally{
			return valueToReturn;
		}
		
	
	
}

@Override
public int insertIntoDataBase() {
	PieceJDBC p;
	try {
		p = new PieceJDBC();
		p.insert(this.getClass().getSimpleName(), this);
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e) {
		Object [] option ={"SI","NO"};
		int pane=JOptionPane.showOptionDialog(null,
			    "¿Desea sobreescribir? ","Sobreescribir",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
		
		if(pane==0){
			deleteFromDataBase();
			return insertIntoDataBase();
			
		}
		
		else{
			return 0;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 1;
	}
	

@Override
public ArrayList<storableInDataBase> takeOutFromDataBase() {
	PieceJDBC p;
	try {
		p = new PieceJDBC();
		ArrayList<storableInDataBase> array= p.getAll(this.getClass().getSimpleName(),this.getClass().getName());		
		return array;
	} catch (ClassNotFoundException e) {
		JOptionPane.showMessageDialog(null,"Error al cargar1","Error",JOptionPane.OK_OPTION,null);  
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"Error al cargar2","Error",JOptionPane.OK_OPTION,null);  
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Error al cargar3","Error",JOptionPane.OK_OPTION,null);  
	}
	//si salta la excepción devolverá un arrayList vacío.
	return new ArrayList <storableInDataBase>();
	
	
}
/**
 * Pruebas DataBase
 * @param arts
 * @throws Exception
 */
public static void main (String []arts) throws Exception{
	Jugador c1= new Jugador ();
	c1.setNick("juen");
	c1.setAvatar("img6");
	//c1.insertIntoDataBase();
	c1.deleteFromDataBase();
	//System.out.println(c1.deleteFromDataBase());
	ArrayList<storableInDataBase> array=c1.takeOutFromDataBase();
	
	for (storableInDataBase sdb: array){
		System.out.println(((Jugador)sdb).getNick());
	}

}


}
