package com.banksystem;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE   ,generator="myAccountid" )
	@SequenceGenerator (name = "myAccountid" ,allocationSize = 1 ,initialValue = 6000)
	private int Account_no;
 private String Account_type;
 private long balance;
 
 @ManyToMany
 private Set<Branch>Maintain;
 
 @OneToOne
 private Customer hold;

 public int getAccount_no() {
	return Account_no;
 }

 public void setAccount_no(int account_no) {
	Account_no = account_no;
 }

 public String getAccount_type() {
	return Account_type;
 }

 public void setAccount_type(String account_type) {
	Account_type = account_type;
 }

 public long getBalance() {
	return balance;
 }

 public void setBalance(long balance) {
	this.balance = balance;
 }

 public Set<Branch> getMaintain() {
	return Maintain;
 }

 public void setMaintain(Set<Branch> maintain) {
	Maintain = maintain;
 }

 public Customer getHold() {
	return hold;
 }

 public void setHold(Customer hold) {
	this.hold = hold;
 }

 
 

}
