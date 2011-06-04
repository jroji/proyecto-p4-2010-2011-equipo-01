package proyecto.p4.JuegoOldWarriorTales;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import proyecto.p4.Juego.Juego;
import proyecto.p4.Jugador.Jugador;
import proyecto.p4.Mapa.Board;
import proyecto.p4.Mapa.Casilla;
import proyecto.p4.Piece.Colours;
import proyecto.p4.Ventana.JFrames.MainWindow;
import proyecto.p4.piezaOldWarriorTales.Unidades.Arquero;


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
		array.add(this.getClass().getSuperclass().getDeclaredField("playing"));
	
		return array;
	}
	
	
	@Override
	public int insertIntoDataBase(){
		PieceJDBC p;
		try {
			p = new PieceJDBC();
			p.insert(this.getClass().getSimpleName(), this);
			
			for(int i=0; i<this.tablero.getBoard().length;i++)
			{
				for(int j=0; j<this.tablero.getBoard()[i].length;j++)
				{
					this.tablero.getBoard()[i][j].setNombreJuego(this.name);
					System.out.println(tablero.getBoard()[i][j]);
					this.tablero.getBoard()[i][j].insertIntoDataBase();
					if (this.tablero.getBoard()[i][j].getPiece()!=null){
						this.tablero.getBoard()[i][j].getPiece().setNombreJuego(this.name);
						System.out.println("PiezaIntroducida________________________________________5");
						this.tablero.getBoard()[i][j].getPiece().insertIntoDataBase();
					}
				}
			}
		
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
		
			DeleteGame del= new DeleteGame(this);
			del.start();
			//tablero es un atributo de juego de la clase mapa/board que es un array de casillas
		//p.remove(name, (storableInDataBase)this.getTablero());
		
		
	
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
		Arquero a1= new Arquero();
		a1.setPosition(0, 3);
		a1.setBoard(t);
		a1.setColor(Colours.blanco);
		t.getCasilla(a1.getPosition_x(), a1.getPosition_y()).setPiece(a1);
		j1.setNick("jugador 1");
		j1.setAvatar("avatar");
		Jugador j2= new Jugador();
		j2.setNick("jugador 2");
		j2.setAvatar("avatar");
		j.setName("juego24565");
		
		
		j.setTablero(t);
		j.setJugador1(j1);
		j.setJugador2(j2);
		j.deleteFromDataBase();
		
		//j.insertIntoDataBase();
		
		
//		ArrayList<storableInDataBase>array=j.takeOutFromDataBase();
//		for(storableInDataBase stor:array)
//		{
//			System.out.println(((JuegoOldWarriorTales)stor).getName());
//			System.out.println(((JuegoOldWarriorTales)stor).getJugador2().getNick());
//			System.out.println(((JuegoOldWarriorTales)stor).getJugador1().getNick());
//		}
		
	
	
	}
//	public static void main (String []args) throws InterruptedException
//	{
//		System.out.println("uno");
//		DeleteGame thread = new DeleteGame(null);
//		thread.start();
//		Thread.sleep(500l);
//		System.out.println("dos");
//	}



	@Override
	public void throwWindow(ResourceBundle arg0, boolean arg1) {
		new MainWindow(arg0,arg1,this);	
	}





}
