package proyecto.p4.DefaultBoards;

import proyecto.p4.Mapa.Board;
import proyecto.p4.Mapa.Casilla;
import proyecto.p4.Tipo.OldWarriorTales.TerrainGrass;

public class DefaultBoard extends Board {
	
	public DefaultBoard()
	{
		this.setBoardName("Default Board");
		Casilla [][]map= new Casilla[14][13];
		for (int i=0; i<map.length;i++)
		{
			for(int j=0; i<map[i].length;i++)
			{
				map[i][j]= new Casilla(new TerrainGrass(),i,j,null);
			}
		}
		this.setMap(map);
	}
}
