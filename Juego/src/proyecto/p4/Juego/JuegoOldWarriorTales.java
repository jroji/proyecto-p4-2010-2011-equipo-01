package proyecto.p4.Juego;

import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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


@Override
public int insertIntoDataBase(){
	try{
	insert("juegoOldWarriorTales de la otra forma", this );
	insert("Jugador",this.Jugador1);
	insert("Casilla",this.jugador2);
	insert("")
	
	}catch(SQL Exception){
		Object [] option ={"SI","NO"};
		JOptionPane pane =new JOptionPane(this,"Desea sobreescribir la partida?", "Sobreescribir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
		if(pane==0){
			deleteFromDataBase("nombre tabla",this);
			return insertIntoDataBase();
			
		}
		
		else{
			return 0;
		}
	
	
	}
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
