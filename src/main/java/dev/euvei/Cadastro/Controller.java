package dev.euvei.Cadastro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //mapear e mostrar que eh um Controller
@RequestMapping // anda junto ao RestCon
public class Controller {


    @GetMapping("/boasVindas") //Gep= pegar informacoes + (rota)
    public String boasVindas(){
        return "Essa e minha primeira mensagem!";
    }






}
