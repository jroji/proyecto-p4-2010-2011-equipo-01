package proyecto.p4.piezaOldWarriorTales.Unidades;

import proyecto.p4.habilidades.Convertir;
import proyecto.p4.habilidades.CurarEstados;
import proyecto.p4.habilidades.CurarZona;
import proyecto.p4.habilidades.Hability;
import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;
public class Monk extends PiezaOldWarriorTales{

		public Monk(){
			movement=3;
			defense=0;
			attack=50;
			probability=100;
			blindness=false;
			poisson=false;
			counterattack=false;
		}
		
		public int takinglife(PiezaOldWarriorTales piezaContraria){
			return this.getAttack();
		}

		@Override
		public void restartProbability() {
			probability=100;

		}
		
		/*
	 	 * Habilidades a cargar: Convertir / Curar zona / Curar Estado
	 	 * (non-Javadoc)
	 	 * @see proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales#cargarHabilidades()
	 	 */
		@Override
		protected void cargarHabilidades() {
			Convertir h1= new Convertir(this);
			CurarZona h2= new CurarZona(this);
			CurarEstados h3= new CurarEstados(this);
			habilities=new Hability[3];
			habilities[0]=h1;
			habilities[1]=h2;
			habilities[2]=h3;
		}
		
}
