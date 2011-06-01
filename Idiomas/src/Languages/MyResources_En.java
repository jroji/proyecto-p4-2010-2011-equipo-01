package Languages;

import java.util.ListResourceBundle;

public class MyResources_En extends ListResourceBundle{
	
	public String [][] contenido={{"label_accept","Accept"},{"label_exit","Exit"},{"label_newGame","New Game"},
			{"label_options","Options"},{"label_quickGame","Quick Game"},{"label_customGame","Custom Game"},
			{"label_newPlayer","New Player"},{"label_tutorial","Tutorial"},{"label_gold","Gold"},{"label_units","Units"},
			{"label_credits","Credits"},{"label_mapEditor","Map Editor"},{"label_reclute","Reclute"},{"label_language","Language"},
			{"label_sound","Sound"},{"label_attack","Ataque"},{"label_defense","Defensa"},{"label_movement","Movimiento"},
			{"label_probability","Probabilidad"},{"label_back","Back"},{"AtacarYHuir","Attack and escape"},{"AtaqueCertero","Accurate attack"},
			{"AtaqueEnZona","Attack zone"},{"Cegar","Blind"},{"Convertir","Convert"},{"CurarEstados","Heal states"},{"CurarZona","Heal Zone"},
			{"Envenenar","Poison"},{"LanzarSuriquen","Throw Suriken"},{"Sprint","Sprint"},{"Yes","Yes"},{"No","No"},
			{"loadGame","Load Game"}
		
	};
	
	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contenido;
	}
	public String toString (){
		return "English";
	}

}
