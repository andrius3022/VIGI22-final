package lt.aleksandravicius.user.service;

import lt.aleksandravicius.user.dto.User;
import lt.aleksandravicius.user.dao.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository; //allows to inject dependencies

    public UserServiceImplementation(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }
    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);

    }

    //  @Override
  //  public void deleteUserById(Long id) {
  //  }



//    @Override
//    public User saveUser(User user) {
//        return uRepository.save(user);
//    }
//
//    @Override
//    public User getSingleUser(Long id) {
//        Optional<User> user = userRepository.findById(id);
//        if (user.isPresent()){
//            return user.get();
//        }throw new RuntimeException ("User not found with this ID");
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//
//    }
//
//    @Override
//    public User updateUser(User user) {
//        return userRepository.save(user);
//    }
//

}
