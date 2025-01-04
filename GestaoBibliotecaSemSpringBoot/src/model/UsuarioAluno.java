/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class UsuarioAluno extends Usuario {

    private Date dataLimite;
    
    public UsuarioAluno(String nome, Date dt) {
        super(nome);
        this.dataLimite = dt;
    }
    
    public void renovaCartao(Date dt){
        dataLimite = dt;
    }
    
    public boolean isRegular(){
        Date hoje = new Date();
        return(dataLimite.after(hoje));
    }
    
    public boolean IsARenovar(){
        return (!isRegular());
    }
    
    @Override
    public int getCotaMaxima(){
        return(isRegular() ? 3 : super.getCotaMaxima());
    }
    
    @Override
    public int getPrazoMaximo(){
        return(isRegular() ? 7 : super.getPrazoMaximo());
    }
    
    @Override
    public String toString(){
        return("Aluno: " + getNome());
    }
    
}
