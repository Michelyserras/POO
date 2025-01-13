package Model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String nome;
    private HashMap<Integer, Livro> livrosEmp;
   

    public Usuario(String nome){
        this.nome = nome;
        this.livrosEmp = new HashMap<>();
    }


    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getQtdMaxima(){
        return 2;
    }

    public int getPrazoMaximo(){
        return 5;
    }
    
    public List<Livro> getLivros(){
        return new ArrayList<>(livrosEmp.values());
    }

    public void addLivro(Integer id,Livro livro){
        livrosEmp.put(id, livro);
    }

    public void removeLivro(Integer id){
        if(livrosEmp.containsKey(id)){
            livrosEmp.remove(id);
        }
    }

    public boolean isProfessor(){
        return false;
    }
}
