package lt.aleksandravicius.user.service;


import lt.aleksandravicius.user.dto.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User saveUser (User user);

    User getUserById(Long id);

    User updateUser (User user);

     void deleteUserById (Long id);

}
