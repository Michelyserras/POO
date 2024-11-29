/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Dao;
import gestaohospitalar.Model.Medico;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MedicoDao {
    private Map<Integer, Medico> medicosBD;
    private Scanner input;
    
    public MedicoDao(){
        this.medicosBD = new HashMap<>();
        input = new Scanner(System.in);
    }
    
    public void cadastrarMedico(){
    }
    
    public void atualizarMedico(){
    }
    
    public void listarMedicos(){
    }
    
    public void buscarMedicoPorId(){
    }
    
    public void excluirMedico(){
    }
}
