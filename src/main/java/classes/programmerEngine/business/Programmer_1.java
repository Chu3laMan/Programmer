package classes.programmerEngine.business;

import java.io.Serializable;

public class Programmer_1 implements Serializable {
	
	
	private static final long serialVersionUID = 6017303703230171424L;
	private String firstName;
	private String lastName;
	private String email;
	
	public Programmer_1() {}
	
	public Programmer_1(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	//Setter and Getter methods for First Name
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	//Setter and Getter methods for Last Name
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//Setter and Getter methods for Email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
