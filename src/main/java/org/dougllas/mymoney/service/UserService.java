package org.dougllas.mymoney.service;

import org.dougllas.mymoney.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

/**
 * Criado por dougllas.sousa em 14/03/2018.
 */
public interface UserService extends UserDetailsService {

    User cadastrarUsuario(User user);

    Optional<User> autenticarUsuario(String login, String senha);
}
