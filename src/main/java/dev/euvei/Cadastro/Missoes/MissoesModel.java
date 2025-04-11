package dev.euvei.Cadastro.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.euvei.Cadastro.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString //ui
public class MissoesModel { //UMA MISSAO PODE RECEBER VARIOS NINJAS!

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //@GenereatedValue = gera o Id automaticamente
    private Long Id;

    private String nome;

    private String dificuldade;

    @OneToMany(mappedBy = "missoes") //one missao - to - many ninjas
    @JsonIgnore // essa @Anotation evita o loop de serializacao
    private List<NinjaModel> ninjas;
}
