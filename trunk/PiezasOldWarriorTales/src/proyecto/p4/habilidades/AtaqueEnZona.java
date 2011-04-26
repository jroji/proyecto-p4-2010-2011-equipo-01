package proyecto.p4.habilidades;

import proyecto.p4.piezaOldWarriorTales.Orientations;
import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;

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
			
			//obtener piezas a atacar
			PiezaOldWarriorTales pieza1;
			PiezaOldWarriorTales pieza2;
			PiezaOldWarriorTales pieza3;
			//si mira hacia el este
			if(pieza.getOrientacion()==Orientations.East){
				pieza1=(PiezaOldWarriorTales) pieza.getBoard().getPiece(pieza.getPosition_x()+1, pieza.getPosition_y()+1);
				pieza2=(PiezaOldWarriorTales) pieza.getBoard().getPiece(pieza.getPosition_x()+1, pieza.getPosition_y());
				pieza3=(PiezaOldWarriorTales) pieza.getBoard().getPiece(pieza.getPosition_x()+1, pieza.getPosition_y()-1);
			}
			//si mira hacia el norte
			else if(pieza.getOrientacion()==Orientations.North){
				pieza1=(PiezaOldWarriorTales) pieza.getBoard().getPiece(pieza.getPosition_x()-1, pieza.getPosition_y()+1);
				pieza2=(PiezaOldWarriorTales) pieza.getBoard().getPiece(pieza.getPosition_x(), pieza.getPosition_y()+1);
				pieza3=(PiezaOldWarriorTales) pieza.getBoard().getPiece(pieza.getPosition_x()+1, pieza.getPosition_y()+1);
			}
			//si mira hacia el sur
			else if(pieza.getOrientacion()==Orientations.South){
				pieza1=(PiezaOldWarriorTales) pieza.getBoard().getPiece(pieza.getPosition_x()-1, pieza.getPosition_y()-1);
				pieza2=(PiezaOldWarriorTales) pieza.getBoard().getPiece(pieza.getPosition_x(), pieza.getPosition_y()-1);
				pieza3=(PiezaOldWarriorTales) pieza.getBoard().getPiece(pieza.getPosition_x()+1, pieza.getPosition_y()-1);
			}
			//si mira hacia el oeste
			else{
				pieza1=(PiezaOldWarriorTales) pieza.getBoard().getPiece(pieza.getPosition_x()-1, pieza.getPosition_y()+1);
				pieza2=(PiezaOldWarriorTales) pieza.getBoard().getPiece(pieza.getPosition_x()-1, pieza.getPosition_y());
				pieza3=(PiezaOldWarriorTales) pieza.getBoard().getPiece(pieza.getPosition_x()-1, pieza.getPosition_y()-1);
			}
			//comprobar que no sean null y atacar
			if (pieza1!=null)
				pieza.attack(pieza1);
			if (pieza2!=null)
				pieza.attack(pieza2);
			if (pieza3!=null)
				pieza.attack(pieza3);
			
			//restauar atributos
			pieza.setAttack(pieza.getAttack()+10);
	}

}
