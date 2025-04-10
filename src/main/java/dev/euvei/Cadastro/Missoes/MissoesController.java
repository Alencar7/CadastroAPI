package dev.euvei.Cadastro.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// localhost:8080/
@RestController
@RequestMapping("/missoes")
public class MissoesController {

    //2. injecao de dependencias
    private MissoesService missoesService;

    //3. construtor
    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // POST --> Mandar uma requisicao para criar as missoes
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao) {
        MissoesDTO novaMissao = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao criada com sucesso!" +
                        "\nNome: " + novaMissao.getNome() + "Id: " + novaMissao.getId());
    }

    // GET --> Mandar uma requisicao para mostrar as missoes
    @GetMapping("/listar")
    public List<MissoesDTO> listarMissoes() {
        return missoesService.listarMissoes();
    }

    @GetMapping ("/listar/{id}")
    public MissoesDTO listarMissaoPorId(@PathVariable Long id) {
        return missoesService.listarMissoesPorId(id);
    }

    // PUT --> Mandar uma requisicao para alterar as missoes
    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        return missoesService.atualizarMissaoPorId(id, missaoAtualizada);
    }

    // DELETE --> Mandar uma requisicao para deletar as missoes
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {
        if (missoesService.listarMissoesPorId(id) != null) {
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missao com ID:" + id + " deletada!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missao com ID: " + id + " ,nao foi encontrada." );
        }

    }


}
