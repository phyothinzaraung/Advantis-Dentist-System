package miu.edu.cs489.ADS.controller;

import miu.edu.cs489.ADS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DentistController {

    @Autowired
    UserService userService;

//    @GetMapping("api/ads/dentists")
//    List<Dentist> getAllDentist(){
//        return patientService.getAllDentist();
//    }
}
