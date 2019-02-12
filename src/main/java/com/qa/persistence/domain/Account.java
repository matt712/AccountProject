package com.qa.persistence.domain;

public class Account {
	private long id;
	private int accNumber;
	private String FirstName;
	private String LastName;
	public Account(){
	}
	public Account(String accNumber) {
		
	}
	public Account(long id, int accNumber, String firstName, String lastName) {
		super();
		this.id = id;
		this.accNumber = accNumber;
		FirstName = firstName;
		LastName = lastName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
}
