package dev.euvei.Cadastro.Ninjas;

import dev.euvei.Cadastro.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity -> transforma uma Classe em uma Entidade do Banco de Dados
@Entity
@Table(name = "tb_cadastro") //nome da tabela inteira
@Data //lombok
@NoArgsConstructor //lombok
@AllArgsConstructor
public class NinjaModel {  // UM NINJA SO PODE RECEBER UMA MISSAO POR VEZ!

    @Id // para o ID ser preenchido
    @GeneratedValue(strategy = GenerationType.IDENTITY) //passar uma estrategia de omo gerar a ordem sequencial do @Id
    @Column (name = "id")
    private Long id; // nao vai fica no construtor

    @Column (name = "nome")
    private String nome;

    @Column(unique = true) //coluna unica -> CPF, RG, Passaporte
    private  String email;

    @Column (name = "img_url")
    private String imgUrl;

    @Column (name = "idade")
    private int idade;

    // @manytoone -> um ninja tem 1 unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") //juntar as colunas e add a missoes_id => chave estrangeira
    private MissoesModel missoes;
    //explicacao melhor na aula 17- como banco de dados funciona


}
