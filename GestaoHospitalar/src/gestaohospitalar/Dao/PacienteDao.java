/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Dao;
import gestaohospitalar.Model.Paciente;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PacienteDao {
    private Map<Integer, Paciente> pacientesBD;
    private Scanner input;

    public PacienteDao() {
        this.pacientesBD = new HashMap<>();
        input = new Scanner(System.in);
    }
    
    public void cadastrarPaciente(Paciente paciente){
        pacientesBD.put(paciente.getId(), paciente); //adicionando ele a lista de pacientes
    };


    public Map<Integer,Paciente> listarPacientes(){
       return pacientesBD;
    }
    
    public Paciente buscarPacientePorId(int id){
        return pacientesBD.get(id);
    }
    
    public void excluirPaciente(int id){
        pacientesBD.remove(id); //remove o paciente da lista
        
    }
    
    public boolean atualizarPaciente(int id, Paciente pacienteAtualizado) {
        if (pacientesBD.containsKey(id)) {
            pacientesBD.put(id, pacienteAtualizado);
            return true;
        }
        return false;
    }
   /*
    
      */ 
}
   
