package proyecto.p4.piezaOldWarriorTales.Unidades;


import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;
import proyecto.p4.habilidades.Cegar;
import proyecto.p4.habilidades.Envenenar;

public class Magician extends PiezaOldWarriorTales {

		public Magician(){
			movement=2;
			defense=5;
			attack=50;
			probability=45;
			blindness=false;
			poisson=false;
			counterattack=false;
		}

		@Override
		public void restartProbability() {
			probability=45;
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
}
