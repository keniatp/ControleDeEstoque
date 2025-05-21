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
import com.example.cadastroprodutos.repository.ProdutoRepository;
import com.example.servicer.ProdutoService;
@RestController
@RequestMapping("/api/cadastroprodutos")
public class ProdutoController {
    
}
