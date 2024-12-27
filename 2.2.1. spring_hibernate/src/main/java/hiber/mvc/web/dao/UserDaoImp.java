package hiber.mvc.web.dao;

import hiber.mvc.web.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void save(User user) {
      entityManager.merge(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query= entityManager.createQuery("from User", User.class);
      return query.getResultList();
   }

   @Override
   public User show(Long id) {
      return entityManager.find(User.class, id);
   }

   @Override
   public void update(User newUser, Long id) {
      User user = show(id);
      if (user != null) {
         user.setName(newUser.getName());
         user.setAge(newUser.getAge());
         user.setEmail(newUser.getEmail());
         entityManager.merge(user);
      }
   }

   @Override
   public void delete(Long id) {
      User deleteUser = show(id);
      if (deleteUser != null) { // проверка на существование
         entityManager.remove(deleteUser);
      }
   }



}
