package org.dougllas.mymoney.api.controller;

import org.dougllas.mymoney.api.Response;
import org.dougllas.mymoney.generic.ErrorHandler;
import org.dougllas.mymoney.model.User;
import org.dougllas.mymoney.model.dto.UserDTO;
import org.dougllas.mymoney.security.JwtTokenService;
import org.dougllas.mymoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Criado por dougllas.sousa em 14/03/2018.
 */

@RestController
@RequestMapping("/api/users")
public class UserController implements Serializable, ErrorHandler {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenService tokenService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/auth")
    public ResponseEntity<Response> login(
            @RequestParam("username") String login,
            @RequestParam("password") String pass  ){

        Optional<User> user = userService.autenticarUsuario(login, pass);

        Response response = new Response();

        if(user.isPresent()){
            UserDTO userDTO = UserDTO.entityToDto(user.get());
            userDTO.setToken(tokenService.obterToken(user.get()));
            response.setData(userDTO);
            return ResponseEntity.ok(response);
        }

        response.getErrors().add("Usuário e/ou senha não conferem.");

        return new ResponseEntity(response, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/signup")
    public ResponseEntity<Response> cadastro(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult){

        Response response = new Response();

        if(bindingResult.hasErrors()){
            handleErrors(bindingResult, response);
            return ResponseEntity.badRequest().body(response);
        }

        User user = UserDTO.toEntity(userDTO);
        userService.cadastrarUsuario(user);
        userDTO = UserDTO.entityToDto(user);
        userDTO.setAuthenticated(true);
        userDTO.setToken(tokenService.obterToken(user));
        response.setData(userDTO);

        return ResponseEntity.ok(response);
    }
}
