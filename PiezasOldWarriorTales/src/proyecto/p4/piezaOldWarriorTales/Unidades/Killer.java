package proyecto.p4.piezaOldWarriorTales.Unidades;

import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;

public class Killer extends PiezaOldWarriorTales{

		public Killer(){
			movement=4;
			defense=5;
			attack=25;
			probability=60;
			blindness=false;
			poisson=false;
			counterattack=false;
		}
		
		public double takinglife (PiezaOldWarriorTales piezaContraria){
			
			if(this.getOrientacion().equals(piezaContraria.getOrientacion()))
				
				return this.getAttack()+45-piezaContraria.getDefense();
			else
				return this.getAttack()-piezaContraria.getDefense();
				
		}

		@Override
		public void restartProbability() {
			probability=60;
			
		}
}
