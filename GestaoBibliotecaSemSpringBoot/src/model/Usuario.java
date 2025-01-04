/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Vector;
import java.util.Enumeration;

public class Usuario {
    private String nome;
    private Vector livrosRetirados;
    
    public Usuario(String nome){
        this.nome = nome;
        livrosRetirados = new Vector(5);
    }
    
    public boolean retiraLivro(Livro it){
        if(isAptoARetirar()){
            if(it.empresta(this, getPrazoMaximo())){
                livrosRetirados.add(it);
                return (true);
            }else
                return (false);
        }else
            return (false);
    }
    
    public boolean devolveLivro(Livro it){
         if(it.retorna(this)){
             livrosRetirados.removeElement(it);
             return (true);
         }else
             return (false);
    }
    
    public int getCotaMaxima(){
        return 2;
    }
    
    public int getPrazoMaximo(){
        return 4;
    }
    
    public boolean temPrazoVencido(){
        Livro livro;
        Enumeration lista = livrosRetirados.elements();
        while(lista.hasMoreElements()){
            livro = (Livro)lista.nextElement();
            if(livro.isEmAtraso()){
                return (true);
            }
        }
        return false;          
    }
    
    public boolean isADevolver(){
        return((livrosRetirados.size() >= getCotaMaxima()
                || temPrazoVencido()) ? 
                true : false);
    }
    
    public boolean isAptoARetirar(){
        return (!isADevolver());
    }
    
    public boolean isProfessor(){
        return false;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String toString(){
        return ("Usuario" + nome);
    }
    
    public void listaCarga(){
        System.out.println(toString() + "Limite: " + getCotaMaxima() +
                "Carga Atual: " + livrosRetirados.size());
        Enumeration lista = livrosRetirados.elements();
        while(lista.hasMoreElements()){
            System.out.println(lista.nextElement());
        }
    }
}
