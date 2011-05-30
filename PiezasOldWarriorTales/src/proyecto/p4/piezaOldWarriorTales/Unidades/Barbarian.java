package proyecto.p4.piezaOldWarriorTales.Unidades;

import javax.swing.ImageIcon;

import proyecto.p4.Mapa.Casilla;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;
import proyecto.p4.habilidades.AtaqueCertero;
import proyecto.p4.habilidades.Sprint;

public class Barbarian extends PiezaOldWarriorTales {

	public Barbarian(){
		movement=2;
		defense=15;
		attack=50;
		probability=40;
		blindness=false;
		poisson=false;
		counterattack=false;
		//this.setImagen(new ImageIcon(getClass().getResource("/img/barbaro.gif")));
	}
		
	@Override
	public void restartProbability() {
		probability=40;

	}
	
 	public void updateProbability(Casilla casilla){
 		if (casilla.getSquare().getClass().getName()=="TerrainGrass"){
			probability+=10;
		}else if (casilla.getSquare().getClass().getName()=="TerrainWater"){
			probability=100;
		}	
 	}
 	
 	/*
 	 * Habilidades a cargar: ataque certero / Sprint 
 	 * (non-Javadoc)
 	 * @see proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales#cargarHabilidades()
 	 */
	@Override
	protected void cargarHabilidades() {
		AtaqueCertero h1= new AtaqueCertero(this);
		Sprint h2= new Sprint(this);
		habilities=new Hability[2];
		habilities[0]=h1;
		habilities[1]=h2;
	}
}
