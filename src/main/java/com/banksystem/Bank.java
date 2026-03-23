package com.banksystem;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE   ,generator="mybranchid" )
	@SequenceGenerator (name = "mybranchid" ,allocationSize = 1 ,initialValue = 1000)
	private int id;
 private String name;
 private String addres;
 
 @OneToMany(mappedBy = "bank" ,fetch=FetchType.EAGER)
 private Set<Branch>branch;

 public int getId() {
	return id;
 }

 public void setId(int id) {
	this.id = id;
 }

 public String getName() {
	return name;
 }

 public void setName(String name) {
	this.name = name;
 }

 public String getAddres() {
	return addres;
 }

 public void setAddres(String addres) {
	this.addres = addres;
 }

 public Set<Branch> getBranch() {
	return branch;
 }

 public void setBranch(Set<Branch> branch) {
	this.branch = branch;
 }
 
 
}
