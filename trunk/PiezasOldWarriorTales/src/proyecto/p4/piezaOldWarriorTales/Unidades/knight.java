package proyecto.p4.piezaOldWarriorTales.Unidades;

import javax.swing.ImageIcon;

import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;


public class knight extends PiezaOldWarriorTales {

		public knight(){
			movement=5;
			defense=10;
			attack=35;
			probability=70;
			blindness=false;
			poisson=false;
			counterattack=false;
			CanonicalName= this.getClass().getSimpleName();

			//this.setImagen(new ImageIcon(getClass().getResource("/img/caballero.gif")));
		}

		@Override
		public void restartProbability() {
			probability=70;
			
		}

		@Override
		protected void cargarHabilidades() {
			// TODO Auto-generated method stub
			
		}
}
