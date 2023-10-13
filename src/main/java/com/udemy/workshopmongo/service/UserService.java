package com.udemy.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.workshopmongo.model.User;
import com.udemy.workshopmongo.repository.UserRepository;
import com.udemy.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        // Se não achar o user vai dar exceção personalizada
        return user.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
