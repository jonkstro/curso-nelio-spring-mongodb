package com.udemy.workshopmongo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.workshopmongo.model.Post;
import com.udemy.workshopmongo.repository.PostRepository;
import com.udemy.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        // Se não achar o Post vai dar exceção personalizada
        Post post = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return post;
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        // Vai ser adicionado 24 horas, pois sempre o Date vem 0h, ao invés de 24h
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }

}
