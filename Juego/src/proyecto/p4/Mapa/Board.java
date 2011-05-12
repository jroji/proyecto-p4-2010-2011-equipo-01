package proyecto.p4.Mapa;

import java.lang.reflect.Field;
import java.util.ArrayList;

import proyecto.p4.Piece.Piece;
import ConnectionInterface.storableInDataBase;

public class Board implements storableInDataBase
{
	
	private Casilla[][] map;
	
	public Board (){
		map= new Casilla[13][13];
		for(int i = 0;i<map.length;i++)
			for(int j = 0; j<map[i].length;j++){		
				map[i][j] = new Casilla(new TerrainGrass(),i , j, null);
				}
		}
	
	public Casilla[][] getBoard(){
		return map;
	}
	public void setBoard(Board c){
		map = c.getBoard();
	}
	public Piece getPiece (int x, int y){
		return map[x][y].getPiece();
	}
	public Casilla getCasilla(int x, int y){
		return map[x][y];
	}

	@Override
	public int deleteFromDataBase() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Field> fieldsToStore() throws SecurityException,
			NoSuchFieldException {
		// TODO Auto-generated method stub
		return null;
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
