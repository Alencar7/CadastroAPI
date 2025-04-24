package dev.euvei.Cadastro.Missoes;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("missoes/ui")
public class MissoesControllerUI {

    private final MissoesService missoesService;

    public MissoesControllerUI(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // .../MISSOES/UI/LISTAR
    @GetMapping("/listar")
    public String listarMissoes(Model model){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "listarMissoes";
    }

    @GetMapping("/listar/{id}")
    public String listarMissoesPorId(@PathVariable Long id, Model model) {

        MissoesDTO missao = missoesService.listarMissoesPorId(id);

        if (missao != null) {
            model.addAttribute("missao", missao);
            return "detalhesMissao"; //pagina.html
        } else {
            model.addAttribute("mensagem", "Missão nao encontrada.");
            return "listarMissoes"; //redirecinando para listagem geral
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarMissao(Model model) {
        model.addAttribute("missao", new MissoesDTO());
        return "adicionarMissao";
    }

    @PostMapping("/salvar")
    public String salvarMissao(@ModelAttribute MissoesDTO missao, RedirectAttributes redirectAttributes) {
        missoesService.criarMissao(missao);
        redirectAttributes.addFlashAttribute("mensagem","Ninja cadastrado com sucesso!");
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/alterar/{id}")
    public String mostrarFormularioAlterar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        MissoesDTO missao = missoesService.listarMissoesPorId(id);
        if (missao != null) {
            model.addAttribute("missao", missao);
            return "alterarMissao"; // arquivo HTML com o formulário
        } else {
            redirectAttributes.addFlashAttribute("mensagem", "Missão não encontrada.");
            return "redirect:/missoes/ui/listar";
        }
    }

    @PostMapping("/alterar/{id}")
    public String alterarMissao(@PathVariable Long id, @ModelAttribute MissoesDTO missao, RedirectAttributes redirectAttributes) {

        MissoesDTO missaoAtualizada = missoesService.atualizarMissaoPorId(id, missao);
        if (missaoAtualizada != null) {
            redirectAttributes.addFlashAttribute("mensagem", "Missao alterada com sucesso!");
        } else {
            redirectAttributes.addFlashAttribute("mensagem", "Missao com ID: " + id + " não encontrada.");
        }
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMissoesPorId(@PathVariable Long id) {
        missoesService.deletarMissaoPorId(id);
        return "redirect:/missoes/ui/listar";
    }

}
