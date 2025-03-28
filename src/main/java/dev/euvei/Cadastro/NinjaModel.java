package dev.euvei.Cadastro;

import jakarta.persistence.*;

//@Entity -> transforma uma Classe em uma Entidade do Banco de Dados
@Entity
@Table(name = "tb_cadastro") //nomde da tabela inteira
public class NinjaModel {

    @Id // para o ID ser preenchido
    @GeneratedValue(strategy = GenerationType.IDENTITY) //passar uma estrategia de omo gerar a ordem sequencial do @Id
    private Long id; // nao vai fica no construtor
    private String nome;
    private int idade;
    private String email;

    public NinjaModel() {
    }

    public NinjaModel(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
