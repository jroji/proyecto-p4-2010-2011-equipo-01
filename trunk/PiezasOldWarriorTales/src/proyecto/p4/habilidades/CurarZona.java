package proyecto.p4.habilidades;

import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;

public class CurarZona extends AtaqueEnZona {

	public CurarZona() {
		name= "Curar zona";
		cost=20;
	}
	public CurarZona(PiezaOldWarriorTales pieza) {
		name= "Curar zona";
		cost=20;
		this.pieza=pieza;
	}

}
