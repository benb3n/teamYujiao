
package com.entity;

import java.util.*;

/**
 *
 * @author jovin ng
 */
public class Account {

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


    public Account(String accountid, String accounttypeid, String accountname, String balance, String clientid) {
        this.accountid = accountid;
        this.accounttypeid = accounttypeid;
        this.accountname = accountname;
        this.balance = balance;
        this.clientid = clientid;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getAccounttypeid() {
        return accounttypeid;
    }

    public void setAccounttypeid(String accounttypeid) {
        this.accounttypeid = accounttypeid;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }



}
