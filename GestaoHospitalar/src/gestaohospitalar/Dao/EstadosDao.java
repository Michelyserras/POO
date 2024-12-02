/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Dao;

import gestaohospitalar.Model.EstadoAtendimento;
import java.util.Map;

public interface EstadosDao {

    public boolean atualizarEstado(int id, EstadoAtendimento estado );
    
    public Map<Integer,EstadoAtendimento> listarEstados();
    
    public EstadoAtendimento buscarEstadoPorId(int id);
    
    public void excluirEstado(int id);
}
