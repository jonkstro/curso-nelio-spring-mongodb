package com.udemy.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.udemy.workshopmongo.model.Post;
import java.util.List;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    // Montar uma consulta de Query para buscar títulos que contem text
    List<Post> findByTitleContainingIgnoreCase(String text);
}
