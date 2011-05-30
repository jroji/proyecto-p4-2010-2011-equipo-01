package Languages;

import java.util.ListResourceBundle;

public class MyResources_Es extends ListResourceBundle{

	static final Object [][] contents={{"label_accept","Aceptar"},{"label_exit","Salir"},{"label_newGame","Nueva Partida"},
			{"label_options","Opciones"},{"label_quickGame","Partida Rï¿½pida"},{"label_customGame","Partida Personalizada"},
			{"label_newPlayer","Nuevo jugador"},{"label_tutorial","Tutorial"},{"label_gold","Oro"},{"label_units","Unidades"},
			{"label_credits","Creditos"},{"label_mapEditor","Editor de mapas"},{"label_reclute","Reclutar"},{"label_language","Idioma"},
			{"label_sound","Sonido"},{"label_attack","Attack"},{"label_defense","Defense"},{"label_movement","Movement"},
			{"label_probability","Probability"},{"label_back","Volver"},{"AtacarYHuir","Atacar y huir"},{"AtaqueCertero","Ataque certero"},
			{"AtaqueEnZona","Ataque en zona"},{"Cegar","Cegar"},{"Convertir","Convertir"},{"CurarEstados","Curar estados"},{"CurarZona","Curar zona"},
			{"Envenenar","Envenenar"},{"LanzarSuriquen","Lanzar suriken"},{"Sprint","Sprint"}
	
	};
	@Override
	public Object[][] getContents() {
		
		return contents;
	}
	public String toString (){
		return "Español";
	}


	
	

}
