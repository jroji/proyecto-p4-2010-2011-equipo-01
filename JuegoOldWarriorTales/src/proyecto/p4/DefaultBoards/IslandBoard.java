package proyecto.p4.DefaultBoards;

import proyecto.p4.Mapa.Board;
import proyecto.p4.Mapa.Casilla;
import proyecto.p4.Tipo.OldWarriorTales.TerrainCastle;
import proyecto.p4.Tipo.OldWarriorTales.TerrainGrass;
import proyecto.p4.Tipo.OldWarriorTales.TerrainWater;


public class IslandBoard extends Board {
	public IslandBoard ()
	{
		this.setBoardName("Island Board");
		Casilla [][]map= new Casilla[14][13];
		for (int i=0; i<map.length;i++)
		{
			for(int j=0; j<map[j].length;j++)
			{
				if((i<4&&j>2&&j<10)||(i>9&&j>2&&j<10))
					map[i][j]= new Casilla(new TerrainGrass(),i,j,null);
				else
					map[i][j]= new Casilla(new TerrainWater(),i,j,null);
			}
		}
		map[0][6]=new Casilla(new TerrainCastle(),0,7,null);
		map[13][6]=new Casilla(new TerrainCastle(),0,7,null);
		this.setMap(map);
	}

}
