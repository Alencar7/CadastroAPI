package dev.euvei.Cadastro.Ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //mapear e mostrar que eh um NinjaController
@RequestMapping // anda junto ao RestCon
public class NinjaController {


    @GetMapping("/boasVindas") //Gep= pegar informacoes + (rota)
    public String boasVindas(){
        return "Essa e minha primeira mensagem!";
    }

}
