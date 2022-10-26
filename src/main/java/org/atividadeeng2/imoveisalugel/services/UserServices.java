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

    public User insertUserFromRepository(User user){
        return userRepository.save(user);
    }

    public void insertAllUsersIntoRepository(List<User> users){
         userRepository.saveAll(users);
    }

    public List<User> findAllUsersFromRepository(){
        return userRepository.findAll();
    }

    public User findUserByIdFromRepository(Long id){
       Optional<User> userToUpdate = userRepository.findById(id);
       return userToUpdate.orElseThrow(()-> new ResouceNotFoundException(id));

    }

    public User update(Long id, User userUpdated){
        User userToUpdate = userRepository.getReferenceById(id);
        updateData(userToUpdate,userUpdated);
        return userRepository.save(userToUpdate);
    }

    private void updateData(User userToUpdate, User userUpdated) {
        userToUpdate.setName(userUpdated.getName());
        userToUpdate.setEmail(userUpdated.getEmail());
        userToUpdate.setCpf(userUpdated.getCpf());
        userToUpdate.setDataNascimento(userUpdated.getDataNascimento());
        userToUpdate.setPhone(userToUpdate.getPhone());

    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public User findUserByName(String name){
        return userRepository.findByName(name);
    }


}
