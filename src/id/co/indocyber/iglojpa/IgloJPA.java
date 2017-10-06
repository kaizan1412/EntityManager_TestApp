/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.indocyber.iglojpa;

import id.co.indocyber.iglojpa.model.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class IgloJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("igloJPAPU");
        EntityManager em = emf.createEntityManager();   // membuat sebuah table dari nama Entity Class
        
        em.getTransaction().begin();
        
        Person p = new Person();
        p.setName("Smith Depok");
        p.setAge(23);
        p.setSalary(24500000.0);
        
        em.persist(p);   // menyimpan data ke database / tabel
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
