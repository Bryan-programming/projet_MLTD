package com.Exchange_application.BarterAndDonation.auth;

import com.Exchange_application.BarterAndDonation.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailServices implements UserDetailsService {

    private final UserRepository userRepository;
    public CustomUserDetailServices(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(CustomUserDetails::new).
                orElseThrow(() -> new UsernameNotFoundException(" User not found ")) ;
    }
}
