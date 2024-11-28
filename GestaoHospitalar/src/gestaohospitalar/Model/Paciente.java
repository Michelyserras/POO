/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Model;

public class Paciente {
    public String nome;
    public String identidade;
    public String dataNascimento;
    public String endereco;
    
     public Paciente(String nome, String identidade, String dataNascimento, String endereco) {
        this.nome = nome;
        this.identidade = identidade;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getIdentidade() {return identidade;}

    public void setIdentidade(String identidade) {this.identidade = identidade;}

    public String getDataNascimento() {return dataNascimento; }

    public void setDataNascimento(String dataNascimento) {this.dataNascimento = dataNascimento; }

    public String getEndereco() {return endereco;}

    public void setEndereco(String endereco) { this.endereco = endereco;}
     
    
}
