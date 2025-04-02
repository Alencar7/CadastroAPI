package dev.euvei.Cadastro.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController //mapear e mostrar que eh um NinjaController
@RequestMapping // anda junto ao RestCon
public class NinjaController {


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
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "mostrar ninjas!";
    }

    // Mostrar Ninja por ID (read)
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorID(){
        return "mostrar ninjas por id!";
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
