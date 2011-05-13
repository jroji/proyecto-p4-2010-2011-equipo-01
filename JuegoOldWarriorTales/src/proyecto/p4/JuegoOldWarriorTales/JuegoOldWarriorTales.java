package proyecto.p4.JuegoOldWarriorTales;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import proyecto.p4.Juego.Juego;


import ConnectionInterface.PieceJDBC;
import ConnectionInterface.storableInDataBase;

public class JuegoOldWarriorTales extends Juego implements storableInDataBase{
	
	public JuegoOldWarriorTales (){
		name="Old Warrior Tales";
		rutaImagen= "/img/lgo.jpg";
	}

	

@Override
public ArrayList<Field> fieldsToStore() throws SecurityException,
		NoSuchFieldException {
	ArrayList<Field> array= new ArrayList<Field>();
	array.add(this.getClass().getDeclaredField("identificador"));
	array.add(this.getClass().getDeclaredField("jugador1"));
	array.add(this.getClass().getDeclaredField("jugador2"));
	array.add(this.getClass().getDeclaredField("tablero"));

	return array;
}


@Override
public int insertIntoDataBase(){
	PieceJDBC p;
	try {
		p = new PieceJDBC();
		p.insert(this.getClass().getSimpleName(), this);
		p.insert(this.getClass().getSimpleName(),this.getJugador1());
		p.insert(this.getClass().getSimpleName(),this.getJugador2());
		p.insert(this.getClass().getSimpleName(), this.getTablero());
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
	

public static void main (String []args) throws Exception{
	PieceJDBC co=new PieceJDBC();
	JuegoOldWarriorTales j= new JuegoOldWarriorTales();
	ArrayList<storableInDataBase> juego= co.getAll("JuegoOldWarriorTales", j.getClass().getCanonicalName());

	for(int i=0; i<juego.size();i++)
	System.out.println(juego.get(i));
	
	j.setIdentificador(1);
	
	co.insert("JuegoOldWarriorTales", j);


}



@Override
public int deleteFromDataBase() {
	PieceJDBC p;
	
	try {
		p = new PieceJDBC();
		p.remove(name, this);
		p.remove(name, (storableInDataBase) this.getJugador1());
		p.remove(name, (storableInDataBase) this.getJugador2());
		//tablero es un atributo de juego de la clase mapa/board que es un array de casillas
		p.remove(name, (storableInDataBase)this.getTablero());
	} catch (ClassNotFoundException e) {
		JOptionPane.showMessageDialog(null,"Error al sobreescribir","Error",JOptionPane.OK_OPTION,null);  

	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"Error al sobreescribir","Error",JOptionPane.OK_OPTION,null);  

		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Error al sobreescribir","Error",JOptionPane.OK_OPTION,null);  

	}
	

return 0;
}




@Override
public ArrayList<storableInDataBase> takeOutFromDataBase() {
	
	PieceJDBC p;
	try {
		p = new PieceJDBC();
		ArrayList<storableInDataBase> array= new ArrayList <storableInDataBase>();
		array= p.getAll(this.getClass().getSimpleName(),this.getClass().getName());
		return array;
	} catch (ClassNotFoundException e) {
		JOptionPane.showMessageDialog(null,"Error al cargar","Error",JOptionPane.OK_OPTION,null);  
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"Error al cargar","Error",JOptionPane.OK_OPTION,null);  
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Error al cargar","Error",JOptionPane.OK_OPTION,null);  
	}
	//si salta la excepción devolverá un arrayList vacío.
	return new ArrayList <storableInDataBase>();
	
	
}

}
