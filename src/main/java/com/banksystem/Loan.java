package com.banksystem;


import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.SequenceGenerator;

@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE   ,generator="mylaid" )
	@SequenceGenerator (name = "mylaid" ,allocationSize = 1 ,initialValue = 5000)
	private int Loan_id;
 private String Loan_name;
 private String Loan_addres;
 
 
 @ManyToMany
 private Set<Branch>offer;
 
 @ManyToMany
 private Set<Customer>Availed;

 public int getLoan_id() {
	return Loan_id;
 }

 public void setLoan_id(int loan_id) {
	Loan_id = loan_id;
 }

 public String getLoan_name() {
	return Loan_name;
 }

 public void setLoan_name(String loan_name) {
	Loan_name = loan_name;
 }

 public String getLoan_addres() {
	return Loan_addres;
 }

 public void setLoan_addres(String loan_addres) {
	Loan_addres = loan_addres;
 }

 public Set<Branch> getOffer() {
	return offer;
 }

 public void setOffer(Set<Branch> offer) {
	this.offer = offer;
 }

 public Set<Customer> getAvailed() {
	return Availed;
 }

 public void setAvailed(Set<Customer> availed) {
	Availed = availed;
 }


 
	

}
