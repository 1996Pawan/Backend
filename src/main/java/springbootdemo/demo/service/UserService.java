package springbootdemo.demo.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Service;
import springbootdemo.demo.vo.AddUser;
import springbootdemo.demo.vo.UserRequest;

@Service
public interface UserService {

    public void addUser(AddUser addUser);

    public Boolean validateUser(UserRequest userRequest) throws Exception;

}
