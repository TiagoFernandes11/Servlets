package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import src.com.bookstore.entity.Users;

public class UserTest {

    public static void main(String[] args) {
        Users user1 = new Users();
        user1.setEmail("name@test.com.br");
        user1.setFullName("teste teste teste");
        user1.setPassword("helloworld");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebSite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(user1);

        entityManager.flush();

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        System.out.println("Users object persisted");
    }
}
