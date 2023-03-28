package com.quiz.quiz.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.quiz.entity.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
    
}
