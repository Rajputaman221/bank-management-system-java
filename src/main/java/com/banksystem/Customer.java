package com.banksystem;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE   ,generator="mycuid" )
	@SequenceGenerator (name = "mycuid" ,allocationSize = 1 ,initialValue = 8000)
	private int  customer_Id;
 private String   Customer_name;
 private String   Cutomer_address;
 private long phonenumber;
 
 @OneToMany
 private Set<Loan>Availed;
 
 @OneToMany
 private Set<Account>Maintain;

 public int getCustomer_Id() {
	return customer_Id;
 }

 public void setCustomer_Id(int customer_Id) {
	this.customer_Id = customer_Id;
 }

 public String getCustomer_name() {
	return Customer_name;
 }

 public void setCustomer_name(String customer_name) {
	Customer_name = customer_name;
 }

 public String getCutomer_address() {
	return Cutomer_address;
 }

 public void setCutomer_address(String cutomer_address) {
	Cutomer_address = cutomer_address;
 }

 public long getPhonenumber() {
	return phonenumber;
 }

 public void setPhonenumber(long phonenumber) {
	this.phonenumber = phonenumber;
 }

 public Set<Loan> getAvailed() {
	return Availed;
 }

 public void setAvailed(Set<Loan> availed) {
	Availed = availed;
 }

 public Set<Account> getMaintain() {
	return Maintain;
 }

 public void setMaintain(Set<Account> maintain) {
	Maintain = maintain;
 }
 

}
