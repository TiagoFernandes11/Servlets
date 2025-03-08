package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import src.com.bookstore.entity.Book;
import src.com.bookstore.entity.Category;

import java.util.Date;

public class BookTest {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebSite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Category category = entityManager.find(Category.class, new Long(2));

        Book book = new Book();
        book.setAuthor("Tiago");
        book.setPrice(20.0f);
        book.setIsbn("isbn");
        book.setLastUpdatedTime(new Date());
        book.setCategory(category);

        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();
        entityManager.close();

        System.out.println("Book persisted");
    }
}
