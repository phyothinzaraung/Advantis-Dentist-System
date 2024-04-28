package miu.edu.cs489.ADS.controller;

import jakarta.validation.Valid;
import miu.edu.cs489.ADS.dto.userAuth.UserAuthRequest;
import miu.edu.cs489.ADS.dto.userAuth.UserAuthResponse;
import miu.edu.cs489.ADS.service.UserService;
import miu.edu.cs489.ADS.service.util.JWTMgmtUtilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("adsweb/api/v1/public/auth")
public class UserAuthController {

    private JWTMgmtUtilityService jwtMgmtUtilityService;
    private AuthenticationManager authenticationManager;
    private UserService userService;

    public UserAuthController(JWTMgmtUtilityService jwtMgmtUtilityService, AuthenticationManager authenticationManager, UserService userService) {
        this.jwtMgmtUtilityService = jwtMgmtUtilityService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping(value = {"/login"})
    public ResponseEntity<UserAuthResponse> authenticateUser(@Valid @RequestBody UserAuthRequest userAuthRequest) throws Exception{
        UserAuthResponse userAuthResponse = null;
        try {
            var email = userAuthRequest.email();
            var password = userAuthRequest.password();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            var jwtToken = jwtMgmtUtilityService.generateToken(email);
            var user = userService.getUserByEmail(email);
            if(user != null){
                userAuthResponse = new UserAuthResponse(jwtToken, user.getFirstName(), user.getLastName());
            }
        }catch (Exception e){
            System.out.println("User Authentication Exception: " + e);
            throw e;
        }
        return ResponseEntity.ok(userAuthResponse);
    }
}
