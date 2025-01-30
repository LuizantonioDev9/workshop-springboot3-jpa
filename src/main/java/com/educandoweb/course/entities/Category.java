package com.educandoweb.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_categories")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore //o jackson fica criando o loop infinito
    //não vai gerar outra tabela pois ja temos uma tabela chamada categories
    //o spring entende que pelo mappedBy o products não vai gerar uma nova tabela
    //por que nós ja temos uma tabela predefinida para ser criada que está lá em product
    @ManyToMany(mappedBy = "categories") //mappedby é usado no lado inverso da conexão ou seja na outra tabela
    private Set<Product> products = new HashSet<>();

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
