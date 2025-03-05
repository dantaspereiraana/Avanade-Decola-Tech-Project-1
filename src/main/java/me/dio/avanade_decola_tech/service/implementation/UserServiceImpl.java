package me.dio.avanade_decola_tech.service.implementation;

import me.dio.avanade_decola_tech.model.User;
import me.dio.avanade_decola_tech.repository.IUserRepository;
import me.dio.avanade_decola_tech.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
   private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This user ID already exists");
        }
        return userRepository.save(userToCreate);
    }
}
