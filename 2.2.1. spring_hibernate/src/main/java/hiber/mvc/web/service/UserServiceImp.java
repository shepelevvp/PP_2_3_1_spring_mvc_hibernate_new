package hiber.mvc.web.service;

import hiber.mvc.web.dao.UserDao;
import hiber.mvc.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void save(User user) {
      userDao.save(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional(readOnly = true)
   @Override
   public User show(Long id) {
      return userDao.show(id);
   }

   @Transactional
   @Override
   public void update(User user, long id) {
      userDao.update(user, id);
   }

   @Transactional
   @Override
   public void delete(long id) {
      userDao.delete(id);
   }

}
