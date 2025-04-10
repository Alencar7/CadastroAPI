package dev.euvei.Cadastro.Missoes;

import dev.euvei.Cadastro.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// 1 - add notacoes
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    // 2 - clonar entidade
    private Long Id;
    private String nome;
    private String dificuldade;
    private List<NinjaModel> ninjas;

}
