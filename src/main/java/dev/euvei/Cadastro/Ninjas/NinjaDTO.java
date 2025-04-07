package dev.euvei.Cadastro.Ninjas;

import dev.euvei.Cadastro.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO  {

    //clone da entidade(NinjaModel)
    private Long id;
    private String nome;
    private  String email;
    private String imgUrl;
    private int idade;
    private MissoesModel missoes;
    private String rank;


}
