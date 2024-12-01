/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestaohospitalar;
import gestaohospitalar.Service.PacienteService;
import java.util.Scanner;

public class GestaoHospitalar {
    
    public static void main(String[] args) {
      int op;
      PacienteService pacientesService = new PacienteService();
      
      
      do{
       op = menu();
       switch(op){
           case 1->{
               pacientesService.menuPaciente();
           }
           case 2->{
               System.out.println("Sorryyy! Eu ainda nao implementei esse casee");
           }
           case 3->{
               System.out.println("Sorryyy! Eu ainda nao implementei esse casee");
           }
           case 4->{
               System.out.println("Ate a proximaaa");
           }
           default ->{
               
           }
      }
      }while(op != 4);      
    }
    
    public static int menu(){
        Scanner input = new Scanner(System.in); 
        int op;
        System.out.println("\n Escolha uma opcao: ");
        System.out.println("\t [1]-Paciente \n\t [2]-Medico \n\t [3]-Atendimento \n\t [4]-Sair");
        op = input.nextInt();
        return op;
    }
    
}
