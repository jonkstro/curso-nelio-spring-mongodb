package com.udemy.workshopmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.workshopmongo.controller.util.URL;
import com.udemy.workshopmongo.model.Post;
import com.udemy.workshopmongo.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
    
    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    /*
     * Como agora a URL será: localhost:8080/titlesearch?text=XPTO
     * não usaremos @PathVariable, mas sim @RequestParam
     */
    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        // TODO: Implementar a busca sem diferenciar Upper e Lower case.
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }


}
