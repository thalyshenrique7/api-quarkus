package com.devthalys.services;

import com.devthalys.models.UserModel;
import com.devthalys.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public List<UserModel> findAll(){
        return userRepository.findAll().list();
    }

    public UserModel findById(Long id){
        return userRepository.findById(id);
    }

    public void save(UserModel user){
        userRepository.persist(user);
    }

    public void delete(UserModel user){
        userRepository.delete(user);
    }
}
