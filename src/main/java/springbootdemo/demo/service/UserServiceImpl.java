package springbootdemo.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootdemo.demo.model.User;
import springbootdemo.demo.repository.UserRepository;
import springbootdemo.demo.vo.AddUser;
import springbootdemo.demo.vo.UserRequest;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(AddUser addUser)
    {
        String name=addUser.getName();
        String email=addUser.getEmail();
        String password=addUser.getPassword();

        User user= new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        userRepository.save(user);

    }

    @Override
    public Boolean validateUser(UserRequest userRequest) throws Exception {

        Boolean userExist = false;
        String email = userRequest.getEmail();
        String password = userRequest.getPassword();

        User user = userRepository.findByEmailAndPassword(email, password);
        System.out.println(user);
        if (user == null) {

            userExist = false;
            //throw new Exception("invalid email or password");
        } else
            userExist = true;
        return userExist;
    }












}
