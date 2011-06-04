package proyecto.p4.Jugador;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import proyecto.p4.Ventana.JFrames.NewPlayerWindow;

import ConnectionInterface.PieceJDBC;
import ConnectionInterface.storableInDataBase;

public class Jugador implements storableInDataBase{
private String Nick;
private String avatar;

/**
 * Constructor que inicializa en vacío los atributos de un objeto jugador.
 */
public Jugador(){
	Nick="";
	avatar="";
}

/**
 * Constructor con parámetros
 * @param nick es el string que corresponde al nick del jugador
 * @param avatar es el string que corresponde a la ruta del avatar del jugador
 */
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

/**
 * Método que se encarga de añadir al array aquellos atributos que serán guardados en la base de
 * datos a la hora de insertar un nuevo jugador.
 * @throws SecurityException indica una violación de la seguridad.
 * @throws NoSuchFielException indica que la clase no tiene el atributo con el nombre especificado.
 * @return array es un ArrayList que contiene aquellos atributos que se guardarán en la base de datos.
 */
public ArrayList <Field> fieldsToStore() throws SecurityException, NoSuchFieldException{
	ArrayList<Field> array= new ArrayList<Field>();
	array.add(this.getClass().getDeclaredField("Nick"));
	array.add(this.getClass().getDeclaredField("avatar"));

return array;
}

@SuppressWarnings("finally")
@Override
/**
 * Método que se encarga de eliminar de la base de datos el jugador especificado.
 * @return valueToReturn que indica a través de un entero el número de jugadores borrados.
 */
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
/**
 * Método que se encarga de insertar en la base de datos un nuevo jugador.
 * @return un entero que será el número de jugadores insertados en la base de datos.
 */
public int insertIntoDataBase() {
	PieceJDBC p;
	try {
		p = new PieceJDBC();
		
		p.insert(this.getClass().getSimpleName(), this);
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e) {
		
		//Si salta la excepción de SQLException será porque ya existe en la base de datos el nick 
		//especificado por lo que se le dirá si desea sobrescribir el jugador o no.
		Object [] option ={"SI","NO"};
		int pane=JOptionPane.showOptionDialog(null,
			    "¿Desea sobrescribir? ","Sobreescribir",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
		
		//Si desea sobrescribir borrará de la base de datos el jugador que tenga el nick especificado e 
		//insertará el nuevo jugador con el mismo nick pero con posibilidad de tener el avatar diferente.
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
/**
 * Método que se encarga de introducir a un ArrayList todo el contenido de la tabla Jugador
 * de la base de datos.
 * @return array que será un ArrayList que contenta toda la información de la tabla jugador.
 */
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
	//ArrayList<storableInDataBase> array=c1.takeOutFromDataBase();
	
//	for (storableInDataBase sdb: array){
//		System.out.println(((Jugador)sdb).getNick());
//	}

}


}
