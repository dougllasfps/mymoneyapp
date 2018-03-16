package org.dougllas.mymoney.model.dto;

import org.dougllas.mymoney.model.User;
import org.dougllas.mymoney.validation.FieldMatch;

import javax.validation.constraints.NotNull;

/**
 * Criado por dougllas.sousa em 14/03/2018.
 */

@FieldMatch(first = "password", second = "passwordMatch", message = "Senhas não conferem.")
public class UserDTO {

    private Integer id;

    private String nome;

    @NotNull(message = "Campo login é obrigatório.")
    private String username;

    @NotNull(message = "Campo senha é obrigatório.")
    private String password;

    private String passwordMatch;

    private boolean authenticated;

    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getPasswordMatch() {
        return passwordMatch;
    }

    public void setPasswordMatch(String passwordMatch) {
        this.passwordMatch = passwordMatch;
    }

    public static UserDTO entityToDto(User user){
        UserDTO dto = new UserDTO();
        dto.setPassword(user.getPassword());
        dto.setUsername(user.getUsername());
        dto.setAuthenticated(user.getId() != null);
        dto.setId(user.getId());
        dto.setNome(user.getNome());
        return dto;
    }

    public static User toEntity(UserDTO dto){
        User user = new User();
        user.setPassword(dto.getPassword());
        user.setUsername(dto.getUsername());
        user.setId(dto.getId());
        user.setNome(dto.getNome());
        return user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}