/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Dao;
import gestaohospitalar.Model.Paciente;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PacienteDao {
    private Map<Integer, Paciente> pacientesBD;
    private Scanner input;

    public PacienteDao() {
        this.pacientesBD = new HashMap<>();
        input = new Scanner(System.in);
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
        pacientesBD.put(paciente.getId(), paciente); //adicionando ele a lista de pacientes
    };


    public void atualizarCadastro(){
        String nome, cpf, endereco, telefone, nomeConv, numConv; //variaveis que serão atualizadas
        int id, op;
        System.out.println("------Atualizaçao Cadastro Paciente------");
        System.out.println("Informe o id do paciente: "); 
        id = input.nextInt();
        Paciente paciente = pacientesBD.get(id);
            if(paciente != null){ //buscando o paciente na lista pelo id
                System.out.println("Paciente encontrado: \n " ); // se encontrado vai exibir os dados do paciente
                paciente.exibir();
                // depois vai exibir o menu de dados que podem ser alterados e enquanto o usuario não digitar 0 vai ser possivel alterar o dado desse paciente
                do{
                    System.out.println("Escolha o dado que voce deseja alterar o nome: ");
                    System.out.println("\t [0] Voltar  \n\t [1] Nome \n\t [2] CPf \n\t [3] Endereco \n\t [4] Telefone \n\t [5] Nome do Convenio \n\t [6] Numero do convenio");
                    op = input.nextInt();
                    input.nextLine();
                        switch(op){
                            case 1 -> {
                                System.out.println("Informe o novo nome: ");
                                nome = input.nextLine();
                                paciente.setNome(nome);
                                System.out.println("Nome atualizado com sucesso!");
                            }
                            case 2 -> {
                                System.out.println("Informe o novo cpf ");
                                cpf = input.nextLine();
                                paciente.setCpf(cpf);
                                System.out.println("Cpf atualizado com sucesso!");
                            }
                            case 3 -> {
                                System.out.println("Informe o novo endereço: ");
                                endereco = input.nextLine();
                                paciente.setEndereco(endereco);
                                System.out.println("Endereço atualizado com sucesso!");
                            }
                            case 4 -> {
                                System.out.println("Informe o novo telefone ");
                                telefone = input.nextLine();
                                paciente.setTelefone(telefone);
                                System.out.println("Telefone atualizado com sucesso!");
                            }
                            case 5 -> {
                                System.out.println("Informe o novo nome do convenio: ");
                                nomeConv = input.nextLine();
                                paciente.setNomeConvenio(nomeConv);
                                System.out.println("Nome do convenio atualizado com sucesso!");
                            }
                            case 6 -> {
                                System.out.println("Informe o novo numero do convenio: ");
                                numConv = input.nextLine();
                                paciente.setNumeroConvenio(numConv);
                                System.out.println("Numero do convenio atualizado com sucesso!");
                            }
                            default -> {

                            }
                        }
                }while(op != 0);
            }else{
                 System.out.println("O paciente informado nao existe");
            }
                
    }
    
    public void listarPacientes(){
        if(pacientesBD.isEmpty()){ // se a lista estiver vazia retorna nulo
            System.out.println("Nao ha nenhum paciente cadastrado!");
        }else{
            System.out.println("Lista de Pacientes: \n");
            for (Paciente paciente : pacientesBD.values()) {
                paciente.exibir(); 
            }  
        }
    }
    
    public void buscarPacientePorId(){
        int id;
        System.out.println("Informe o id do paciente: ");
        id = input.nextInt();
        
        Paciente paciente = pacientesBD.get(id);
         if(paciente != null){ // busca o paciente pelo id e se encontrado exibre os seus dados
                System.out.println("Paciente Encontrado: ");
                paciente.exibir();
        }  
        else{
            System.out.println("Paciente nao encontrado");
        }
    }
    
    public void excluirPaciente(){
        int id;  
        System.out.println("Informe o id do paciente que será excluido: ");
        id = input.nextInt();
        
        if(pacientesBD.containsKey(id)){
            pacientesBD.remove(id); //remove o paciente da lista
            System.out.println("Paciente excluido com sucesso!");
        }else { // se não for encontrado apenas retorna a mensagem
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
                case 2-> atualizarCadastro();
                case 3-> listarPacientes();
                case 4-> buscarPacientePorId();
                case 5-> excluirPaciente();
                }
        }while(op != 6);
    }
    
       
}
