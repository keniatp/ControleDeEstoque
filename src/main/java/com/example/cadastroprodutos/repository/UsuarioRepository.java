package com.example.cadastroprodutos.repository;

// Importações necessárias para o Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository; // Interface que fornece métodos prontos para CRUD
import org.springframework.stereotype.Repository; // Anotação para identificar como um repositório

import com.example.cadastroprodutos.model.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}