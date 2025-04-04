package dev.euvei.Cadastro.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //mapear e mostrar que eh um NinjaController
@RequestMapping("/ninjas") // anda junto ao RestController
public class NinjaController {

    //injecao de dependencias
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas") //Gep= pegar informacoes + (rota)
    public String boasVindas(){
        return "Essa e minha primeira mensagem!";
    }
    //(CRUD)

    // Adicionar Ninja (create)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){ //@RequestBody => corpo da requisicao, ele vai mandar um JSON igual ao do DB
        return ninjaService.criarNinja(ninja); // JSON(caracteristicas da tabela) -> serializacao -> DB
    }

    // Mostrar todos os Ninjas (read)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // Mostrar Ninjas por ID (read)
    @GetMapping("/listar/{id}")   //localhost:8080/ninjas/listar/{id} = var do caminho
    public NinjaModel listarNinjasPorId(@PathVariable Long id){        //@pathvariable = caminho da variavel
        return ninjaService.listarNinjasPorId(id);
    }

    // Alterar dados dos ninjas (update)
    @PutMapping("/alterarID")
    public String alterarNinjasPorID(){
        return "alterar ninjas por id!";
    }

    // Deletar Ninja (delete)
    @DeleteMapping("/deletar")
    public String deletarNinjas(){
        return "ninja deletado por ID";
    }




}
