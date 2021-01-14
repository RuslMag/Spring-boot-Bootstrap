package web.services;

import web.models.User;

import java.util.List;


public interface UserService {

    List<User> listUsers();

    User getUserById(Long id);

    void save(User user) ;

    void update(User updatedUser);

    void delete(Long id);

    boolean loadUserByEmail(String email);

}
