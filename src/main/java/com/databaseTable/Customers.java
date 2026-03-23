package com.databaseTable;

import java.util.Scanner;
import com.banksystem.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Customers {

    static Scanner sc = new Scanner(System.in);

    public static void run(EntityManager em) {
        int choice;
        do {
            System.out.println("----- Customer Menu -----");
            System.out.println("1 Create Customer");
            System.out.println("2 View Customers");
            System.out.println("3 Update Customer");
            System.out.println("4 Delete Customer");
            System.out.println("5 Back");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1: createCustomer(em); break;
                case 2: viewCustomer(em); break;
                case 3: updateCustomer(em); break;
                case 4: deleteCustomer(em); break;
                case 5: System.out.println("Back to Main Menu"); break;
                default: System.out.println("Invalid choice");
            }
        } while(choice != 5);
    }

    private static void createCustomer(EntityManager em) {
        System.out.println("Enter Customer Name:");
        String name = sc.nextLine();
        System.out.println("Enter Customer Address:");
        String address = sc.nextLine();
        System.out.println("Enter Phone Number:");
        long phone = sc.nextLong();
        sc.nextLine();

        Customer c = new Customer();
        c.setCustomer_name(name);
        c.setCutomer_address(address);
        c.setPhonenumber(phone);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(c);
        et.commit();

        System.out.println("Customer Created Successfully!");
    }

    private static void viewCustomer(EntityManager em) {
        em.createQuery("FROM Customer", Customer.class)
          .getResultList()
          .forEach(c -> {
              System.out.println("Customer ID: " + c.getCustomer_Id());
              System.out.println("Name: " + c.getCustomer_name());
              System.out.println("Address: " + c.getCutomer_address());
              System.out.println("Phone: " + c.getPhonenumber());
            
          });
    }

    private static void updateCustomer(EntityManager em) {
        System.out.println("Enter Customer ID to update:");
        int id = sc.nextInt();
        sc.nextLine();

        Customer c = em.find(Customer.class, id);
        if (c == null) {
            System.out.println("Customer not found");
            return;
        }

        System.out.println("Enter New Name:");
        String name = sc.nextLine();
        System.out.println("Enter New Address:");
        String address = sc.nextLine();

        EntityTransaction et = em.getTransaction();
        et.begin();
        c.setCustomer_name(name);
        c.setCutomer_address(address);
        et.commit();

        System.out.println("Customer Updated Successfully!");
    }

    private static void deleteCustomer(EntityManager em) {
        System.out.println("Enter Customer ID to delete:");
        int id = sc.nextInt();
        sc.nextLine();

        Customer c = em.find(Customer.class, id);
        if (c == null) {
            System.out.println("Customer not found");
            return;
        }

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(c);
        et.commit();

        System.out.println("Customer Deleted Successfully!");
    }
}