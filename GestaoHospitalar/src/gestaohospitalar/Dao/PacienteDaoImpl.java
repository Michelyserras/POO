/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Dao;

import gestaohospitalar.Model.Paciente;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PacienteDaoImpl implements PacienteDao {
    private Map<Integer, Paciente> pacientesBD;
    private Scanner input;

    public PacienteDaoImpl(){
        this.pacientesBD = new HashMap<>();
        input = new Scanner(System.in);
    }
    
    
    @Override
    public void cadastrarPaciente(Paciente paciente){
        pacientesBD.put(paciente.getId(), paciente); //adicionando ele a lista de pacientes
    };

    @Override
    public Map<Integer,Paciente> listarPacientes(){
       return pacientesBD;
    }
    
    @Override
    public Paciente buscarPacientePorId(int id){
        return pacientesBD.get(id);
    }
    
    @Override
    public void excluirPaciente(int id){
        pacientesBD.remove(id); //remove o paciente da lista
        
    }
    
    @Override
    public boolean atualizarPaciente(int id, Paciente pacienteAtualizado) {
        if (pacientesBD.containsKey(id)) {
            pacientesBD.put(id, pacienteAtualizado);
            return true;
        }
        return false;
    }
 
}
