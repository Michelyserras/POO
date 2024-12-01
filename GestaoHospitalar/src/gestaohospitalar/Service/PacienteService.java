/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Service;
import gestaohospitalar.Dao.PacienteDao;
import gestaohospitalar.Model.Paciente;
import java.util.Scanner;

public class PacienteService {
    PacienteDao pacienteDao = new PacienteDao();
    private Scanner input;

    public PacienteService() {
        this.input = new Scanner(System.in);
    }
    
    
    public void cadastrarPaciente(){
        String nome, cpf, endereco, telefone, nomeConv, numConv; // variaveis para armazenar os valores do novo paciente cadastrado
        System.out.println("------Cadastro Paciente------ \n");
        
        System.out.print("\tNome: ");
        nome = input.nextLine();
        
        System.out.print("\tCPF: ");
        cpf = input.nextLine();
        
        System.out.print("\tEndereco: ");
        endereco = input.nextLine();
        
        System.out.print("\tTelefone: ");
        telefone = input.nextLine();
        
        System.out.print("\tNome do Convenio: ");
        nomeConv = input.nextLine();
        
        System.out.print("\tNumero do Convenio: ");
        numConv= input.nextLine();
        
        Paciente paciente = new Paciente(nome, cpf, endereco, telefone, nomeConv, numConv); //instanciando um novo paciente
        pacienteDao.cadastrarPaciente(paciente);
        
    }
    
    public void atualizarPaciente(){
       int id, op;
      
       System.out.println("------Atualizaçao Cadastro Paciente------");
       System.out.println("Informe o id do paciente: "); 
       id = input.nextInt();
       
       Paciente paciente = pacienteDao.buscarPacientePorId(id);
       if(paciente != null){
                // depois vai exibir o menu de dados que podem ser alterados e enquanto o usuario não digitar 0 vai ser possivel alterar o dado desse paciente
                do{
                    System.out.println("Escolha o dado que voce deseja alterar o nome: ");
                    System.out.println("\t [0] Voltar  \n\t [1] Nome \n\t [2] CPf \n\t [3] Endereco \n\t [4] Telefone \n\t [5] Nome do Convenio \n\t [6] Numero do convenio");
                    op = input.nextInt();
                    input.nextLine();
                        switch(op){
                            case 1 -> {
                                System.out.println("Informe o novo nome: ");
                                paciente.setNome(input.nextLine());
                            }
                            case 2 -> {
                                System.out.println("Informe o novo cpf ");
                                paciente.setCpf(input.nextLine());
                            }
                            case 3 -> {
                                System.out.println("Informe o novo endereço: ");
                                paciente.setEndereco(input.nextLine());
                            }
                            case 4 -> {
                                System.out.println("Informe o novo telefone ");
                                paciente.setTelefone(input.nextLine());
                            }
                            case 5 -> {
                                System.out.println("Informe o novo nome do convenio: ");
                                paciente.setNomeConvenio(input.nextLine());
                            }
                            case 6 -> {
                                System.out.println("Informe o novo numero do convenio: ");
                                paciente.setNumeroConvenio(input.nextLine());
                            }
                            default -> {}
                        }
                    if(op != 0){
                       pacienteDao.atualizarPaciente(id, paciente);
                        System.out.println("Dados atualizados com sucesso!");
                    }
                }while(op != 0);
            }else{
                 System.out.println("O paciente informado nao existe");
            }
                
    }
    
    public void listarPacientes(){
        var lista = pacienteDao.listarPacientes();
        if(lista.isEmpty()){
            System.out.println("A lista esta vazia!");
        }else{
            System.out.println("Lista de Pacientes: ");
            for(Paciente paciente: lista.values()){
                paciente.exibir();
            }
        }
    }
    
    public void buscarPacientePorId(){
        int id;  
        System.out.println("Informe o id do paciente que será excluido: ");
        id = input.nextInt();
        
        Paciente pacienteExiste = pacienteDao.buscarPacientePorId(id) ;
        if(pacienteExiste != null){
            pacienteExiste.exibir();
        } else{
            System.out.println("Paciente nao existe");
        }
    }
    
    public void excluirPaciente(){
     int id;  
     System.out.println("Informe o id do paciente que será excluido: ");
     id = input.nextInt();
     Paciente paciente = pacienteDao.buscarPacientePorId(id);
     if(paciente != null){
         pacienteDao.excluirPaciente(id);
         System.out.println("Paciente excluido com sucesso");
     }else{
         System.out.println("Paciente nao encontrado");
     }
    }
    
     public void menuPaciente(){
        int op;
        do{
            System.out.println("\n Informe uma opcao: ");
            System.out.println("\t 1- Cadastrar Paciente \n\t 2- Atualizar Paciente \n\t 3- Listar Pacientes \n\t 4- Buscar Paciente por Id \n\t 5- Excluir Paciente \n\t 6- Sair");
            op = input.nextInt();
            input.nextLine();
            
            switch(op){
                case 1-> cadastrarPaciente();
                case 2-> atualizarPaciente();
                case 3-> listarPacientes();
                case 4-> buscarPacientePorId();
                case 5-> excluirPaciente();
                }
        }while(op != 6);
    }
}
