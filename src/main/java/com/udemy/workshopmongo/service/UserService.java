package com.udemy.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.workshopmongo.dto.UserDTO;
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

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public void delete(String id) {
        // Vai buscar o ID primeiro, se não achar já lança exceção
        findById(id);
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}
