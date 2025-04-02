package dev.euvei.Cadastro.Missoes;

import org.springframework.web.bind.annotation.*;

// localhost:8080/
@RestController
@RequestMapping("missoes") // rota criada
public class MissoesController {

    // GET --> Mandar uma requisicao para mostrar as missoes
    @GetMapping("/listar")
    public String listarMissao() {
        return "missoes listadas!";
    }

    // POST --> Mandar uma requisicao para criar as missoes
    @PostMapping("/criar")
    public String criarMissao() {
        return "missao criada!";
    }

    // PUT --> Mandar uma requisicao para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "missao alterada!";
    }

    // DELETE --> Mandar uma requisicao para deletar as missoes
    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "missao deletada!";
    }


}
