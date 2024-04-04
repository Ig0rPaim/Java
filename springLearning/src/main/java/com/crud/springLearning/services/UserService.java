package com.crud.springLearning.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crud.springLearning.DTOs.UserDTO;
import com.crud.springLearning.models.User;
import com.crud.springLearning.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<UserDTO> saveUser(UserDTO userDTO){
        try{
            User user =  new User(userDTO);
            userRepository.save(user);
            return ResponseEntity.created(location(user)).body(null);
        }catch(Exception  e){
            return ResponseEntity.badRequest().build(); 
        }
    }

    public ResponseEntity<UserDTO> deleteById(Long id){
        try{
            var user = userRepository.findById(id);
            if(!user.isPresent())
                return ResponseEntity.notFound().build();
            userRepository.delete(user.get());
            return ResponseEntity.ok().body(new UserDTO(user.get()));
        }catch(Exception e){
            return ResponseEntity.badRequest().build(); 
        }
    }

    public ResponseEntity<UserDTO> update(UserDTO userDTO){
        try{
            var user = userRepository.findById(userDTO.id());
            if(!user.isPresent())
                return ResponseEntity.notFound().build();
            var updateUser = user.get();
            updateUser.setLogin(updateUser.getLogin());
            updateUser.setPassword(updateUser.getPassword());
            updateUser.setName(updateUser.getName());
            return ResponseEntity.ok().body(new UserDTO(updateUser));
        }catch(Exception e){
            return ResponseEntity.badRequest().build(); 
        }
    }

    public ResponseEntity<List<UserDTO>> getAll(){
        try{
            var users = userRepository.findAll();
            var userDTO = users.stream().map(UserDTO::new).toList();
            return ResponseEntity.ok().body(userDTO);
        }catch(Exception e){
            return ResponseEntity.badRequest().build(); 
        }
    }

    private URI location(User user){
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(user.getId()).toUri();
    }
}
