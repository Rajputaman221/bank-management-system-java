package com.databaseTable;

import java.util.Scanner;
import com.banksystem.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Accounts {

    static Scanner sc = new Scanner(System.in);

    public static void run(EntityManager em) {
        int choice;
        do {
         
            System.out.println("1. Create Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Update Account");
            System.out.println("4. Delete Account");
            System.out.println("5. Back To Main");

            choice = sc.nextInt();
            sc.nextLine(); 

            switch(choice) {
                case 1: createAccount(em); break;
                case 2: viewAccount(em); break;
                case 3: updateAccount(em); break;
                case 4: deleteAccount(em); break;
                case 5: System.out.println("Back to Main Menu"); break;
                default: System.out.println("Invalid choice");
            }
        } while(choice != 5);
    }

   
    private static void createAccount(EntityManager em) {
        System.out.println("Enter Account No:");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Account Type:");
        String type = sc.nextLine();

        System.out.println("Enter Balance:");
        long balance = sc.nextLong();
        sc.nextLine();

        Account acc = new Account();
        acc.setAccount_no(accNo);
        acc.setAccount_type(type);
        acc.setBalance(balance);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(acc);
        et.commit();

        System.out.println("Account Created Successfully!");
    }

    
    private static void viewAccount(EntityManager em) {
        em.createQuery("FROM Account", Account.class)
          .getResultList()
          .forEach(a -> {
              System.out.println("Account No: " + a.getAccount_no());
              System.out.println("Type: " + a.getAccount_type());
              System.out.println("Balance: " + a.getBalance());
            
          });
    }

   
    private static void updateAccount(EntityManager em) {
        System.out.println("Enter account number to update:");
        int accNo = sc.nextInt();
        sc.nextLine();

        Account acc = em.find(Account.class, accNo);
        if (acc == null) {
            System.out.println("Account not found");
            return;
        }

        System.out.println("Enter new Type:");
        String type = sc.nextLine();
        System.out.println("Enter new Balance:");
        long balance = sc.nextLong();
        sc.nextLine();

        EntityTransaction et = em.getTransaction();
        et.begin();
        acc.setAccount_type(type);
        acc.setBalance(balance);
        et.commit();

        System.out.println("Account updated successfully!");
    }

   
    private static void deleteAccount(EntityManager em) {
        System.out.println("Enter account number to delete:");
        int accNo = sc.nextInt();
        sc.nextLine();

        Account acc = em.find(Account.class, accNo);
        if (acc == null) {
            System.out.println("Account not found");
            return;
        }

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(acc);
        et.commit();

        System.out.println("Account deleted successfully!");
    }
}