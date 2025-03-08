package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import src.com.bookstore.entity.Book;
import src.com.bookstore.entity.BookOrder;
import src.com.bookstore.entity.OrderDetail;

public class OrderDetailTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebSite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Book book = entityManager.find(Book.class, 2L);
        BookOrder bookOrder = entityManager.find(BookOrder.class, 1L);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(bookOrder);
        orderDetail.setBook(book);
        orderDetail.setQuantity(5);
        orderDetail.setSubTotal(book.getPrice() * orderDetail.getQuantity());

        entityManager.getTransaction().begin();
        entityManager.persist(orderDetail);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();
        entityManager.close();

        System.out.println("OrderDetail persited");
    }
}
