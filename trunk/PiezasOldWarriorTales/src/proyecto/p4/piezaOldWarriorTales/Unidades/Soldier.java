package proyecto.p4.piezaOldWarriorTales.Unidades;

import javax.swing.ImageIcon;

import proyecto.p4.Mapa.Casilla;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;
import proyecto.p4.habilidades.*;


public class Soldier extends PiezaOldWarriorTales {
	
	public Soldier(){
		movement=3;
		defense=10;
		attack=40;
		probability=60;
		price = 500;
		blindness=false;
		poisson=false;
		counterattack=false;
		type= this.getClass().getSimpleName();
		this.setImagen(new ImageIcon(getClass().getResource("/img/soldado.png")));
	}

	@Override
	public void restartProbability() {
		probability=60;
	}
	
	/*
 	 * Habilidades a cargar: ataque certero / Ataque en zona 
 	 * (non-Javadoc)
 	 * @see proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales#cargarHabilidades()
 	 */
	@Override
	protected void cargarHabilidades() {
		AtaqueCertero h1= new AtaqueCertero(this);
		AtaqueEnZona h2= new AtaqueEnZona(this);
		habilities=new Hability[2];
		habilities[0]=h1;
		habilities[1]=h2;
	}
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
			probability+=20;
		}
 	}
}
