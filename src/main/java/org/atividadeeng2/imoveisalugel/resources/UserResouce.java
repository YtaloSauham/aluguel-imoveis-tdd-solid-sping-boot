package org.atividadeeng2.imoveisalugel.resources;


import org.atividadeeng2.imoveisalugel.entities.User;
import org.atividadeeng2.imoveisalugel.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")

public class UserResouce {

    @Autowired
    private UserServices userServices;

    @GetMapping

    public ResponseEntity<List<User>> findAllUsers(){
        List<User> listUserFromRepository = userServices.findAllUsersFromRepository();
        return ResponseEntity.ok().body(listUserFromRepository);
    }

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User user){
        user = userServices.insertUserFromRepository(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uri).body(user);


    }


}
