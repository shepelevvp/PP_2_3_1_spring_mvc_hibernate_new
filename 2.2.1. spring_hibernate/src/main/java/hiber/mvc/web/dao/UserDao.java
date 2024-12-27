package hiber.mvc.web.dao;

import hiber.mvc.web.model.User;

import java.util.List;

public interface UserDao {
   void save(User user);
   List<User> listUsers();

   void update(User newUser, Long id);

   void delete(Long id);


   User show(Long id);
}
