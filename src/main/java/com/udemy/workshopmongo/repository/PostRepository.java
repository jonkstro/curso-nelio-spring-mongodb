package com.udemy.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.udemy.workshopmongo.model.Post;
import java.util.List;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    // Montar uma consulta de Query para buscar títulos que contem text
    List<Post> findByTitleContainingIgnoreCase(String text);


     
    /* Montar uma consulta customizável com regex para usar no mongodb:
     * Exemplo de consulta no mongo db pra achar itens entre 2 datas:
     * {date: 
     * {
     * $gte: new Date("2023-10-10T00:00:00.000+00:00"), 
     * $lte: new Date("2023-10-19T00:00:00.000+00:00")
     * }}
     */
    // O 0 após o regex quer dizer que é o primeiro parâmetro
    // o 'i' quer dizer que vai ignorar maiusculo ou minusculo
    @Query("{ 'title': {$regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);
}
