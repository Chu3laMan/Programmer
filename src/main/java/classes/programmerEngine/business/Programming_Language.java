package classes.programmerEngine.business;

import java.io.Serializable;

public class Programming_Language implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2614609377439172174L;
	private String programming_lang;
	
	
	public Programming_Language() {};
	
	
	public Programming_Language(String programming_lang) {
		this.programming_lang = programming_lang;
	}


	//Setter and Getter for Programming Language
	public void setProgramming_lang(String programming_lang) {
		this.programming_lang = programming_lang;
	}
	
	public String getProgramming_lang() {
		return programming_lang;
	}

}
