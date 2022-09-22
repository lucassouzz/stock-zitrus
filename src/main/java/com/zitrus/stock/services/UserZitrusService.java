package com.zitrus.stock.services;

import com.zitrus.stock.entities.UserZitrus;
import com.zitrus.stock.repositories.UserZitrusRepository;
import com.zitrus.stock.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserZitrusService {

    @Autowired
    private UserZitrusRepository repository;
    @Autowired
    private TokenService tokenService;

    public String login(UserZitrus user) {
        UserZitrus resultUser = repository.findById(user.getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Usuário nao encontrado id: " + user.getId()));

        String token = null;
        if (user.getEmail().equals(resultUser.getEmail()) &&
                resultUser.getPassword().equals(user.getPassword())) {
            token = tokenService.getToken(user);
        } else {
            token = "Credenciais invalidas, verifique os dados e tente novamente.";
        }
        return token;
    }

}
