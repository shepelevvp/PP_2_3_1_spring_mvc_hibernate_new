package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.Query;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {



   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user, Car car) {
      sessionFactory.getCurrentSession().save(user);
      car.setUser(user);
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query= (TypedQuery<User>) sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public void findUserByCar(String model, int series) {
      // вывожу списком, т.к. предполагаю, что в большой базе сотрудников
      // могут быть пересечения у пользователей по маркам и моделям автомобилей
      Session session = sessionFactory.getCurrentSession();
      String hql = "FROM Car WHERE model = :model AND series = :series";
      List<Car> query = session.createQuery(hql, Car.class)
              .setParameter("model", model)
              .setParameter("series", series)
              .getResultList();
      System.out.printf("Автомобиль марки %s серии %s принадлежит:\n", model, series);
      for (Car car : query) {
         User user = session.get(User.class, car.getId());
         System.out.println(user.toString());
      }

   }

}
