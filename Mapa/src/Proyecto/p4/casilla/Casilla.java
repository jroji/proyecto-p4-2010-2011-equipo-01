package Proyecto.p4.casilla;



import javax.swing.JOptionPane;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;


import ConnectionInterface.PieceJDBC;
import ConnectionInterface.storableInDataBase;
import Proyecto.p4.Tipo.Square;
//import proyecto.p4.Tipo.OldWarriorTales.TerrainCastle;
//import proyecto.p4.Tipo.OldWarriorTales.TerrainGrass;
//import proyecto.p4.Tipo.OldWarriorTales.TerrainStones;
//import proyecto.p4.Tipo.OldWarriorTales.TerrainVillage;
//import proyecto.p4.Tipo.OldWarriorTales.TerrainWater;

import proyecto.p4.Tipo.OldWarriorTales.TerrainGrass;
import proyecto.p4.pieza.Piece;

public class Casilla implements storableInDataBase{
	private int CodeCasilla;
	public Square square;
	private int PosX;
	private int PosY;
	private Piece piece;
	
	public  Casilla (){
		square=null;
		PosX=0;
		PosY=0;
		piece=null;
	}
//	public void CasillaGrass(){
//		square = new TerrainGrass();
//	}
//	
//	public void CasillaStone(){
//		square = new TerrainStones();
//	}
//	
//	public void CasillaCastle(){
//		square = new TerrainCastle();
//	}
//	
//	public void CasillaVillage(){
//		square = new TerrainVillage();
//	}
//	
//	public void CasillaWater(){
//		square = new TerrainWater();
//	}
	
	
	
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
		
		//array.add(this.getClass().getDeclaredField("CodeCasilla"));
		array.add(this.getClass().getDeclaredField("PosX"));
		array.add(this.getClass().getDeclaredField("PosY"));
		Field [] fields=this.square.getClass().getSuperclass().getSuperclass().getDeclaredFields();
		array.add(fields[1]);

	return array;
	}
	
	public static void main (String []args) throws Exception{
		Casilla c= new Casilla();
		TerrainGrass t= new TerrainGrass();
		c.setSquare(t);
		PieceJDBC p = new PieceJDBC();
		p.nombreTablas();
		//p.insert("Casilla", c);
		ArrayList<storableInDataBase> array=c.takeOutFromDataBase();
		//ArrayList<storableInDataBase> array=p.getAll("Casilla", c.getClass().getCanonicalName());
//		for (storableInDataBase sdb: array){
//			System.out.println(((Casilla)sdb).getPosX());
//		}
		c.setCodeCasilla(66);
		//System.out.println(p.remove(c));
		System.out.println(c.deleteFromDataBase());
		}

	@SuppressWarnings("finally")
	@Override
	public int deleteFromDataBase() {
		PieceJDBC p;
		int valueToReturn=0;
			try {
				
				p = new PieceJDBC();
				valueToReturn+=p.remove(this);
				//valueToReturn+=p.remove((storableInDataBase) this.getPiece());
				
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null,"Error al sobreescribir","Error",JOptionPane.OK_OPTION,null);  
				
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Error al sobreescribir","Error",JOptionPane.OK_OPTION,null);  
				
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Error al sobreescribir","Error",JOptionPane.OK_OPTION,null);  
				
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
}
