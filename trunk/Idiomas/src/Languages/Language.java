package Languages;

import java.util.HashMap;

public abstract class Language {

	protected HashMap words;
	protected String name;
	
	public Language(){
		words=new HashMap<String, String>();
	}

	public String getWords(String x) {
		return (String) words.get(x);
	}
	public String toString (){
		return name;
	}

}
