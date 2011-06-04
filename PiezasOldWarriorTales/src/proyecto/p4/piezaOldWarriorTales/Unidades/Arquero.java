package proyecto.p4.piezaOldWarriorTales.Unidades;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import ConnectionInterface.storableInDataBase;

import proyecto.p4.Piece.Colours;
import proyecto.p4.PiezasOldWarriorTales.Orientations;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;
import proyecto.p4.habilidades.Cegar;
import proyecto.p4.habilidades.Envenenar;

public class Arquero extends PiezaOldWarriorTales{
	
	
	public Arquero(){
		attackDistance=5;
		movement=4;
		defense=15;
		attack=30;
		probability=70;
		blindness=false;
		poisson=false;
		counterattack=true;
		type= this.getClass().getSimpleName();

//	this.setImagen(new ImageIcon(getClass().getResource("/img/arquero.gif")));


	this.setImagen(new ImageIcon(getClass().getResource("/img/arquero.png")));

	}

	@Override
	public void restartProbability() {
		probability=70;
	}
	/*
	 * habilidades a cargar: Envenenar / cegar
	 * (non-Javadoc)
	 * @see proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales#cargarHabilidades()
	 */
	@Override
	protected void cargarHabilidades() {
		Envenenar h1;
		h1= new Envenenar(this);
		Cegar h2= new Cegar(this);
		habilities=new Hability[2];
		habilities[0]=h1;
		habilities[1]=h2;
	}
	public static void main (String[]args)  {

		Arquero a=new Arquero();
		a.setPosition(5, 5);
		a.setCodePiece(7);
		a.setColor(Colours.blanco);
		a.setOrientation(Orientations.South);
		a.setLife(60);
		a.setEnergy(50);
		a.setExperience(200);
		a.setBlindness(false);
		a.setPoisson(true);
		a.setHasAttacked(true);
		//a.insertIntoDataBase();
		a.deleteFromDataBase();
		ArrayList<storableInDataBase> array=a.takeOutFromDataBase();
		for(storableInDataBase stor: array){
			((PiezaOldWarriorTales)stor).mostrar();
		}

	}

}
