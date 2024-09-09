package com.example.Junit_Mockito.service;

import com.example.Junit_Mockito.entity.User;
import com.example.Junit_Mockito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findUserByUsername(username);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User Not Found in Db");
        }
        return new UserPrincipal(user);
    }
}
