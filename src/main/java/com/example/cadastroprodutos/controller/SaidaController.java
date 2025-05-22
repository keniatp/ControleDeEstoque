package com.example.cadastroprodutos.controller;
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
import com.example.cadastroprodutos.model.Saida;
import com.example.cadastroprodutos.repository.SaidaRepository;
import com.example.cadastroprodutos.servicer.SaidaService;

@RestController
@RequestMapping("/api/saida")
public class SaidaController {
    private final SaidaRepository saidaRepository;
    @Autowired
    private SaidaService saida;

    public SaidaController(SaidaRepository saidaRepository) {
        this.saidaRepository = saidaRepository;
    }

    @GetMapping
    public List<Saida> listarTodos() {
        // Chama o método findAll() do repository para buscar todas as saidas
        return saida.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Saida> buscarPorId(@PathVariable Integer id) {
        // Busca a pessoa pelo ID, se encontrar, retorna 200 (OK), se não, retorna 404 (Not Found)
        return saida.buscarPorId(id)
                     .map(ResponseEntity::ok) // Converte o resultado em ResponseEntity com status 200
                     .orElse(ResponseEntity.notFound().build()); // Retorna 404 se não encontrar
    }
      
     @PostMapping
    public   Saida salvar(@RequestBody Saida salvarSaida) {
        // Chama o método de salvar do service e retorna o objeto persistido
        return saida.salvar(salvarSaida);
    }
     @PutMapping("/{id}")
    public ResponseEntity<Saida> atualizar(@PathVariable Integer id, @RequestBody Saida idSaida) {
        // Verifica se o ID existe no banco de dados
        if (!saida.buscarPorId(id).isPresent()) {
            // Se não encontrar, retorna 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    
        idSaida.setId(id);
        // Salva o objeto atualizado e retorna 200 (OK)
        return ResponseEntity.ok(saida.salvar(idSaida));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        // Verifica se o ID existe no banco de dados
        if (!saida.buscarPorId(id).isPresent()) {
            // Se não encontrar, retorna 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
        // Se encontrar, chama o método para deletar
        saida.deletar(id);
        // Retorna 204 (No Content), que significa que foi deletado com sucesso, mas sem conteúdo
        return ResponseEntity.noContent().build();
    }
}



    
    

