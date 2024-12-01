/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Service;
import gestaohospitalar.Dao.MedicoDaoImpl;
import gestaohospitalar.Model.Medico;
import java.util.Scanner;

public class MedicoService {
    MedicoDaoImpl medicoDao = new MedicoDaoImpl();
    private Scanner input;

    public MedicoService() {
        this.input = new Scanner(System.in);
    }
    
    public void cadastrarMedico(){
        String nome, endereco, cpf, telefone, especialidade, crm;
        
        System.out.println("------Cadastro Medico------ \n");
        
        System.out.print("\tNome: ");
        nome = input.nextLine();
        
        System.out.print("\tCPF: ");
        cpf = input.nextLine();
        
        System.out.print("\tEndereco: ");
        endereco = input.nextLine();
        
        System.out.print("\tTelefone: ");
        telefone = input.nextLine();
        
        System.out.print("\tEspecialidade: ");
        especialidade = input.nextLine();
        
        System.out.print("\tCrm: ");
        crm = input.nextLine();
        
        Medico medico = new Medico(nome, cpf, endereco, telefone, especialidade, crm); //instanciando um novo paciente
        medicoDao.cadastrarMedico(medico);   
    }
    
     public void atualizarMedico(){
       int id, op;
      
       System.out.println("------Atualizacao Cadastro Medico------");
       System.out.println("Informe o id do medico "); 
       id = input.nextInt();
       
       Medico medico = medicoDao.buscarMedicoPorId(id);
       if(medico != null){
                // depois vai exibir o menu de dados que podem ser alterados e enquanto o usuario não digitar 0 vai ser possivel alterar o dado 
                do{
                    System.out.println("Escolha o dado que voce deseja alterar o nome: ");
                    System.out.println("\t [0] Voltar  \n\t [1] Nome \n\t [2] CPf \n\t [3] Endereco \n\t [4] Telefone \n\t [5] Especialidade \n\t [6] CRM");
                    op = input.nextInt();
                    input.nextLine();
                        switch(op){
                            case 1 -> {
                                System.out.println("Informe o novo nome: ");
                                medico.setNome(input.nextLine());
                            }
                            case 2 -> {
                                System.out.println("Informe o novo cpf ");
                                medico.setCpf(input.nextLine());
                            }
                            case 3 -> {
                                System.out.println("Informe o novo endereço: ");
                                medico.setEndereco(input.nextLine());
                            }
                            case 4 -> {
                                System.out.println("Informe o novo telefone ");
                                medico.setTelefone(input.nextLine());
                            }
                            case 5 -> {
                                System.out.println("Informe a nova especialidade: ");
                                medico.setEspecialidade(input.nextLine());
                            }
                            case 6 -> {
                                System.out.println("Informe o novo numero do CRM: ");
                                medico.setCrm(input.nextLine());
                            }
                            default -> {}
                        }
                    if(op != 0){
                       medicoDao.atualizarMedico(id, medico);
                        System.out.println("Dados atualizados com sucesso!");
                    }
                }while(op != 0);
            }else{
                 System.out.println("O medico informado nao existe");
            }
                
    }
    
    public void listarMedicos(){
        var lista = medicoDao.listarMedicos();
        if(lista.isEmpty()){
            System.out.println("A lista esta vazia!");
        }else{
            System.out.println("Lista de Medicos: ");
            for(Medico medico: lista.values()){
                medico.exibir();
            }
        }
    }
    
    public void buscarMedicoPorId(){
        int id;  
        System.out.println("Informe o id do Medico: ");
        id = input.nextInt();
        
        Medico medicoExiste = medicoDao.buscarMedicoPorId(id) ;
        if(medicoExiste != null){
            medicoExiste.exibir();
        } else{
            System.out.println("Medico nao existe");
        }
    }
    
    public void excluirMedico(){
     int id;  
     System.out.println("Informe o id do medico que sera excluido: ");
     id = input.nextInt();
     Medico medico = medicoDao.buscarMedicoPorId(id);
     if(medico != null){
         medicoDao.excluirMedico(id);
         System.out.println("Medico excluido com sucesso");
     }else{
         System.out.println("Medico nao encontrado");
     }
    }
    
     public void menuMedico(){
        int op;
        do{
            System.out.println("\n Informe uma opcao: ");
            System.out.println("\t 1- Cadastrar Medico \n\t 2- Atualizar Medico \n\t 3- Listar Medico \n\t 4- Buscar Medico por Id \n\t 5- Excluir Medico \n\t 6- Sair");
            op = input.nextInt();
            input.nextLine();
            
            switch(op){
                case 1-> cadastrarMedico();
                case 2-> atualizarMedico();
                case 3-> listarMedicos();
                case 4-> buscarMedicoPorId();
                case 5-> excluirMedico();
                }
        }while(op != 6);
    }
}
