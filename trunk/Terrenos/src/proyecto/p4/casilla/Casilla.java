package proyecto.p4.casilla;
import javax.swing.ImageIcon;

import proyecto.p4.pieza.Piece;

public class Casilla {
	
	private String Name;
	private int PosX;
	private int PosY;
	private ImageIcon Image;
	private Piece piece;
	
	
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
}