package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import src.com.bookstore.entity.Book;
import src.com.bookstore.entity.Category;

import java.util.ArrayList;
import java.util.Date;

public class CategoryTest {

    public static void main(String[] args) {
        Category category = new Category();
        category.setName("Romance");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebSite");
        EntityManager entityManager= entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(category);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        System.out.println("persisted");
    }
}
