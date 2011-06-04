package proyecto.p4.JuegoOldWarriorTales;

import java.sql.SQLException;
import java.util.ArrayList;

import proyecto.p4.Mapa.Casilla;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.piezaOldWarriorTales.Unidades.Arquero;
import ConnectionInterface.PieceJDBC;
import ConnectionInterface.storableInDataBase;

public class DeleteGame extends Thread {

	private JuegoOldWarriorTales jowt;
	public DeleteGame(JuegoOldWarriorTales jowt)
	{
		this.jowt=jowt;
	}
	@Override
	public void run() {
		
		
			PieceJDBC p;
			try {
				p = new PieceJDBC();
				p.remove("JuegoOldWarriorTales", jowt);
				Casilla casilla= new Casilla();
				ArrayList<storableInDataBase>array=casilla.takeOutFromDataBase();
				for(storableInDataBase cas: array)
				{
					if (((Casilla)cas).getNombreJuego().equals(jowt.getName()))
					{
						cas.deleteFromDataBase();
					}
				}
				Arquero arq= new Arquero();;
				array=arq.takeOutFromDataBase();
				for(storableInDataBase cas: array)
				{
					if (((PiezaOldWarriorTales)cas).getNombreJuego().equals(jowt.getName()))
					{
						cas.deleteFromDataBase();
					}
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		

	}

}
