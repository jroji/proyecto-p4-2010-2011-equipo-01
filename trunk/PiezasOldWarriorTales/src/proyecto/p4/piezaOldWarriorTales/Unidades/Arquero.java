package proyecto.p4.piezaOldWarriorTales.Unidades;

import javax.swing.ImageIcon;

import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;
import proyecto.p4.habilidades.Cegar;
import proyecto.p4.habilidades.Envenenar;

public class Arquero extends PiezaOldWarriorTales{

	public Arquero(){
	movement=4;
	defense=15;
	attack=30;
	probability=70;
	blindness=false;
	poisson=false;
	counterattack=true;

	this.setImagen(new ImageIcon(getClass().getResource("/img/arquero.png")));

	}

	@Override
	public void restartProbability() {
		probability=70;
	}
	/*
	 * habilidades a cargar: Envenenar / cegar
	 * (non-Javadoc)
	 * @see proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales#cargarHabilidades()
	 */
	@Override
	protected void cargarHabilidades() {
		Envenenar h1= new Envenenar(this);
		Cegar h2= new Cegar(this);
		habilities=new Hability[2];
		habilities[0]=h1;
		habilities[1]=h2;
	}
	public static void main (String[]args)  {
		
		
		
	}

}
