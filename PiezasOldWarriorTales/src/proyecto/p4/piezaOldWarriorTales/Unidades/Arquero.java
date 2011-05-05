package proyecto.p4.piezaOldWarriorTales.Unidades;

import proyecto.p4.habilidades.Cegar;
import proyecto.p4.habilidades.Envenenar;
import proyecto.p4.habilidades.Hability;
import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;

public class Arquero extends PiezaOldWarriorTales{

	public Arquero(){
	movement=4;
	defense=15;
	attack=30;
	probability=70;
	blindness=false;
	poisson=false;
	counterattack=true;


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
		Arquero arquero=new Arquero();
		Class<?> clase;
		try {
			clase = Class.forName(arquero.getClass().getCanonicalName());
			Object ob=clase.newInstance();
			System.out.println(ob.getClass().getCanonicalName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
