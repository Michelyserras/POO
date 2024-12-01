/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Dao;

import gestaohospitalar.Model.Medico;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MedicoDaoImpl implements MedicoDao {
     private Map<Integer, Medico> medicosBD;
    private Scanner input;

    public MedicoDaoImpl(){
        this.medicosBD = new HashMap<>();
        input = new Scanner(System.in);
    }
    
    
    @Override
    public void cadastrarMedico(Medico medico){
        medicosBD.put(medico.getId(), medico); //adicionando ele a lista de pacientes
    };

    @Override
    public Map<Integer,Medico> listarMedicos(){
       return medicosBD;
    }
    
    @Override
    public Medico buscarMedicoPorId(int id){
        return medicosBD.get(id);
    }
    
    @Override
    public void excluirMedico(int id){
        medicosBD.remove(id); //remove o paciente da lista
        
    }
    
    @Override
    public boolean atualizarMedico(int id, Medico medicoAtualizado) {
        if (medicosBD.containsKey(id)) {
            medicosBD.put(id, medicoAtualizado);
            return true;
        }
        return false;
    }
 
    
}
