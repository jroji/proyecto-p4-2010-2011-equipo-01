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
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.Ventana.JFrames.MainWindow;
import proyecto.p4.piezaOldWarriorTales.Unidades.Arquero;



import ConnectionInterface.PieceJDBC;
import ConnectionInterface.storableInDataBase;

public class JuegoOldWarriorTales extends Juego implements storableInDataBase{
	
	/**
	 * Constructor por defecto
	 */
	public JuegoOldWarriorTales (){
		name="Old Warrior Tales";
		rutaImagen= "src/img/lgo.jpg";
		tablero= new Board();
	}

	/**
	 * Método que se encarga de decidir que atributos serán guardados en la base de datos.
	 * @throws SecurityException indica una violación de la seguridad.
	 * @throws NoSuchFielException indica que la clase no tiene el atributo con el nombre especificado.
	 * @return array es un ArrayList que contiene aquellos atributos que se guardarán en la base de datos.
	 */ 

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
	
	/**
	 * Método que se encaga de introducir un nuevo juego en la base de datos. Además insertará
	 * las casillas y las piezas pertenecientes al mismo.
	 * @return un entero que será el número de juegos introducidos.
	 */
	@Override
	public int insertIntoDataBase(){
		PieceJDBC p;
		try {
			p = new PieceJDBC();
			p.insert(this.getClass().getSimpleName(), this);
			
			//se recorre el tablero e inserta las piezas y casillas que están en él.
			for(int i=0; i<this.tablero.getBoard().length;i++)
			{
				for(int j=0; j<this.tablero.getBoard()[i].length;j++)
				{
					this.tablero.getBoard()[i][j].setNombreJuego(this.name);
					System.out.println(tablero.getBoard()[i][j]);
					this.tablero.getBoard()[i][j].insertIntoDataBase();
					if (this.tablero.getBoard()[i][j].getPiece()!=null){
						this.tablero.getBoard()[i][j].getPiece().setNombreJuego(this.name);
						this.tablero.getBoard()[i][j].getPiece().insertIntoDataBase();
					}
				}
			}
		
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			//si el juego existe da la opción de sobrescribir
			e.printStackTrace();
			Object [] option ={"SI","NO"};
			int pane=JOptionPane.showOptionDialog(null,
				    "¿Desea sobrescribir? ","Sobrescribir",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
			
			//si desea sobrescribir borra el juego con la misma clave primaria que la que se pretende 
			//insertar e inserta el nuevo juego.
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
	/**
	 * Método que se encarga de borrar de la base de datos el juego especificado.
	 * @return un entero que indica el número de juegos borrados.
	 */
	@Override
	public int deleteFromDataBase() {
			DeleteGame del= new DeleteGame(this);
			del.start();
	
	return 0;
	}

	/**
	 * Método que introduce en un ArrayList el contenido de la tabla JuegoOldWarriorTales.
	 * @return array que contiene la información de dicha tabla.
	 */
	@Override
	public ArrayList<storableInDataBase> takeOutFromDataBase() {
		
		PieceJDBC p;
		try {
			p = new PieceJDBC();
			 ArrayList<storableInDataBase> juegos= p.getAll(this.getClass().getSimpleName(),this.getClass().getName());
			// ArrayList<storableInDataBase> jugadores= new Jugador().takeOutFromDataBase();
			 ArrayList<storableInDataBase> casillas= new Casilla().takeOutFromDataBase();
			 ArrayList<storableInDataBase> piezas= new Arquero().takeOutFromDataBase();
			 System.out.println("Numero de juegos: "+juegos.size());
			 System.out.println("Numero de casillas: "+casillas.size());
			 System.out.println("Numero de piezas: "+piezas.size());
			 for(storableInDataBase jueg: juegos)
			 {
				
				 for(storableInDataBase cas: casillas)
				 {
					 if (((Casilla)cas).getNombreJuego().equals(((JuegoOldWarriorTales)jueg).name))
					 { 
						 ((JuegoOldWarriorTales)jueg).tablero.getBoard()[((Casilla)cas).getPosX()][((Casilla)cas).getPosY()]=(Casilla) cas;
					 }
				 }
				 for(storableInDataBase piez: piezas)
				 {
					 if(((PiezaOldWarriorTales)piez).getNombreJuego().equals(((JuegoOldWarriorTales)jueg).name))
					 {
						 ((PiezaOldWarriorTales)piez).setBoard(this.tablero);
						 ((JuegoOldWarriorTales)jueg).tablero.getBoard()[((PiezaOldWarriorTales)piez).getPosition_x()][((PiezaOldWarriorTales)piez).getPosition_y()].setPiece((PiezaOldWarriorTales)piez);
					 }
				 }
			 }
			return juegos;
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
		j1.setNick("Jon");
		j1.setAvatar("avatar");
		Jugador j2= new Jugador();
		j2.setNick("Raquel");
		j2.setAvatar("avatar");
		j.setName("juego24565");
		
		
		j.setTablero(t);
		j.setJugador1(j1);
		j.setJugador2(j2);
		//j.deleteFromDataBase();
		
		//j.insertIntoDataBase();
		ArrayList<storableInDataBase>ar=j.takeOutFromDataBase();
		for(storableInDataBase stor: ar)
		{
			System.out.println(((JuegoOldWarriorTales)stor).getName());
			System.out.println(((JuegoOldWarriorTales)stor).tablero.getBoard().length);
			System.out.println(((JuegoOldWarriorTales)stor).tablero.getBoard()[0][3].getPiece().getClass().getSimpleName());
			System.out.println(((JuegoOldWarriorTales)stor).tablero.getBoard()[0][3].getPiece().getColor());
		}
		
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



	public void throwWindow(ResourceBundle arg0, boolean arg1) {
		new MainWindow(arg0,arg1,this);	
	}





}
