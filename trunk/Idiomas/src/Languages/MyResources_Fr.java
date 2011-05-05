package Languages;

import java.util.ListResourceBundle;

public class MyResources_Fr extends ListResourceBundle{

	
	public String [][] contenido={{"label_accept","Accepter"},{"label_exit","Sortir"},{"label_newGame","Nouveau Jeu"},
			{"label_options","Options"},{"label_quickGame","Rapide Jeu"},{"label_customGame","Custom Jeu"},
			{"label_newPlayer","Nouveau Joeur"},{"label_tutorial","Tutoriel"},{"label_gold","Or"},{"label_units","Unit�s"},
			{"label_credits","Crédits"},{"label_mapEditor","Éditeur de cartes"},{"label_reclute","Recruter"},{"label_langauge","Langue"},
			{"label_sound","Son"},{"label_attack","Attaque"},{"label_defense","Défense"},{"label_movement","Mouvement"},
			{"label_probability","Probabilité"},{"label_back","Retour"},{"AtacarYHuir","Attaque et de s'enfuir"},{"AtaqueCertero","Attaque précise"},
			{"AtaqueEnZona","Zone d'attaque"},{"Cegar","Blind"},{"Convertir","Transformer"},{"CurarEstados","Etats Cure"},{"CurarZona","Zone Cure"},
			{"Envenenar","Poison "},{"LanzarSuriquen","Paru le shuriken"},{"Sprint","Sprint"}
	
	};
	
	@Override
	protected Object[][] getContents() {
		
		return contenido;
	}
	public String toString (){
		return "Frances";
	}

}
