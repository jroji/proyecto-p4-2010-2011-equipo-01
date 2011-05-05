package Languages;

import java.util.Enumeration;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;

public class MyResources_Es extends ListResourceBundle{

	public String [][] contenido={{"label_accept","Aceptar"},{"label_exit","Salir"},{"label_newGame","Nueva Partida"},
			{"label_options","Opciones"},{"label_quickGame","Partida Rï¿½pida"},{"label_customGame","Partida Personalizada"},
			{"label_newPlayer","Nuevo jugador"},{"label_tutorial","Tutorial"},{"label_gold","Oro"},{"label_units","Unidades"},
			{"label_credits","Creditos"},{"label_mapEditor","Editor de mapas"},{"label_reclute","Reclutar"},{"label_language","Idioma"},
			{"label_sound","Sonido"},{"label_attack","Attack"},{"label_defense","Defense"},{"label_movement","Movement"},
			{"label_probability","Probability"}
	
	};
	@Override
	protected Object[][] getContents() {
		
		return contenido;
	}
	public String toString (){
		return "Español";
	}


	
	

}
