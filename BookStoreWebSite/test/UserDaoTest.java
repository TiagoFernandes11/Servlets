import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

import jakarta.persistence.Persistence;

public class UserDaoTest {
	public static void main(String args[]) {
		UserDAO userDao = new UserDAO(Persistence.createEntityManagerFactory("BookStoreWebSite").createEntityManager());
		
		Users users = userDao.get(1);
				
		if(users != null) {
			System.out.println(users.getEmail());
		}
		
	}
}
