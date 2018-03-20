package org.dougllas.mymoney.service;

import org.dougllas.mymoney.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

/**
 * Criado por dougllas.sousa em 14/03/2018.
 */
public interface UserService extends UserDetailsService {

    User cadastrarUsuario(User user);

    List<User> findAll();

    Optional<User> autenticarUsuario(String login, String senha);

    Optional<User> findUserById(Integer id);

}