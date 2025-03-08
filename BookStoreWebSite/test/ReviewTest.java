package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import src.com.bookstore.entity.Book;
import src.com.bookstore.entity.Customer;
import src.com.bookstore.entity.Review;

import java.util.Date;

public class ReviewTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebSite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Book book = entityManager.find(Book.class, 2L);
        Customer customer = entityManager.find(Customer.class, 1L);

        Review review = new Review();
        review.setReviewTime(new Date());
        review.setBook(book);
        review.setCustomer(customer);
        review.setHeadline("teste");
        review.setRating(5);
        review.setComment("teste comentario");

        entityManager.getTransaction().begin();
        entityManager.persist(review);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();
        entityManager.close();

        System.out.println("Review persisted");
    }
}
