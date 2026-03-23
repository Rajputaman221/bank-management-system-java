package com.databaseTable;

import java.util.List;
import java.util.Scanner;
import com.banksystem.Bank;
import com.banksystem.Branch;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Banks {

    static Scanner sc = new Scanner(System.in);

    public static void run(EntityManager em) {
        int choice;
        do {
            System.out.println(" Bank");
            System.out.println("1 Create Bank");
            System.out.println("2 View Banks");
            System.out.println("3 Update Bank");
            System.out.println("4 Delete Bank");
            System.out.println("5 Back");

            choice = sc.nextInt();
            sc.nextLine(); 

            switch(choice) {
                case 1: createBank(em); break;
                case 2: viewBank(em); break;
                case 3: updateBank(em); break;
                case 4: deleteBank(em); break;
                case 5: System.out.println("Back to Main Menu"); break;
                default: System.out.println("Invalid choice");
            }

        } while(choice != 5);
    }

    private static void createBank(EntityManager em) {
        System.out.println("Enter Bank Name:");
        String name = sc.nextLine();
        System.out.println("Enter Bank Address:");
        String address = sc.nextLine();

        Bank b = new Bank();
        b.setName(name);
        b.setAddres(address);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(b);
        et.commit();

        System.out.println("Bank Created Successfully!");
    }

    private static void viewBank(EntityManager em) {
        em.createQuery("FROM Bank", Bank.class)
          .getResultList()
          .forEach(b -> {
              System.out.println("Bank ID: " + b.getId());
              System.out.println("Bank Name: " + b.getName());
              System.out.println("Bank Address: " + b.getAddres());

              System.out.println("Branches:");

              if (b.getBranch() != null && !b.getBranch().isEmpty()) {
                  for (Branch br : b.getBranch()) {
                      System.out.println("   Branch ID: " + br.getBranch_id());
                      System.out.println("   Branch Name: " + br.getBranchname());
                  }
              } else {
                  System.out.println("   No branches found");
              }
          });
    }

    private static void updateBank(EntityManager em) {
        System.out.println("Enter Bank ID to update:");
        int id = sc.nextInt();
        sc.nextLine();

        Bank b = em.find(Bank.class, id);
        if (b == null) {
            System.out.println("Bank not found");
            return;
        }

        System.out.println("Enter New Bank Name:");
        String name = sc.nextLine();
        System.out.println("Enter New Bank Address:");
        String address = sc.nextLine();

        EntityTransaction et = em.getTransaction();
        et.begin();
        b.setName(name);
        b.setAddres(address);
        et.commit();

        System.out.println("Bank Updated Successfully!");
    }

    private static void deleteBank(EntityManager em) {
        System.out.println("Enter Bank ID to delete:");
        int id = sc.nextInt();
        sc.nextLine();

        Bank b = em.find(Bank.class, id);
        if (b == null) {
            System.out.println("Bank not found");
            return;
        }

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(b);
        et.commit();

        System.out.println("Bank Deleted Successfully!");
    }
}