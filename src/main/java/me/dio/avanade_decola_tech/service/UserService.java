package me.dio.avanade_decola_tech.service;

import me.dio.avanade_decola_tech.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);

}
