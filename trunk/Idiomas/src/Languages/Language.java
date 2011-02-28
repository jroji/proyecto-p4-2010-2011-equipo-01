package Languages;

import java.util.HashMap;

public abstract class Language {

	HashMap words = new HashMap();

	public String getWords(String x) {
		return (String) words.get(x);
	}

}
