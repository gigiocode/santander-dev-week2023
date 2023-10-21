package gigio.dev.santanderdevweek2023.service.Impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;


import gigio.dev.santanderdevweek2023.domain.model.User;
import gigio.dev.santanderdevweek2023.domain.repository.UserRepository;
import gigio.dev.santanderdevweek2023.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}