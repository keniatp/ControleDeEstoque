package com.example.servicer;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;  // Injeção de dependência
import org.springframework.stereotype.Service;               // Define a classe como um Service do Spring

import com.example.cadastroprodutos.model.Saida;
import com.example.cadastroprodutos.repository.SaidaRepository;

/**
 * Anotação @Service indica que esta classe é um componente do Spring,
 * responsável por conter a lógica de negócio da aplicação.
 */
@Service
public class SaidaService {

    @Autowired
    private SaidaRepository repository;

    public List<Saida> listarTodos() {
        return repository.findAll();
    }

    public Optional<Saida> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Saida salvar(Saida Saida) {
        return repository.save(Saida);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
    

