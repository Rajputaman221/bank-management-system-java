package com.databaseTable;

import java.util.Scanner;
import com.banksystem.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Loans {

    static Scanner sc = new Scanner(System.in);

    public static void run(EntityManager em) {
        int choice;
        do {
            System.out.println("Loan ");
            System.out.println("1 Create ");
            System.out.println("2 View ");
            System.out.println("3 Update");
            System.out.println("4 Delete ");
            System.out.println("5 Back");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1: createLoan(em); break;
                case 2: viewLoan(em); break;
                case 3: updateLoan(em); break;
                case 4: deleteLoan(em); break;
                case 5: System.out.println("Back "); break;
                default: System.out.println("Invalid choice");
            }
        } while(choice != 5);
    }

    private static void createLoan(EntityManager em) {
        System.out.println("Enter Loan Name:");
        String name = sc.nextLine();
        System.out.println("Enter Loan Address:");
        String address = sc.nextLine();

        Loan l = new Loan();
        l.setLoan_name(name);
        l.setLoan_addres(address);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(l);
        et.commit();

        System.out.println(" Created Successfully!");
    }

    private static void viewLoan(EntityManager em) {
        em.createQuery("FROM Loan", Loan.class)
          .getResultList()
          .forEach(l -> {
              System.out.println("Loan ID: " + l.getLoan_id());
              System.out.println("Loan Name: " + l.getLoan_name());
              System.out.println("Loan Address: " + l.getLoan_addres());
              System.out.println("------------------");
          });
    }

    private static void updateLoan(EntityManager em) {
        System.out.println("Enter Loan ID to update:");
        int id = sc.nextInt();
        sc.nextLine();

        Loan l = em.find(Loan.class, id);
        if (l == null) {
            System.out.println("Loan not found");
            return;
        }

        System.out.println("Enter New Loan Name:");
        String name = sc.nextLine();
        System.out.println("Enter New Loan Address:");
        String address = sc.nextLine();

        EntityTransaction et = em.getTransaction();
        et.begin();
        l.setLoan_name(name);
        l.setLoan_addres(address);
        et.commit();

        System.out.println("Loan Updated Successfully!");
    }

    private static void deleteLoan(EntityManager em) {
        System.out.println("Enter Loan ID to delete:");
        int id = sc.nextInt();
        sc.nextLine();

        Loan l = em.find(Loan.class, id);
        if (l == null) {
            System.out.println("Loan not found");
            return;
        }

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(l);
        et.commit();

        System.out.println("Loan Deleted Successfully!");
    }
}