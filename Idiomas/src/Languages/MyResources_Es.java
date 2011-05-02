package Languages;

import java.util.Enumeration;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;

public class MyResources_Es extends ListResourceBundle{

	public Object [][] contenido={{"label_accept","Aceptar"},{"label_exit","Salir"},{"label_newGame","Nueva Partida"},
			{"label_options","Opciones"},{"label_quickGame","Partida R�pida"},{"label_customGame","Partida Personalizada"},
			{"label_newPlayer","Nuevo jugador"},{"label_tutorial","Tutorial"},{"label_gold","oro"},{"label_units","Unidades"},
			{"label_credits","Creditos"}
	};
	@Override
	protected Object[][] getContents() {
		
		return contenido;
	}


	
	

}
