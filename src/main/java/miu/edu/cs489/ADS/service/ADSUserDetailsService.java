package miu.edu.cs489.ADS.service;

import miu.edu.cs489.ADS.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ADSUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public ADSUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("Email is not found for " + email));
    }
}
