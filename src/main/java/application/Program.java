package application;

import entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager manager = managerFactory.createEntityManager();

        // Insert with JPA - Hibernate
        manager.getTransaction().begin();
        Person person = new Person(null, "Claudio" , "claudigo@gmail.com");
        manager.persist(person);
        manager.getTransaction().commit();

        // Select with JPA - Hibernate - SelectById
        Person p = manager.find(Person.class, person.getId());
        System.out.println(p);

        // Delete with JPA - Hibernate, PT-BR -

        manager.getTransaction().begin();
        manager.remove(p);
        manager.getTransaction().commit();

        System.out.println("Good.");
        manager.close();
        managerFactory.close();
    }
}
