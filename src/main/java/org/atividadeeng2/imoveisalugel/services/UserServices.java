package org.atividadeeng2.imoveisalugel.services;


import org.atividadeeng2.imoveisalugel.entities.User;
import org.atividadeeng2.imoveisalugel.repositories.UserRepository;
import org.atividadeeng2.imoveisalugel.services.exceptions.ResouceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public void insertUserFromRepository(User user){
        userRepository.save(user);
    }

    public List<User> findAllUsersFromRepository(){
        return userRepository.findAll();
    }

    public User findUserByIdFromRepository(Long id){
       Optional<User> userFounded = userRepository.findById(id);
       return userFounded.orElseThrow(()-> new ResouceNotFoundException(id));

    }



}
