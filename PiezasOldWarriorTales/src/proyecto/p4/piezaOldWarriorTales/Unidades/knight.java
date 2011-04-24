package proyecto.p4.piezaOldWarriorTales.Unidades;

import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;

public class knight extends PiezaOldWarriorTales {

		public knight(){
			movement=5;
			defense=10;
			attack=35;
			probability=70;
			blindness=false;
			poisson=false;
			counterattack=false;
		}

		@Override
		public void restartProbability() {
			probability=70;
			
		}
}
