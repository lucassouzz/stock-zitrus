package com.zitrus.stock.controllers;

import com.zitrus.stock.entities.UserZitrus;
import com.zitrus.stock.services.UserZitrusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserZitrusController {

    @Autowired
    private UserZitrusService service;

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody UserZitrus user) {
        return ResponseEntity.ok().body(service.login(user));
    }
}
