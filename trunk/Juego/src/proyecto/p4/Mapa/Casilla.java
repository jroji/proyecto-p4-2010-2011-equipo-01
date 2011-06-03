package proyecto.p4.Mapa;



import javax.swing.JOptionPane;

import proyecto.p4.Piece.Piece;
import proyecto.p4.Tipo.OldWarriorTales.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;


import ConnectionInterface.PieceJDBC;
import ConnectionInterface.storableInDataBase;


public class Casilla implements storableInDataBase{
	private int CodeCasilla;
	public Square square;
	private int PosX;
	private int PosY;
	private Piece piece;
	private String nombreJuego;
	
	public  Casilla (){
		square=null;
		PosX=0;
		PosY=0;
		piece=null;
		
		
	}
	

	public  Casilla (Square sq, int X, int Y, Piece pie){
		square= sq;
		PosX=X;
		PosY=Y;
		piece=pie;
	}
	
	
	public String getNombreJuego() {
		return nombreJuego;
	}


	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}


	public Piece getPiece() {
		return piece;
	}
	public int getCodeCasilla() {
		return CodeCasilla;
	}
	public void setCodeCasilla(int codeCasilla) {
		CodeCasilla = codeCasilla;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	public Square getSquare() {
		return square;
	}
	public void setSquare(Square square) {
		this.square = square;
	}
	public int getPosX() {
		return PosX;
	}
	public void setPosX(int posX) {
		PosX = posX;
	}
	public int getPosY() {
		return PosY;
	}
	public void setPosY(int posY) {
		PosY = posY;
	}
	
	public ArrayList <Field> fieldsToStore() throws SecurityException, NoSuchFieldException{
		ArrayList<Field> array= new ArrayList<Field>();
		array.add(this.getClass().getDeclaredField("PosX"));
		array.add(this.getClass().getDeclaredField("PosY"));
		array.add(this.square.getClass().getSuperclass().getSuperclass().getDeclaredField("terrain"));
		array.add(this.getClass().getDeclaredField("nombreJuego"));
//		Field [] fields=this.square.getClass().getSuperclass().getSuperclass().getDeclaredFields();
//		array.add(fields[1]);

	return array;
	}

	@SuppressWarnings("finally")
	@Override
	public int deleteFromDataBase() {
		PieceJDBC p;
		int valueToReturn=0;
			try {
				
				p = new PieceJDBC();
				valueToReturn+=p.remove("Casilla", this);
				if(this.getPiece()!=null)
					valueToReturn+=this.getPiece().deleteFromDataBase();
				
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null,"Error al borrar "+e.toString(),"Error",JOptionPane.OK_OPTION,null);  
				
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Error al borrar "+e.toString(),"Error",JOptionPane.OK_OPTION,null);  
				
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Error al borrar \n"+e.toString(),"Error",JOptionPane.OK_OPTION,null);  
				
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
	public static void main (String []args){
		Casilla c=new Casilla();
		TerrainCastle t= new TerrainCastle();
		c.setSquare(t);
		c.setPosX(5);
		c.setPosY(18);
		c.setCodeCasilla(13);
		c.deleteFromDataBase();
		c.insertIntoDataBase();
		ArrayList<storableInDataBase> a=c.takeOutFromDataBase();
		for (storableInDataBase s: a)
		{
			System.out.println(((Casilla)s).getCodeCasilla());
		}
		c.setCodeCasilla(70);
		//c.deleteFromDataBase();
	}
}
