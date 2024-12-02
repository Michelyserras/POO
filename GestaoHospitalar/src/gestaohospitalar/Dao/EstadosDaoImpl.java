/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Dao;

import gestaohospitalar.Model.EstadoAtendimento;
import gestaohospitalar.Model.Estado.AltaClinica;
import gestaohospitalar.Model.Estado.Cirurgia;
import gestaohospitalar.Model.Estado.Entrada;
import gestaohospitalar.Model.Estado.PosCirurgia;
import gestaohospitalar.Model.Estado.PreparacaoPreCirurgia;
import gestaohospitalar.Model.Estado.TratamentoClinicoGeral;
import java.util.HashMap;
import java.util.Map;

public class EstadosDaoImpl implements EstadosDao{
    private Map<Integer, EstadoAtendimento> estadosBD;
    
    public EstadosDaoImpl(){
        estadosBD = new HashMap<>();
        AltaClinica alta = new AltaClinica();
        Cirurgia cirurgia = new Cirurgia();
        Entrada entrada = new Entrada();
        TratamentoClinicoGeral tratamento = new TratamentoClinicoGeral();
        PosCirurgia posCirurgia = new PosCirurgia();
        PreparacaoPreCirurgia preCirurgia = new PreparacaoPreCirurgia();
        
        estadosBD.put(entrada.getId(), entrada);
        estadosBD.put(tratamento.getId(), tratamento);
        estadosBD.put(preCirurgia.getId(), preCirurgia);
        estadosBD.put(cirurgia.getId(), cirurgia);
        estadosBD.put(posCirurgia.getId(), posCirurgia);
        estadosBD.put(alta.getId(), alta);
        
    }
    

    @Override
    public boolean atualizarEstado(int id, EstadoAtendimento estado) {
    if (estadosBD.containsKey(id)) {
                estadosBD.put(id, estado);
                return true;
            }
            return false;
    }

    @Override
    public Map<Integer, EstadoAtendimento> listarEstados() {
        return estadosBD;
    }

    @Override
    public EstadoAtendimento buscarEstadoPorId(int id) {
        return estadosBD.get(id);
    }

    @Override
    public void excluirEstado(int id) {
        estadosBD.remove(id);
    }
    
}
