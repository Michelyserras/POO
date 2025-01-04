/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Livro {
    private String titulo;
    private Usuario retiradoPor;
    private Date dtEmprestimo;
    private Date dtDevolucao;
    private Usuario bloqueadoPor;
    private Date dtBloqueio;
    private Date dtDesbloqueio;
    
    public Livro(String tit){
        this.titulo = tit;
    }
    
    public boolean isDisponivel(){
        Date hoje = new Date();
        return(retiradoPor == null &&
                (bloqueadoPor == null || 
                dtDesbloqueio.before(hoje)));
        
    }
    
    public boolean isEmprestado(){
        return(!(retiradoPor == null));
        
    }
    
    public boolean isEmAtraso(){
        Date hoje = new Date();
        return(isEmprestado() && dtDevolucao.before(hoje));
    }
    
    public boolean isBloqueado(){
        Date hoje =  new Date();
        return(retiradoPor == null &&
                !(bloqueadoPor == null) &&
                !(dtDesbloqueio.before(hoje)));
    }
    
    public boolean bloqueia(Usuario u, int prazo){
        GregorianCalendar cal = new GregorianCalendar();
        if(isDisponivel() && u.isProfessor()){
            bloqueadoPor = u;
            dtBloqueio = cal.getTime();
            cal.add(Calendar.DATE, (prazo > 20 ? 20 : prazo));
            dtDesbloqueio = cal.getTime();
            return (true);
        } else{
        return false;
        }
    }
    
    public boolean desbloqueia(Usuario u){
        if(u == bloqueadoPor){
            bloqueadoPor = null;
            return(true);
        }
        else return (false);
    }
    
    public boolean empresta(Usuario u, int prazo){
        GregorianCalendar cal = new GregorianCalendar();
        if(isDisponivel()){
            retiradoPor = u;
            dtEmprestimo = cal.getTime();
            cal.add(Calendar.DATE, prazo);
            dtDevolucao = cal.getTime();
            return(true);
        }else return(false);
    }
    
    public boolean retorna(Usuario u){
        if( u == retiradoPor){
            retiradoPor = null;
            return(true);
        }
        else return (false);
        
    }
    
    @Override
    public String toString(){
        String st = new String();
        
        if(isDisponivel()){
            return (titulo + " Disponivel ");
        }
        if(isEmprestado()){
            st = "Retirado por:  " + retiradoPor + 
                    "  em  " + dma(dtEmprestimo) + 
                    " ate " + dma(dtDevolucao);
        }else{
            st = "Bloqueado por: " + retiradoPor + 
                    " em " + dma(dtBloqueio) + 
                    " ate " + dma(dtDesbloqueio);
        }
        return(titulo + st);
    
    }
    
    private String dma(Date dt){
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(dt);
        
        return(cal.get(Calendar.DATE) + "/" + 
                (cal.get(Calendar.MONTH)+1) + "/" +
                cal.get(Calendar.YEAR));
    }
    
    
    
    
}

