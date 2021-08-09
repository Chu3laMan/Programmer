package classes.programmerEngine.business;

import java.io.Serializable;

public class Programmer_2 implements Serializable {
	
	private static final long serialVersionUID = -5623210596800145338L;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String github_account;
	private String saltPassword;
	private String proglang;
	private String framework;
	
	
	public Programmer_2(String firstName, String lastName, String email, String password, String github_account, String saltPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.github_account = github_account;
		this.saltPassword = saltPassword;
	}
	
	public Programmer_2(String firstName, String lastName, String email, String password, String github_account, String saltPassword, String proglang, String framework) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.github_account = github_account;
		this.saltPassword = saltPassword;
		this.proglang = proglang;
		this.framework = framework;
	}
	
	
	
	
	public String getFramework() {
		return framework;
	}
	
	public void setFramework(String framework) {
		this.framework = framework;
	}
	
	
	public String getProgrammingLanguage() {
		return proglang;
	}
	
	public void setProgramming_Language(String proglang) {
		this.proglang = proglang;
	}

	

	public String getSaltPassword() {
		return saltPassword;
	}


	public void setSaltPassword(String saltPassword) {
		this.saltPassword = saltPassword;
	}

	public Programmer_2() {}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGithub_account() {
		return github_account;
	}

	public void setGithub_account(String github_account) {
		this.github_account = github_account;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return " [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", github_account=" + github_account + ", proglang=" + proglang + ", framework=" + framework + "]";
	}

	

	
	
	

}
