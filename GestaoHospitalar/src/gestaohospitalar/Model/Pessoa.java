/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Model;
public class Pessoa {
    private int contadorId  = 0;
    private int id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    public Pessoa(String nome, String cpf, String endereco, String telefone) {
        this.id = contadorId++;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getId(){
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public  void exibir(){
        System.out.println("Id          : " + id);
        System.out.println("Nome        : " + nome);
        System.out.println("CPF         : " + cpf);
        System.out.println("Endereco    : " + endereco);
        System.out.println("Telefone    : " + telefone);
    }
    
}
