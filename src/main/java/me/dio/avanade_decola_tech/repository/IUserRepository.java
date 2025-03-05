package me.dio.avanade_decola_tech.repository;

import me.dio.avanade_decola_tech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    boolean existsByAccountNumber(String accountNumber);
}
