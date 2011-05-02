package Languages;

import java.util.ListResourceBundle;

public class MyResources_Fr extends ListResourceBundle{

	
	public Object [][] contenido={{"label_accept","Accepter"},{"label_exit","Sortir"},{"label_newGame","Nouveau Jeu"},
			{"label_options","Options"},{"label_quickGame","Rapide Jeu"},{"label_customGame","Custom Jeu"},
			{"label_newPlayer","Nouveau Joeur"},{"label_tutorial","Tutoriel"},{"label_gold","Or"},{"label_units","Unit�s"},
			{"label_credits","Crédits"},{"label_mapEditor","Éditeur de cartes"},{"label_reclute","Recruter"},,{"label_langauge","Langue"},
			{"label_sound","Son"}
	};
	
	@Override
	protected Object[][] getContents() {
		
		return contenido;
	}

}
