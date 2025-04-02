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
    public String criarNinja(){
        return "ninja criado!";
    }

    // Mostrar todos os Ninjas (read)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // Mostrar Ninja por ID (read)
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorID(){
        return "listar ninjas por id!";
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
