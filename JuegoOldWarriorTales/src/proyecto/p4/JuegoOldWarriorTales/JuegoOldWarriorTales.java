package proyecto.p4.JuegoOldWarriorTales;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import proyecto.p4.Juego.Juego;
import proyecto.p4.Jugador.Jugador;
import proyecto.p4.Mapa.Board;
import proyecto.p4.Mapa.Casilla;


import ConnectionInterface.PieceJDBC;
import ConnectionInterface.storableInDataBase;

public class JuegoOldWarriorTales extends Juego implements storableInDataBase{
	
	public JuegoOldWarriorTales (){
		name="Old Warrior Tales";
		rutaImagen= "src/img/lgo.jpg";
	}

	

	@Override
	public ArrayList<Field> fieldsToStore() throws SecurityException,
			NoSuchFieldException {
		ArrayList<Field> array= new ArrayList<Field>();
		array.add(this.getClass().getSuperclass().getDeclaredField("name"));
		array.add(this.getClass().getSuperclass().getDeclaredField("jugador1"));
		array.add(this.getClass().getSuperclass().getDeclaredField("jugador2"));
	
		return array;
	}
	
	
	@Override
	public int insertIntoDataBase(){
		PieceJDBC p;
		try {
			p = new PieceJDBC();
			p.insert(this.getClass().getSimpleName(), this);

			this.tablero.insertIntoDataBase();
		
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
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
	public int deleteFromDataBase() {
		PieceJDBC p;
		
		try {
			p = new PieceJDBC();
			p.remove("JuegoOldWarriorTales", this);
//			p.remove("Jugador",this.getJugador1());
//			p.remove("Jugador", this.getJugador2());
			//tablero es un atributo de juego de la clase mapa/board que es un array de casillas
		//p.remove(name, (storableInDataBase)this.getTablero());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al sobreescribir","Error",JOptionPane.OK_OPTION,null);  
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al sobreescribir","Error",JOptionPane.OK_OPTION,null);  
		} catch (Exception e) {
			e.printStackTrace();
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
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al cargar","Error",JOptionPane.OK_OPTION,null);  
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al cargar","Error",JOptionPane.OK_OPTION,null);  
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error al cargar","Error",JOptionPane.OK_OPTION,null);  
		}
		//si salta la excepción devolverá un arrayList vacío.
		return new ArrayList <storableInDataBase>();
		
		
	}

	public static void main (String []args) throws Exception{
		JuegoOldWarriorTales j= new JuegoOldWarriorTales();
		Jugador j1= new Jugador();
		//recoge el tablero que contiene el array de casillas pertenecientes al juego.
		
		Board t= new Board();
		j.setTablero(t);
		
	
		j1.setNick("jugador 1");
		j1.setAvatar("avatar");
		Jugador j2= new Jugador();
		j2.setNick("jugador 2");
		j2.setAvatar("avatar");
		j.setName("juego24565");
		j.setJugador1(j1);
		j.setJugador2(j2);
		//j.deleteFromDataBase();
		
		j.insertIntoDataBase();
		
		
//		ArrayList<storableInDataBase>array=j.takeOutFromDataBase();
//		for(storableInDataBase stor:array)
//		{
//			System.out.println(((JuegoOldWarriorTales)stor).getName());
//			System.out.println(((JuegoOldWarriorTales)stor).getJugador2().getNick());
//			System.out.println(((JuegoOldWarriorTales)stor).getJugador1().getNick());
//		}
		
	
	
	}

}
