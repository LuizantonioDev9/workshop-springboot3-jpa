package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id); //o optinal evitar o obj de retorna null, caso não ache nada ele retorna o vazio
        return obj.get();//o get vai retorna o objeto do tipo user que estiver dentro do meu optional
    }

    public User insert(User obj) {
        return repository.save(obj);
    }
}
