package ru.suhanov.web_store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.suhanov.web_store.exception.DatabaseException;
import ru.suhanov.web_store.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserDetails findUserByUsername(String username) throws DatabaseException {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new DatabaseException("Не удалось найти пользователя с таким именем!"));
    }
}