package proyecto.p4.habilidades;

import proyecto.p4.PiezasOldWarriorTales.Orientations;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;



/**
 * Habilidad Ataque en zona:
 * Resta diez al atributo de ataque y ataca a las tres posiciones de delante
 *
 */
public class AtaqueEnZona extends Hability {
	
	public AtaqueEnZona (){
		name="Ataque en zona";
		cost=20;
	}
	public AtaqueEnZona (PiezaOldWarriorTales pieza){
		name="Ataque en zona";
		cost=20;
		this.pieza=pieza;
	}
	
	/*
	 * (non-Javadoc)
	 * @see proyecto.p4.habilidades.Hability#execute(int[][])
	 */
	@Override
	public void execute(int[][] coordenadas) throws Exception {
		super.execute(coordenadas);
			//modificar atributos
			pieza.setAttack(pieza.getAttack()-10);
			//atacar a las tres posiciones:
			//si mira hacia el este
			if(pieza.getOrientacion()==Orientations.East){
				pieza.attack(pieza.getPosition_x()+1, pieza.getPosition_y()+1);
				pieza.attack(pieza.getPosition_x()+1, pieza.getPosition_y());
				pieza.attack(pieza.getPosition_x()+1, pieza.getPosition_y()-1);
				}
			//si mira hacia el norte
			else if(pieza.getOrientacion()==Orientations.North){
				pieza.attack(pieza.getPosition_x()-1, pieza.getPosition_y()+1);
				pieza.attack(pieza.getPosition_x(), pieza.getPosition_y()+1);
				pieza.attack(pieza.getPosition_x()+1, pieza.getPosition_y()+1);
				}
			//si mira hacia el sur
			else if(pieza.getOrientacion()==Orientations.South){
				pieza.attack(pieza.getPosition_x()-1, pieza.getPosition_y()-1);
				pieza.attack(pieza.getPosition_x(), pieza.getPosition_y()-1);
				pieza.attack(pieza.getPosition_x()+1, pieza.getPosition_y()-1);
				}
			//si mira hacia el oeste
			else{
				pieza.attack(pieza.getPosition_x()-1, pieza.getPosition_y()+1);
				pieza.attack(pieza.getPosition_x()-1, pieza.getPosition_y());
				pieza.attack(pieza.getPosition_x()-1, pieza.getPosition_y()-1);
				}
			//restauar atributos
			pieza.setAttack(pieza.getAttack()+10);
	}

}
