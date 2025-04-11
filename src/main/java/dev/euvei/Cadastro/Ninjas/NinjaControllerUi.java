package dev.euvei.Cadastro.Ninjas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("ninjas/ui")
public class NinjaControllerUi {

    //injecao de dependencias
    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //LOCALHOST:8080/NINJAS/UI/LISTAR
    @GetMapping("/listar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjas =  ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas"; //tem que retornar o nome da pagina.html que renderiza
    }

    @GetMapping("/deletar/{id}")
    public String deletarNinjasPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarNinjasPorId(@PathVariable Long id, Model model) {

        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);

        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "detalhesNinja"; //pagina.html
        } else {
            model.addAttribute("mensagem", "Ninja nao encontrado.");
            return "listarNinjas"; //redirecinando para listagem geral
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarNinja";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.criarNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem","Ninja cadastrado com sucesso!");
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/alterar/{id}")
    public String mostrarFormularioAlterar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "alterarNinja"; // arquivo HTML com o formulário
        } else {
            redirectAttributes.addFlashAttribute("mensagem", "Ninja não encontrado.");
            return "redirect:/ninjas/ui/listar";
        }
    }

    @PostMapping("/alterar/{id}")
    public String alterarNinja(@PathVariable Long id, @ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        NinjaDTO ninjaAtualizado = ninjaService.atualizarNinjaPorId(id, ninja);
        if (ninjaAtualizado != null) {
            redirectAttributes.addFlashAttribute("mensagem", "Ninja alterado com sucesso!");
        } else {
            redirectAttributes.addFlashAttribute("mensagem", "Ninja com ID: " + id + " não encontrado.");
        }
        return "redirect:/ninjas/ui/listar";
    }


}
