package classes.programmerEngine.business;

import java.io.Serializable;

public class Framework implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6381997590739368548L;
	private String framework_name;
	
	
	public Framework() {}
	
	
	public Framework(String framework_name) {
		this.framework_name = framework_name;
	}
	
	
	//Setter and Getter methods for Framework Name
	public void setFramework_Name(String framework_name) {
		this.framework_name = framework_name;
	}
	
	public String getFramework_name() {
		return framework_name;
	}

}
