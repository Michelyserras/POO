package Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Livro {
    @Id
    @GeneratedValue
    private Integer id;

    private String titulo;
    private Usuario retiradoPor;
    private Date dtEmprestimo;
    private Date dtDevolucao;
    private Usuario bloqueadoPor;
    private Date dtBloqueio;
    private Date dtDesbloqueio;

    public Livro(String nome){
        this.titulo = nome;
    }

    public Integer getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String nome){
        this.titulo = nome;
    }

    public Usuario getRetiradoPor(){
        return retiradoPor; 
    }

    public void setRetiradoPor(Usuario user){
        this.retiradoPor = user;
    }

    public Usuario getBloqueadoPor(){
        return bloqueadoPor; 
    }

    public void setBloqueadoPor(Usuario user){
        this.bloqueadoPor = user;
    }

    public Date getDtEmprestimo(){
        return dtEmprestimo; 
    }

    public void setDtEmprestimo(Date data){
        this.dtEmprestimo = data;
    }


    public Date getDtDevolucao(){
        return dtDevolucao; 
    }

    public void setDtDevolucao(Date data){
        this.dtDevolucao = data;
    }

    public Date getDtBloqueio(){
        return dtBloqueio; 
    }

    public void setDtBloqueio(Date data){
        this.dtBloqueio= data;
    }

    public Date getDtDesbloqueio(){
        return dtDesbloqueio; 
    }

    public void setDtDesbloqueio(Date data){
        this.dtDesbloqueio = data;
    }



    
}
