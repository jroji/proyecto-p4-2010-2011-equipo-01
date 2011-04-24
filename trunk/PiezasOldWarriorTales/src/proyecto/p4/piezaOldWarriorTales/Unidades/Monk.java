package proyecto.p4.piezaOldWarriorTales.Unidades;

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
		
}
