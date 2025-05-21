package com.example.servicer;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;  // Injeção de dependência
import org.springframework.stereotype.Service;               // Define a classe como um Service do Spring

import com.example.cadastroprodutos.model.Usuario;
import com.example.cadastroprodutos.repository.UsuarioRepository;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }
    public Optional<Usuario> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Usuario salvar(Usuario Usuario) {
        return repository.save(Usuario);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
    

