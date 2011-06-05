package proyecto.p4.piezaOldWarriorTales.Unidades;

import javax.swing.ImageIcon;

import proyecto.p4.Mapa.Casilla;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;
import proyecto.p4.habilidades.*;


public class Monk extends PiezaOldWarriorTales{

		public Monk(){
			movement=3;
			defense=0;
			attack=50;
			probability=100;
			blindness=false;
			poisson=false;
			counterattack=false;
			type= this.getClass().getSimpleName();

			this.setImagen(new ImageIcon(getClass().getResource("/img/monje.png")));
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
		private void updateProbability(){
	 		Casilla casilla= board.getCasilla(getPosition_x(), getPosition_y());
	 		if (casilla.getSquare().getClass().getName()=="Castle"){
				probability=100;
			}else if (casilla.getSquare().getClass().getName()=="TerrainWater"){
				probability-=10;
			}else if(casilla.getSquare().getClass().getName()=="Stones"){
				probability-=20;
			}else if (casilla.getSquare().getClass().getName()=="Village")
			{
				probability-=10;
			}
	 	}
		
}
