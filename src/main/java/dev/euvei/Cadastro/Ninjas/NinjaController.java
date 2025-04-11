package dev.euvei.Cadastro.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //mapear e mostrar que eh um NinjaController
@RequestMapping("/ninjas") // anda junto ao RestController
public class NinjaController {

    //injecao de dependencias
    final private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas") //Gep= pegar informacoes + (rota)
    public String boasVindas() {
        return "Essa e minha primeira mensagem!";
    }

    //(CRUD)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) { //@RequestBody => corpo da requisicao, ele vai mandar um JSON igual ao do DB

        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso!" +
                        "\nNome: " + novoNinja.getNome() + "Id: " + novoNinja.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>>  listarNinjas() {

        List<NinjaDTO> ninjas =  ninjaService.listarNinjas();

        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) { //@pathvariable = caminho da variavel

        NinjaDTO ninjasPorId = ninjaService.listarNinjasPorId(id);

        if (ninjasPorId != null) {
            return ResponseEntity.ok(ninjasPorId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O Ninja com ID: " + id + ", nao existe no registro.");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjasPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {

        NinjaDTO ninja = ninjaService.atualizarNinjaPorId(id, ninjaAtualizado);

        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O Ninja com ID: " + id + ", nao existe no registro.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjasPorId(@PathVariable Long id) { //@PathVariable = tipo um scann para jogar dentro da url

        NinjaDTO ninja =  ninjaService.listarNinjasPorId(id);

        if (ninja != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com ID: " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O Ninja com ID: " + id + ", nao foi encontrado.");
        }
    }

}
