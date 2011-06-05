package proyecto.p4.Mapa;
import proyecto.p4.Piece.Piece;
import proyecto.p4.Tipo.OldWarriorTales.TerrainCastle;
import proyecto.p4.Tipo.OldWarriorTales.TerrainGrass;

public class Board 
{
	
	private Casilla[][] map;
	private String BoardName;
	public Board (){
		map= new Casilla[14][13];
		for(int i = 0;i<map.length;i++)
			for(int j = 0; j<map[i].length;j++){	
				map[i][j] = new Casilla(new TerrainGrass(),i,j,null);
				map[i][j].setPosX(i);
				map[i][j].setPosY(j);
				}
		map[0][6]=new Casilla(new TerrainCastle(),0,6,null);
		map[13][6]=new Casilla(new TerrainCastle(),13,6,null);
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

	public Casilla[][] getMap() {
		return map;
	}

	public void setMap(Casilla[][] map) {
		this.map = map;
	}

	public String getBoardName() {
		return BoardName;
	}

	public void setBoardName(String boardName) {
		BoardName = boardName;
	}
	
	
}
