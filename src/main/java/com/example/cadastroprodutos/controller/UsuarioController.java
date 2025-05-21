package com.example.cadastroprodutos.controller;
// Importações necessárias
import java.util.List; // Para lidar com listas de objetos
import org.springframework.beans.factory.annotation.Autowired; // Injeção de dependência
import org.springframework.http.ResponseEntity; // Representa respostas HTTP
import org.springframework.web.bind.annotation.DeleteMapping; // Mapeia requisições DELETE
import org.springframework.web.bind.annotation.GetMapping; // Mapeia requisições GET
import org.springframework.web.bind.annotation.PathVariable; // Captura parâmetros da URL
import org.springframework.web.bind.annotation.PostMapping; // Mapeia requisições POST
import org.springframework.web.bind.annotation.PutMapping; // Mapeia requisições PUT
import org.springframework.web.bind.annotation.RequestBody; // Indica que o corpo da requisição é o objeto
import org.springframework.web.bind.annotation.RequestMapping; // Mapeia o caminho base da API
import org.springframework.web.bind.annotation.RestController; // Indica que esta classe é um Controller REST
import com.example.cadastroprodutos.CadastroprodutosApplication;
import com.example.cadastroprodutos.model.Usuario;
import com.example.cadastroprodutos.repository.UsuarioRepository;
import com.example.servicer.UsuarioService;
@RestController
@RequestMapping("/api/cadastroprodutos")

public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuario;


    UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }



    @GetMapping
    public List<Usuario> listarTodos() {
        // Chama o método findAll() do repository para buscar todas as pessoas
        return usuario.listarTodos();
    }

        @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id) {
        // Busca a pessoa pelo ID, se encontrar, retorna 200 (OK), se não, retorna 404 (Not Found)
        return usuario.buscarPorId(id)
                     .map(ResponseEntity::ok) // Converte o resultado em ResponseEntity com status 200
                     .orElse(ResponseEntity.notFound().build()); // Retorna 404 se não encontrar
    }
      
     @PostMapping
    public   Usuario salvar(@RequestBody Usuario usu) {
        // Chama o método de salvar do service e retorna o objeto persistido
        return usuario.salvar(usu);
    }
     @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Integer id, @RequestBody Usuario usu) {
        // Verifica se o ID existe no banco de dados
        if (!usuario.buscarPorId(id).isPresent()) {
            // Se não encontrar, retorna 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    
        usu.setId(id);
        // Salva o objeto atualizado e retorna 200 (OK)
        return ResponseEntity.ok(usuario.salvar(usu));


    }

    /**
     * Método DELETE para excluir uma pessoa do banco de dados.
     * URL: /api/pessoas/{id}
     * Método HTTP: DELETE
     * Parâmetro: ID da pessoa a ser excluída
     * Retorno: ResponseEntity com status 204 (No Content) ou 404 (Not Found) se não encontrar
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        // Verifica se o ID existe no banco de dados
        if (!usuario.buscarPorId(id).isPresent()) {
            // Se não encontrar, retorna 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
        // Se encontrar, chama o método para deletar
        usuario.deletar(id);
        // Retorna 204 (No Content), que significa que foi deletado com sucesso, mas sem conteúdo
        return ResponseEntity.noContent().build();
    }
}
