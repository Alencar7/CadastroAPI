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
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {

        List<MissoesDTO> missoes = missoesService.listarMissoes();

        return ResponseEntity.ok(missoes);
    }

    @GetMapping ("/listar/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id) {

        MissoesDTO missoesPorId = missoesService.listarMissoesPorId(id);

        if (missoesPorId != null) {
            return ResponseEntity.ok(missoesPorId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missao com ID: " + id + ", nao existe.");
        }
    }

    // PUT --> Mandar uma requisicao para alterar as missoes
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {

        MissoesDTO missao = missoesService.atualizarMissaoPorId(id, missaoAtualizada);

        if (missao != null) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missao com ID(" + id + ") não foi encontrada." );
        }
    }

    // DELETE --> Mandar uma requisicao para deletar as missoes
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {

       MissoesDTO missao = missoesService.listarMissoesPorId(id);

        if (missao != null) {
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missao com ID:" + id + " deletada!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missao com ID: " + id + " ,nao foi encontrada." );
        }
    }


}
