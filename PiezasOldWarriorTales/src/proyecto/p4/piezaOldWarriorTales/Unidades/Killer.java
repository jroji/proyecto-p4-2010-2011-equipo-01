package proyecto.p4.piezaOldWarriorTales.Unidades;

import javax.swing.ImageIcon;

import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;
import proyecto.p4.habilidades.*;



public class Killer extends PiezaOldWarriorTales{

		public Killer(){
			movement=4;
			defense=5;
			attack=25;
			probability=60;
			blindness=false;
			poisson=false;
			counterattack=false;
			CanonicalName= this.getClass().getSimpleName();
			//this.setImagen(new ImageIcon(getClass().getResource("/img/asesino.gif")));
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
		
		/*
	 	 * Habilidades a cargar: Envenenar / Atacar y huir / Lanzar Suriquen
	 	 * (non-Javadoc)
	 	 * @see proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales#cargarHabilidades()
	 	 */
		@Override
		protected void cargarHabilidades() {
			Envenenar h1= new Envenenar(this);
			AtacarYHuir h2= new AtacarYHuir(this);
			LanzarSuriquen h3= new LanzarSuriquen(this);
			habilities=new Hability[3];
			habilities[0]=h1;
			habilities[1]=h2;
			habilities[2]=h3;
		}
}
