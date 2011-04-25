package proyecto.p4.piezaOldWarriorTales.Unidades;

import Proyecto.p4.casilla.Casilla;
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

	public static void main (String []args){
		Arquero prueba=new Arquero();
		System.out.println();
	}


}
