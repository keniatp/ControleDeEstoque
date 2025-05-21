package com.example.servicer;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;  // Injeção de dependência
import org.springframework.stereotype.Service;               // Define a classe como um Service do Spring

import com.example.cadastroprodutos.model.Produto;
import com.example.cadastroprodutos.repository.ProdutoRepository;

    

/**
 * Anotação @Service indica que esta classe é um componente do Spring,
 * responsável por conter a lógica de negócio da aplicação.
 */
@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Produto> buscarPorId(Integer id) {
        // Chama o método findById() do repository para buscar o produto pelo ID
        return repository.findById(id);
    }

    public Produto salvar(Produto Produto) {
        return repository.save(Produto);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
    


