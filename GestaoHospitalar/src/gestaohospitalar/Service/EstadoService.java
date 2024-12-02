/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Service;
import gestaohospitalar.Dao.EstadosDaoImpl;
import gestaohospitalar.Dao.MedicoDaoImpl;
import gestaohospitalar.Model.EstadoAtendimento;
import java.util.Scanner;
public class EstadoService {
    EstadosDaoImpl estadoDao = new EstadosDaoImpl();
    private Scanner input;
    
    public EstadoService(){
        input = new Scanner(System.in);
    }
    
    public void listarEstados(){
        var lista = estadoDao.listarEstados();
        if(lista.isEmpty()){
            System.out.println("Nao ha estados cadastrados");
        }else{
            for(EstadoAtendimento estado: lista.values()){
                estado.exibir();
            }
        }
    }
    
    public void buscarEstadoPorId(){
        int id;  
        System.out.println("Informe o id do Estado: ");
        id = input.nextInt();
        
        EstadoAtendimento estado = estadoDao.buscarEstadoPorId(id);
        if(estado != null){
            estado.exibir();
        }else{
            System.out.println("Estado não existe");
        }
    }
    
    
}
