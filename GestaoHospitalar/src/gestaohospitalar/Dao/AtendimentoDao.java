/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Dao;

import gestaohospitalar.Model.Atendimento;
import java.util.Map;

public interface AtendimentoDao {
        
    public void cadastrarAtendimento(Atendimento atendimento);
    
    public boolean atualizarAtendimento(int id, Atendimento atendimento );
    
    public Map<Integer,Atendimento> listarAtendimentos();
    
    public Atendimento buscarAtendimentoPorId(int id);
    
    public void excluirAtendimento(int id);
    
}
