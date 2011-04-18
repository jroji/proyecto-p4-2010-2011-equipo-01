package Proyecto.p4.mapa;

import Proyecto.p4.casilla.Casilla;

public class Board {
	
	private Casilla[][] Map;
	
	public Casilla[][] getBoard(){
		return Map;
	}
	public void setBoard(Board c){
		Map = c.getBoard();
	}
}
