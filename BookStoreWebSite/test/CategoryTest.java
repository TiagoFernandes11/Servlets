import java.util.List;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Category;
import com.bookstore.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CategoryTest {
	
	public static void main(String args[]) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebSite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		CategoryDAO categoryDAO = new CategoryDAO(entityManager);
		
		Category category = new Category();
		category.setName("Computaçã");
		
		categoryDAO.create(category);
		
		category.setName("Computação");
		
		System.out.println("categoryDao.get" + categoryDAO.get(7).getName());
		
		List<Category> categories = categoryDAO.listAll();
		
		System.out.println("categoryDao.listAll" + categories);
		
		System.out.println("categoryDao.count" + categoryDAO.count());
		
		categoryDAO.delete(7);
		
		categories = categoryDAO.listAll();
		
		System.out.println(categories);
	}
}
