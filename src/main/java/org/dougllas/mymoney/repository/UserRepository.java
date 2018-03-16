package org.dougllas.mymoney.repository;

import org.dougllas.mymoney.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Criado por dougllas.sousa em 14/03/2018.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
