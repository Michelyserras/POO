/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Dao;
import gestaohospitalar.Model.Medico;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public interface MedicoDao {
   
    
    public void cadastrarMedico(Medico medico);
    
    public boolean atualizarMedico(int id, Medico medico );
    
    public Map<Integer,Medico> listarMedicos();
    
    public Medico buscarMedicoPorId(int id);
    
    public void excluirMedico(int id);
}
