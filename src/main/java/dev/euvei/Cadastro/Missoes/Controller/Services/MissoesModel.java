package dev.euvei.Cadastro.Missoes.Controller.Services;

import dev.euvei.Cadastro.Ninjas.Controller.Services.NinjaModel;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "tb_missoes")
public class MissoesModel {
    //UMA MISSAO PODE RECEBER VARIOS NINJAS!

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //@GenereatedValue = gera o Id automaticamente
    private int Id;

    private String nome;

    private String dificuldade;

    private NinjaModel ninja; //acessar o ninja model

    @OneToMany(mappedBy = "missoes") //one missao - to - many ninjas
    private List<NinjaModel> ninjas;
}
