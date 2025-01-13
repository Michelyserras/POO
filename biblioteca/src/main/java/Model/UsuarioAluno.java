package Model;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class UsuarioAluno extends Usuario{
    private Date dtLimite;

    public UsuarioAluno(String nome, Date dtLimite){
        super(nome);
        this.dtLimite = dtLimite;
    }

    public boolean isRegular(){
        Date hoje = new Date();
        return(dtLimite.after(hoje));
    }

    public void renovaCartao(Date dt){
        dtLimite = dt;
    }
    
    public boolean IsARenovar(){
        return (!isRegular());
    }
    
    @Override
    public int getQtdMaxima(){
        return(isRegular() ? 3 : super.getQtdMaxima());
    }
    
    @Override
    public int getPrazoMaximo(){
        return(isRegular() ? 7 : super.getPrazoMaximo());
    }

    
}
