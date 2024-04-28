package miu.edu.cs489.ADS.controller;

import miu.edu.cs489.ADS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ads/users")
public class UserController {

    @Autowired
    UserService userService;


}
