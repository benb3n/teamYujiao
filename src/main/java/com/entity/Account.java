
package com.entity;


import java.util.*;


/**
 *
 * @author jovin ng
 */

public class Account {

    public Account(String accountid, String password, String firstName, String lastName, String email, String gender,
			Date birthDate, String nationality, String interest, String region) {
		super();
		this.accountid = accountid;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		Email = email;
		Gender = gender;
		BirthDate = birthDate;
		Nationality = nationality;
		Interest = interest;
		Region = region;
	}
	private String accountid;
	private String password;
    private String firstName;
    private String lastName;
    private String Email;
    private String Gender;
    private Date BirthDate;
    private String Nationality;
    private String Interest;
    private String Region;
	private String accountname;
	private String accounttypeid;
	private String balance;
	private String clientid;


    public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Date getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}
	public String getNationality() {
		return Nationality;
	}
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	public String getInterest() {
		return Interest;
	}
	public void setInterest(String interest) {
		Interest = interest;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}


}
