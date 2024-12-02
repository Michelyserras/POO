/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Dao;

import gestaohospitalar.Model.Atendimento;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class AtendimentoDaoImpl implements AtendimentoDao {
    private Map<Integer, Atendimento> atendimentoBD;
    
    public AtendimentoDaoImpl(){
        atendimentoBD = new HashMap<>();
    }

    @Override
    public void cadastrarAtendimento(Atendimento atendimento) {
       atendimentoBD.put(atendimento.getId(),atendimento);
        
    }

    @Override
    public boolean atualizarAtendimento(int id, Atendimento atendimento) {
        if (atendimentoBD.containsKey(id)) {
            atendimentoBD.put(id, atendimento);
            return true;
        }
        return false;
    }

    @Override
    public Map<Integer, Atendimento> listarAtendimentos() {
        return atendimentoBD;
    }

    @Override
    public Atendimento buscarAtendimentoPorId(int id) {
        return atendimentoBD.get(id);
    }

    @Override
    public void excluirAtendimento(int id) {
        atendimentoBD.remove(id);
    }

   
}
