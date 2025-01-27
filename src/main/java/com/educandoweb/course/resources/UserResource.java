package com.educandoweb.course.resources;


import com.educandoweb.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //recurso web
@RequestMapping(value = "/users")//nome para o meu recurso
public class UserResource {

    //metodo endpoint para acessar os usuarios
    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L,"Maria","maria@gmail.com","999999","12345");
        return ResponseEntity.ok().body(u); //para retorna a resposta com sucesso
    }
}
