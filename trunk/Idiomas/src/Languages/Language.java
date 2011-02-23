package Languages;

import java.util.HashMap;

public class Language {

	HashMap words = new HashMap();

	public String getWords(String x) {
		return (String) words.get(x);
	}

	public void setWords(HashMap words) {
		this.words = words;
	}
}
