package proyecto.p4.piezaOldWarriorTales.Unidades;


import javax.swing.ImageIcon;
import proyecto.p4.Mapa.Casilla;




public class King extends proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales {
	
	public King()
	{
		movement=2;
		defense=10;
		attack=20;
		probability=100;
		blindness=false;
		poisson=false;
		counterattack=false;
		type= this.getClass().getSimpleName();
		this.setImagen(new ImageIcon(getClass().getResource("/img/king.png")));
	}
	@Override
	protected void cargarHabilidades() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restartProbability() {
		probability=100;
		
	}
	@SuppressWarnings("unused")
	private void updateProbability(){
 		Casilla casilla= board.getCasilla(getPosition_x(), getPosition_y());
 		if (casilla.getSquare().getClass().getName()=="Castle"){
			probability=100;
		}else if (casilla.getSquare().getClass().getName()=="TerrainWater"){
			probability-=10;
		}else if(casilla.getSquare().getClass().getName()=="Stones"){
			probability-=20;
		}else if (casilla.getSquare().getClass().getName()=="Village")
		{
			probability-=10;
		}
 	}

}
