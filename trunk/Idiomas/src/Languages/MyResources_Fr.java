package Languages;

import java.util.ListResourceBundle;

public class MyResources_Fr extends ListResourceBundle{

	
	public String [][] contenido={{"label_accept","Accepter"},{"label_exit","Sortir"},{"label_newGame","Nouveau Jeu"},
			{"label_options","Options"},{"label_quickGame","Rapide Jeu"},{"label_customGame","Custom Jeu"},
			{"label_newPlayer","Nouveau Joeur"},{"label_tutorial","Tutoriel"},{"label_gold","Or"},{"label_units","Uniti�s"},
			{"label_credits","Cr�dits"},{"label_mapEditor","�diteur de cartes"},{"label_reclute","Recruter"},{"label_language","Langue"},
			{"label_sound","Son"},{"label_attack","Attaque"},{"label_defense","D�fense"},{"label_movement","Mouvement"},
			{"label_probability","Probabilit�"},{"label_back","Retour"},{"AtacarYHuir","Attaque et de s'enfuir"},{"AtaqueCertero","Attaque pr�cise"},
			{"AtaqueEnZona","Zone d'attaque"},{"Cegar","Blind"},{"Convertir","Transformer"},{"CurarEstados","Etats Cure"},{"CurarZona","Zone Cure"},
			{"Envenenar","Poison "},{"LanzarSuriquen","Paru le shuriken"},{"Sprint","Sprint"},{"Yes","Oui"},{"No","No"},
			{"label_loadGame","Chargement du jeu"},{"Name","Nom"},{"Mana","Manne"},{"Health","Vie"},{"noPlayer12","Aucun des joueurs, il y"},
			{"noPlayer1","Le premier joueur il"},{"noPlayer2","Le deuxi�me joueur n'existe pas"},{"erase","Claire"}
	};
	
	@Override
	protected Object[][] getContents() {
		
		return contenido;
	}
	public String toString (){
		return "Frances";
	}

}
