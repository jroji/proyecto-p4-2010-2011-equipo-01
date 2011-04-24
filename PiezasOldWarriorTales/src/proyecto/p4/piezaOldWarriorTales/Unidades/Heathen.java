package proyecto.p4.piezaOldWarriorTales.Unidades;

import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;

public class Heathen extends PiezaOldWarriorTales {

		public Heathen(){
			movement=2;
			defense=15;
			attack=50;
			probability=40;
			blindness=false;
			poisson=false;
			counterattack=false;
		}

		@Override
		public void restartProbability() {
			probability=40;
			
		}
}
