package springbootdemo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbootdemo.demo.service.UserService;
import springbootdemo.demo.vo.AddUser;
import springbootdemo.demo.vo.UserRequest;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class springbootController

{
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
      public Boolean addUser(@RequestBody AddUser addUser)
      {
          userService.addUser(addUser);
          return true;
      }
      @PostMapping("/validateUser")
      public HashMap<String,Boolean> validateUser(@RequestBody UserRequest userRequest) throws Exception {
        HashMap<String,Boolean> hashMap = new HashMap<>();
        Boolean userExist = userService.validateUser(userRequest);
            System.out.println((userExist));
            hashMap.put("status",userExist);
          return hashMap;
      }
}
