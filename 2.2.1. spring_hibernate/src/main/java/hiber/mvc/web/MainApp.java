package hiber.mvc.web;

import hiber.mvc.web.config.AppConfig;
import hiber.mvc.web.model.User;
import hiber.mvc.web.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.save(new User("User1", 25, "user1@mail.ru"));
      userService.save(new User("User2", 30, "user2@mail.ru"));
      userService.save(new User("User3", 35, "user3@mail.ru"));
      userService.save(new User("User4", 40, "user4@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user.toString());
         System.out.println();
      }

      context.close();
   }
}
