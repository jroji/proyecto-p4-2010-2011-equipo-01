package proyecto.p4.piezaOldWarriorTales.Unidades;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import ConnectionInterface.storableInDataBase;

import proyecto.p4.Mapa.Casilla;
import proyecto.p4.Piece.Colours;
import proyecto.p4.PiezasOldWarriorTales.Orientations;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;
import proyecto.p4.habilidades.AtaqueCertero;
import proyecto.p4.habilidades.Sprint;

public class Barbarian extends PiezaOldWarriorTales {

	public Barbarian(){
		movement=2;
		defense=15;
		attack=50;
		probability=40;
		price = 600;
		blindness=false;
		poisson=false;
		counterattack=false;
		type= this.getClass().getSimpleName();
		this.setImagen(new ImageIcon(getClass().getResource("/img/barbarian.png")));
	}
		
	@Override
	public void restartProbability() {
		probability=40;

	}
	
 	public void updateProbability(Casilla casilla){
 		if (casilla.getSquare().getClass().getName()=="TerrainGrass"){
			probability+=10;
		}else if (casilla.getSquare().getClass().getName()=="TerrainWater"){
			probability=100;
		}	
 	}
 	
 	/*
 	 * Habilidades a cargar: ataque certero / Sprint 
 	 * (non-Javadoc)
 	 * @see proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales#cargarHabilidades()
 	 */
	@Override
	protected void cargarHabilidades() {
		AtaqueCertero h1= new AtaqueCertero(this);
		Sprint h2= new Sprint(this);
		habilities=new Hability[2];
		habilities[0]=h1;
		habilities[1]=h2;
	}
	
	@SuppressWarnings("unused")
	private void updateProbability(){
 		Casilla casilla= board.getCasilla(getPosition_x(), getPosition_y());
 		if (casilla.getSquare().getClass().getName()=="Castle"){
			probability=100;
		}else if (casilla.getSquare().getClass().getName()=="TerrainWater"){
			probability-=10;
		}else if(casilla.getSquare().getClass().getName()=="Stones"){
			probability+=30;
		}
 	}
	
	public static void main (String[]args)  {

		Barbarian a = new Barbarian();
		a.setPosition(5, 5);
		a.setCodePiece(34);
		a.setColor(Colours.azul);
		a.setOrientation(Orientations.South);
		a.setLife(60);
		a.setEnergy(50);
		a.setExperience(200);
		a.setBlindness(false);
		a.setPoisson(true);
//		a.insertIntoDataBase();
//		a.deleteFromDataBase();
		ArrayList<storableInDataBase> array=a.takeOutFromDataBase();
		for(storableInDataBase stor: array){
			((PiezaOldWarriorTales)stor).mostrar();
		}

	}
}
