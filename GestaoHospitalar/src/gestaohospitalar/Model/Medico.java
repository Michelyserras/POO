package gestaohospitalar.Model;

public class Medico extends Pessoa {
    private String especialidade;
    private String crm;

    public Medico(String nome, String cpf, String endereco, String telefone, String especialidade, String crm) {
        super(nome, cpf, endereco, telefone);
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public void exibir(){
        super.exibir();
        System.out.println("CRM            : " + crm);
        System.out.println("Especilidade   : " + especialidade );
    }
    
    
}
