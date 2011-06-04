package proyecto.p4.piezaOldWarriorTales.Unidades;

import javax.swing.ImageIcon;

import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;
import proyecto.p4.habilidades.AtaqueCertero;
import proyecto.p4.habilidades.Cegar;
import proyecto.p4.habilidades.Envenenar;
import proyecto.p4.habilidades.Sprint;


public class knight extends PiezaOldWarriorTales {

		public knight(){
			movement=5;
			defense=10;
			attack=35;
			probability=70;
			blindness=false;
			poisson=false;
			counterattack=false;
			type= this.getClass().getSimpleName();

			//this.setImagen(new ImageIcon(getClass().getResource("/img/caballero.gif")));
		}

		@Override
		public void restartProbability() {
			probability=70;
			
		}

		@Override
		protected void cargarHabilidades() {
			AtaqueCertero a1;
			a1= new AtaqueCertero();
			Sprint h2= new Sprint();
			habilities=new Hability[2];
			habilities[0]=a1;
			habilities[1]=h2;
		}
}
