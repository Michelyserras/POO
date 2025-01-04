/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class UsuarioProfessor extends Usuario{
    
    public UsuarioProfessor(String nome) {
        super(nome);
    }
    
    public boolean bloqueiaLivro(Livro it, int prazo){
        return(it.bloqueia((Usuario)this, prazo));
    }
    
    public boolean desbloqueiaLivro(Livro it){
        return (it.desbloqueia((Usuario)this));
    }
   
    public int getCargaLimite(){
        return 5;
    }
    
    @Override
    public int getPrazoMaximo(){
        return 14;
    }
    
    @Override
    public boolean isProfessor(){
        return (true);
    }
    
    @Override
    public String toString(){
        return("Prof. " + getNome());
    }
}
