package proyecto.p4.casilla;
import javax.swing.ImageIcon;

import proyecto.p4.Tipo.Square;
import proyecto.p4.Tipo.OldWarriorTales.Terrain;
import proyecto.p4.pieza.Piece;

public class Casilla {
	
	private Square	square;
	private int PosX;
	private int PosY;
	private Piece piece;
	
	
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
}
