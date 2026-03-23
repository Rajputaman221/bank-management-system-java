package com.banksystem;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE   ,generator="mybranch" )
	@SequenceGenerator (name = "mybranch" ,allocationSize = 1 ,initialValue = 101)
	private int branch_id;
 private String branchname;
 private String branchaddres;
 
 @ManyToOne
 @JoinColumn(name = "bank_id")
 private Bank bank;

 @ManyToMany
 private List<Loan> loan;
 
 @ManyToMany
 private List<Account>Maintain;
 
 
 public List<Account> getMaintain() {
	return Maintain;
}

 public void setMaintain(List<Account> maintain) {
	Maintain = maintain;
 }

 public List<Loan> getLoan() {
	return loan;
}

 public void setLoan(List<Loan> loan) {
	this.loan = loan;
 }

 public int getBranch_id() {
	return branch_id;
 }

 public void setBranch_id(int branch_id) {
	this.branch_id = branch_id;
 }

 public String getBranchname() {
	return branchname;
 }

 public void setBranchname(String branchname) {
	this.branchname = branchname;
 }

 public String getBranchaddres() {
	return branchaddres;
 }

 public void setBranchaddres(String branchaddres) {
	this.branchaddres = branchaddres;
 }

 public Bank getBank() {
	return bank;
 }

 public void setBank(Bank bank) {
	this.bank = bank;
 }
 
}
