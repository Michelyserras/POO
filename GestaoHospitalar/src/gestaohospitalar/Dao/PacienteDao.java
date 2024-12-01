/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Dao;
import gestaohospitalar.Model.Paciente;
import java.util.Map;

public interface PacienteDao{
    
    public void cadastrarPaciente(Paciente paciente);
    public Map<Integer,Paciente> listarPacientes();
    public Paciente buscarPacientePorId(int id);
    public void excluirPaciente(int id);
    public boolean atualizarPaciente(int id, Paciente pacienteAtualizado);
    
}
   
