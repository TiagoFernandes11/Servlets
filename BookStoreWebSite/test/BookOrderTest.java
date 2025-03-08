package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import src.com.bookstore.entity.BookOrder;
import src.com.bookstore.entity.Customer;

import java.util.Date;

public class BookOrderTest {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebSite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Customer customer = entityManager.find(Customer.class, 1L);

        BookOrder bookOrder = new BookOrder();
        bookOrder.setCustomer(customer);
        bookOrder.setOrderDate(new Date());
        bookOrder.setOrderStatus("Separação");
        bookOrder.setOrderTotal(200.0f);
        bookOrder.setPaymentMethod("Cartão");
        bookOrder.setRecipientName(customer.getFullName());
        bookOrder.setRecipientPhone(customer.getPhoneNumber());
        bookOrder.setShippingAddress(customer.getAddress());

        entityManager.getTransaction().begin();
        entityManager.persist(bookOrder);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();
        entityManager.close();

        System.out.println("BookOrder persisted");
    }
}
