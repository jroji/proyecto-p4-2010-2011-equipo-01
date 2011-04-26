package proyecto.p4.habilidades;

import proyecto.p4.pieza.Piece.Colours;
import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;

/**
 * Habilidad Convertir:
 * Cambia el bando de una pieza
 *
 */
public class Convertir extends Hability {
	private int distancia_maxima;

	public Convertir() {
		name="Convertir";
		cost=20;
		distancia_maxima=5;
	}
	public Convertir(PiezaOldWarriorTales pieza) {
		name="Convertir";
		cost=20;
		distancia_maxima=5;
		this.pieza=pieza;
	}
	/*
	 * (non-Javadoc)
	 * @see proyecto.p4.habilidades.Hability#execute(int[][])
	 * las coordenadas (0,0)(0,1) indican la posicion de la pieza a convertir;
	 */
	public void execute (int [][]coordenadas)throws Exception{
		super.execute(coordenadas);
		//validar formato del array
		if (coordenadas[0].length==2&&coordenadas.length>0){
			//validar que la pieza a atacar este a tiro
			if (IsWithinRange(coordenadas[0][0], coordenadas[0][1])){
				PiezaOldWarriorTales pieza_a_convertir=(PiezaOldWarriorTales) pieza.getBoard().
				getPiece(coordenadas[0][0], coordenadas[0][1]);
				if (pieza_a_convertir.getColor()==Colours.blanco)
					pieza_a_convertir.setColor(Colours.negro);
				else
					pieza_a_convertir.setColor(Colours.blanco);
			}else 
				throw new Exception ("la pieza no esta al alcance");
			
		}else 
			throw new IllegalArgumentException ("El array deve de tener el siguiente formato: coordenadas [n][2] donde n>0");

		
		
	}

	/**
	 * Indica si la pieza en las coordenadas indicadas esta a tiro
	 * @param x coordenada x de la pieza a atacar
	 * @param y coordenada y de la pieza a atacar
	 * @return si la pieza esta lo suficientemente cerca como para ser atacada
	 */
	private boolean IsWithinRange(int x, int y){
		int res=pieza.getPosition_x()-x;
		res=Math.abs(res);
		if (res>distancia_maxima){
			return false;
		}else{
			int res2=pieza.getPosition_y()-y;
			res2=Math.abs(res2);
			res+=res2;
			if (res>distancia_maxima){
				return false;
			}else return true;
		}
	}
}
