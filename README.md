# 🏦 Bank Management System (Java + Hibernate)

## 📖 Project Description

This is a **console-based Bank Management System** developed using **Java, Hibernate (JPA), and PostgreSQL**.
The system allows users to manage banking operations like creating banks, branches, customers, accounts, and loans with proper database relationships.

---

## 🚀 Features

* ✅ Bank Management (Create, View, Update, Delete)
* ✅ Branch Management
* ✅ Customer Management
* ✅ Account Management
* ✅ Loan Management
* ✅ Relationship Mapping using Hibernate (JPA)
* ✅ Console-based interactive menu system

---

## 🛠️ Technologies Used

* **Java**
* **Hibernate (JPA)**
* **PostgreSQL**
* **JDBC**
* **Maven** (if used)

---

## 🗂️ Project Structure

```
com.banksystem
 ├── Bank.java
 ├── Branch.java
 ├── Customer.java
 ├── Account.java
 ├── Loan.java

com.databaseTable
 ├── Banks.java
 ├── Branchs.java
 ├── Customers.java
 ├── Accounts.java
 ├── Loans.java

com.utiltiy
 ├── Mane.java
```

---

## 🔗 Entity Relationships

* 🏦 One Bank → Many Branches
* 🏢 One Branch → Many Accounts
* 👥 One Customer → Multiple Accounts
* 🔄 Many-to-Many → Loans & Accounts

---

## ⚙️ How to Run the Project

### 1️⃣ Clone the Repository

```
git clone https://github.com/YOUR_USERNAME/bank-management-system-java.git
```

### 2️⃣ Open in IDE

* IntelliJ IDEA / Eclipse

### 3️⃣ Configure Database (PostgreSQL)

* Database Name: `hibernateDB`
* Username: `postgres`
* Password: `your_password`

### 4️⃣ Configure Hibernate

Update your `hibernate.cfg.xml` or `persistence.xml` with DB credentials.

### 5️⃣ Run the Application

Run:

```
Mane.java
```

---
