package net.elyland.cloud.services;

import net.elyland.cloud.domain.Role;
import net.elyland.cloud.domain.User;
import net.elyland.cloud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Igor on 29-Jun-16.
 */
@Service
@ComponentScan(basePackages = {
        "net.elyland.cloud.controllers",
        "net.elyland.cloud.domain",
        "net.elyland.cloud.repositories",
        "net.elyland.cloud.services",
        "net.elyland.cloud.validator" })
public class UserDetailsServiceImpl implements UserDetailsService {
   @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userRepository.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("Username does not exist");
            }
        } catch (Exception e){
            throw new UsernameNotFoundException("Username does not exist");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Role role = user.getRole();
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        System.out.println(grantedAuthorities.toString());

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
