package hiber.mvc.web.service;

import hiber.mvc.web.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> listUsers();
    User show(Long id);
    void update(User user, long id);
    void delete(long id);
//    public User findUserByCar(String model, int series);
}
