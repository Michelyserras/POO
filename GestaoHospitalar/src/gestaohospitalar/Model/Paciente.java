/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Model;

public class Paciente extends Pessoa {
    public String nomeConvenio;
    public String numeroConvenio;

    public Paciente(String nomeConvenio, String numeroConvenio, int id, String nome, String cpf, String endereco, String telefone) {
        super(nome, cpf, endereco, telefone);
        this.nomeConvenio = nomeConvenio;
        this.numeroConvenio = numeroConvenio;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public String getNumeroConvenio() {
        return numeroConvenio;
    }

    public void setNumeroConvenio(String numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }
    
    @Override
    public void exibir(){
        super.exibir();
        System.out.println("Nome do convenio   : " + nomeConvenio);
        System.out.println("Numero do convenio : " + numeroConvenio);
    }
   

  
    
}
