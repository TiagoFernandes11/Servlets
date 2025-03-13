import java.util.List;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

import jakarta.persistence.Persistence;

public class UserDaoTest {
	public static void main(String args[]) {
		UserDAO userDao = new UserDAO(Persistence.createEntityManagerFactory("BookStoreWebSite").createEntityManager());
		
		List<Users> users = userDao.listAll();
		
		for(Users user : users) {
			System.out.println(user.getUserId() + ", " + user.getEmail() + ", " + user.getFullName());
		}
		
		System.out.println("Count: " + userDao.count());
	}
}
