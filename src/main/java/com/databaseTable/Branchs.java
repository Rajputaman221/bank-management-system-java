package com.databaseTable;

import java.util.List;
import java.util.Scanner;

import com.banksystem.Bank;
import com.banksystem.Branch;
import com.banksystem.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Branchs {

    static Scanner sc = new Scanner(System.in);

    public static void run(EntityManager em) {
        int choice;
        do {
            System.out.println(" Branch Menu ");
            System.out.println("1 Create Branch");
            System.out.println("2 View Branches");
            System.out.println("3 Update Branch");
            System.out.println("4 Delete Branch");
            System.out.println("5 Back");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1: createBranch(em); break;
                case 2: viewBranch(em); break;
                case 3: updateBranch(em); break;
                case 4: deleteBranch(em); break;
                case 5: System.out.println("Back to Main Menu"); break;
                default: System.out.println("Invalid choice");
            }
        } while(choice != 5);
    }

    private static void createBranch(EntityManager em) {

        System.out.println("Enter Branch Name:");
        String name = sc.nextLine();

        System.out.println("Enter Branch Address:");
        String address = sc.nextLine();

        System.out.println("Enter Bank ID:");
        int bankId = sc.nextInt();
        sc.nextLine();

        Bank bank = em.find(Bank.class, bankId);

        if (bank == null) {
            System.out.println("Bank not found!");
            return;
        }

        Branch b = new Branch();
        b.setBranchname(name);
        b.setBranchaddres(address);

        b.setBank(bank);

        // 🔥 FIX HERE
        bank.getBranch().add(b);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(b);
        et.commit();

        System.out.println("Branch Created Successfully!");
    }
    private static void viewBranch(EntityManager em) {
        em.createQuery("FROM Branch", Branch.class)
          .getResultList()
          .forEach(b -> {
              System.out.println("Branch ID: " + b.getBranch_id());
              System.out.println("Branch Name: " + b.getBranchname());
              System.out.println("Branch Address: " + b.getBranchaddres());
          
             
          });
    }

    private static void updateBranch(EntityManager em) {
        System.out.println("Enter Branch ID to update:");
        int id = sc.nextInt();
        sc.nextLine();

        Branch b = em.find(Branch.class, id);
        if (b == null) {
            System.out.println("Branch not found");
            return;
        }

        System.out.println("Enter New Branch Name:");
        String name = sc.nextLine();
        System.out.println("Enter New Branch Address:");
        String address = sc.nextLine();

        EntityTransaction et = em.getTransaction();
        et.begin();
        b.setBranchname(name);
        b.setBranchaddres(address);
       
        et.commit();

        System.out.println("Branch Updated Successfully!");
    }

    private static void deleteBranch(EntityManager em) {
        System.out.println("Enter Branch ID to delete:");
        int id = sc.nextInt();
        sc.nextLine();

        Branch b = em.find(Branch.class, id);
        if (b == null) {
            System.out.println("Branch not found");
            return;
        }

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(b);
        et.commit();

        System.out.println("Branch Deleted Successfully!");
    }
}