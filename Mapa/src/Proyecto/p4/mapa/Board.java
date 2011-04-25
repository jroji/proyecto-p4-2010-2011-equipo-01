package Proyecto.p4.mapa;

import proyecto.p4.pieza.Piece;
import Proyecto.p4.casilla.Casilla;

public class Board {
	
	private Casilla[][] map;
	
	public Board (){
		map= new Casilla[13][13];
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
}
