package dev.euvei.Cadastro.Missoes;

import dev.euvei.Cadastro.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel { //UMA MISSAO PODE RECEBER VARIOS NINJAS!

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //@GenereatedValue = gera o Id automaticamente
    private Long Id;

    private String nome;

    private String dificuldade;

    //private NinjaModel ninja; //acessar o ninja model

    @OneToMany(mappedBy = "missoes") //one missao - to - many ninjas
    private List<NinjaModel> ninjas;
}
