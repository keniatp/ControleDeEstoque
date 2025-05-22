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
import com.example.cadastroprodutos.model.Produto;
import com.example.cadastroprodutos.model.Saida;
import com.example.cadastroprodutos.repository.ProdutoRepository;
import com.example.cadastroprodutos.repository.SaidaRepository;
import com.example.cadastroprodutos.servicer.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    private final ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoService produto;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<Produto> listarTodos() {
        // Chama o método findAll() do repository para buscar todos os produtos
        return produto.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {
        // Busca a pessoa pelo ID, se encontrar, retorna 200 (OK), se não, retorna 404 (Not Found)
        return produto.buscarPorId(id)
                     .map(ResponseEntity::ok) // Converte o resultado em ResponseEntity com status 200
                     .orElse(ResponseEntity.notFound().build()); // Retorna 404 se não encontrar
    }
      
     @PostMapping
    public Produto salvar(@RequestBody Produto salvarProduto) {
        // Chama o método de salvar do service e retorna o objeto persistido
        return produto.salvar(salvarProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Integer id, @RequestBody Produto idProduto) {
        // Verifica se o ID existe no banco de dados
        if (!produto.buscarPorId(id).isPresent()) {
            // Se não encontrar, retorna 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    
        idProduto.setId(id);
        // Salva o objeto atualizado e retorna 200 (OK)
        return ResponseEntity.ok(produto.salvar(idProduto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        // Verifica se o ID existe no banco de dados
        if (!produto.buscarPorId(id).isPresent()) {
            // Se não encontrar, retorna 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
        // Se encontrar, chama o método para deletar
        produto.deletar(id);
        // Retorna 204 (No Content), que significa que foi deletado com sucesso, mas sem conteúdo
        return ResponseEntity.noContent().build();
    }

}
