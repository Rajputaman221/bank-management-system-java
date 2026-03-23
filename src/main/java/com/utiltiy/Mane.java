package com.utiltiy;

import com.WholeManagement.Management;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Mane {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
        EntityManager em = emf.createEntityManager();

        try {
           
            Management managementMenu = new Management(em);
            managementMenu.showMenu();
        } finally {
            em.close();
            emf.close();
        }
    }
}