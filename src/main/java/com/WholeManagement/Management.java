package com.WholeManagement;

import java.util.Scanner;
import jakarta.persistence.EntityManager;

import com.databaseTable.Banks;
import com.databaseTable.Branchs;
import com.databaseTable.Customers;
import com.databaseTable.Accounts;
import com.databaseTable.Loans;

public class Management {

    private Scanner sc = new Scanner(System.in);
    private EntityManager em;

  
    public Management(EntityManager em) {
        this.em = em;
    }
    

    public void showMenu() {
        int choice;
        do {
           
            System.out.println("      BANK MANAGEMENT SYSTEM");
            
            System.out.println("1. Bank Management");
            System.out.println("2. Branch Management");
            System.out.println("3. Customer Management");
            System.out.println("4. Account Management");
            System.out.println("5. Loan Management");
            System.out.println("6. Exit");

            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: Banks.run(em); break;
                case 2: Branchs.run(em); break;
                case 3: Customers.run(em); break;
                case 4: Accounts.run(em); break;
                case 5: Loans.run(em); break;
                case 6: System.out.println("Exiting System..."); break;
                default: System.out.println("Invalid Choice");
            }
        } while (choice != 6);
    }
}