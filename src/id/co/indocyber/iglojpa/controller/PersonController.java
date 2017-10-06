/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.indocyber.iglojpa.controller;

import id.co.indocyber.iglojpa.model.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class PersonController {
    
    EntityManagerFactory emf;
    EntityManager em;
    Person p;
    
    public boolean addPerson(String name, Integer age, Double salary){
        boolean result = false;
        
        emf = Persistence.createEntityManagerFactory("igloJPAPU");
        em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        p = new Person();
        p.setName(name);
        p.setAge(age);
        p.setSalary(salary);
        em.persist(p);

        
        em.getTransaction().commit();
        result = true;
        
        em.close();
        emf.close();
        return result;
    }
    
    public List<Person> getPerson(){
        emf = Persistence.createEntityManagerFactory("igloJPAPU");
        p = new Person();
        em = emf.createEntityManager();
        List<Person> person = em.createQuery("Select p from Person p").getResultList();
        em.close();
        emf.close();
        return person;
    }
    
    
}
