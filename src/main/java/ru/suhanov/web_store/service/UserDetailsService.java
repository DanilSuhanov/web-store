package ru.suhanov.web_store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.suhanov.web_store.exception.DatabaseException;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return userService.findUserByUsername(username);
        } catch (DatabaseException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
