package springbootdemo.demo.repository;

import org.springframework.data.repository.CrudRepository;
import springbootdemo.demo.model.User;

@org.springframework.stereotype.Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    public User findByEmailAndPassword(String email,String password);
}
