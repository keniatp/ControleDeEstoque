package com.example.cadastroprodutos.servicer;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;  // Injeção de dependência
import org.springframework.stereotype.Service;               // Define a classe como um Service do Spring

import com.example.cadastroprodutos.model.Usuario;
import com.example.cadastroprodutos.repository.UsuarioRepository;

  

/**
 * Anotação @Service indica que esta classe é um componente do Spring,
 * responsável por conter a lógica de negócio da aplicação.
 */
@Service
public class UsuarioService {

    /**
     * Injeção de dependência do repositório.
     * O Spring automaticamente instancia o objeto e gerencia o ciclo de vida dele.
     */
    @Autowired
    private UsuarioRepository repository;

    /**
     * Método responsável por listar todas as pessoas cadastradas.
     * @return Lista com todas as pessoas do banco de dados.
     */
    public List<Usuario> listarTodos() {
        // Chama o método findAll() do repository para buscar todas as pessoas
        return repository.findAll();
    }

    /**
     * Método responsável por buscar uma pessoa específica pelo ID.
     * @param id Identificador da pessoa.
     * @return Um Optional contendo a pessoa encontrada, ou vazio se não encontrar.
     */
    public Optional<Usuario> buscarPorId(Integer id) {
        // Chama o método findById() do repository para buscar a pessoa pelo ID
        return repository.findById(id);
    }

    /**
     * Método responsável por salvar ou atualizar uma pessoa no banco de dados.
     * @param Usuario da entidade PessoasModel contendo os dados.
     * @return A entidade salva ou atualizada.
     */
    public Usuario salvar(Usuario Usuario) {
        // Chama o método save() do repository para salvar os dados no banco
        return repository.save(Usuario);
    }

    /**
     * Método responsável por deletar uma pessoa do banco de dados.
     * @param id Identificador da pessoa a ser deletada.
     */
    public void deletar(Integer id) {
        // Chama o método deleteById() do repository para remover o registro
        repository.deleteById(id);
    }
}
    

