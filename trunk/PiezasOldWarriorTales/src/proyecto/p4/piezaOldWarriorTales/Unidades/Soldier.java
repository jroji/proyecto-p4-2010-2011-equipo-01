package proyecto.p4.piezaOldWarriorTales.Unidades;

import proyecto.p4.habilidades.AtaqueCertero;
import proyecto.p4.habilidades.AtaqueEnZona;
import proyecto.p4.habilidades.Hability;
import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;

public class Soldier extends PiezaOldWarriorTales {
	
	public Soldier(){
		movement=3;
		defense=10;
		attack=40;
		probability=60;
		blindness=false;
		poisson=false;
		counterattack=false;
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
}
