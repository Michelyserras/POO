/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Model;

public abstract class EstadoAtendimento {
    private int contadorId = 0;
    private int id;
    private String nomeEstado;

    public EstadoAtendimento(String nomeEstado) {
        this.id = contadorId++;
        this.nomeEstado = nomeEstado;
    }


    public int getId() {
        return id;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }
        
    public void exibir(){
        System.out.println("ID: " + id);
        System.out.println("Estado : " + nomeEstado);
        System.out.println(" ");
    }
   
    
}
