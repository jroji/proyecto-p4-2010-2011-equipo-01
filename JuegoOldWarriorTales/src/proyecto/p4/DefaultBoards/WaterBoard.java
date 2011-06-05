package proyecto.p4.DefaultBoards;

import proyecto.p4.JuegoOldWarriorTales.JuegoOldWarriorTales;
import proyecto.p4.Mapa.Board;
import proyecto.p4.Mapa.Casilla;
import proyecto.p4.Tipo.OldWarriorTales.TerrainCastle;
import proyecto.p4.Tipo.OldWarriorTales.TerrainWater;


public class WaterBoard extends Board {
	
	public WaterBoard ()
	{
		this.setBoardName("Water Board");
		Casilla [][]map= new Casilla[14][13];
		for (int i=0; i<map.length;i++)
		{
			for(int j=0; j<map[j].length;j++)
			{
				map[i][j]= new Casilla(new TerrainWater(),i,j,null);
			}
		}
		map[0][6]=new Casilla(new TerrainCastle(),0,7,null);
		map[13][6]=new Casilla(new TerrainCastle(),0,7,null);
		this.setMap(map);
	}
	public static void main (String []args)
	{
		JuegoOldWarriorTales jug = new JuegoOldWarriorTales();
		jug.setTablero(new WaterBoard());
//		GameWindow gam=new GameWindow(jug);
		
	}
}
