package Proyecto.p4.casilla;
import Proyecto.p4.Tipo.Square;
import proyecto.p4.Tipo.OldWarriorTales.TerrainCastle;
import proyecto.p4.Tipo.OldWarriorTales.TerrainGrass;
import proyecto.p4.Tipo.OldWarriorTales.TerrainStones;
import proyecto.p4.Tipo.OldWarriorTales.TerrainVillage;
import proyecto.p4.Tipo.OldWarriorTales.TerrainWater;
import proyecto.p4.pieza.Piece;

public class Casilla {
	
	private Square	square;
	private int PosX;
	private int PosY;
	private Piece piece;
	
	
	public void CasillaGrass(){
		square = new TerrainGrass();
	}
	
	public void CasillaStone(){
		square = new TerrainStones();
	}
	
	public void CasillaCastle(){
		square = new TerrainCastle();
	}
	
	public void CasillaVillage(){
		square = new TerrainVillage();
	}
	
	public void CasillaWater(){
		square = new TerrainWater();
	}
	
	
	
	public Piece getPiece() {
		return piece;
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
	
}
