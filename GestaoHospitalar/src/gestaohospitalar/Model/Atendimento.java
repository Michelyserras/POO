/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Model;
public class Atendimento {
    private int contadorId = 0;
    private int id;
    private String data;
    private int pacienteId;
    private int medicoId;
    private int estadoId;

    public Atendimento(String data,int pacienteId, int medicoId, int estadoId) {
        this.data = data;
        this.id = contadorId++;
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.estadoId = estadoId;
    }
    
    public String getData(){
        return data;
    }
    
    public void setData(String data){
        this.data = data;
    }
    

    public int getId(){
        return id;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public int getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(int medicoId) {
        this.medicoId = medicoId;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }
    
    public void exibir(){
        System.out.println("Atendimento          : " + id);
        System.out.println("Estado do Atendimento: " + estadoId);
        System.out.println("Paciente             : " + pacienteId);
        System.out.println("Medico               : " + medicoId);
    }
    
    
}
