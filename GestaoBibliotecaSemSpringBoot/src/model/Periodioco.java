/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author miche
 */
public class Periodioco extends Livro {
    
    public Periodioco(String tit) {
        super(tit);
    }
    
    @Override
    public boolean empresta(Usuario u, int prazo){
        if(u.isProfessor()){
            return (super.empresta(u, 7));
        }
        return (false);
    }
    
}
