/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestaohospitalar.Dao;
import gestaohospitalar.Model.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PacienteDao {
    private List<Paciente> pacientesBD;
    private Scanner input;

    public PacienteDao(List<Paciente> pacientesBD) {
        this.pacientesBD = new ArrayList<>();
        input = new Scanner(System.in);
    }
    
    public void cadastrarPaciente(){
        String nome, cpf, endereco, telefone, nomeConv, numConv;
        System.out.println("------Cadastro Paciente------");
        System.out.println("\n\tNome: ");
        nome = input.nextLine();
        System.out.println("\tCPF: ");
        cpf = input.nextLine();
        System.out.println("\tEndereco: ");
        endereco = input.nextLine();
        System.out.println("\tTelefone: ");
        telefone = input.nextLine();
        System.out.println("\tNome do Convenio: ");
        nomeConv = input.nextLine();
        System.out.println("\n\tNumero do Convenio: ");
        numConv= input.nextLine();
        
        Paciente paciente = new Paciente(nomeConv, numConv, nome, cpf, endereco, telefone);
        pacientesBD.add(paciente);
    }

    public void atualizarCadastro(){
        String nome, cpf, endereco, telefone, nomeConv, numConv;
        int id, op;
        System.out.println("------Atualizaçao Cadastro Paciente------");
        System.out.println("Informe o id do paciente: ");
        id = input.nextInt();
        for(Paciente paciente: pacientesBD){
            if(paciente.getId() == id){
                System.out.println("Paciente encontrado: \n " );
                paciente.exibir();
                System.out.println("Escolha o dado que voce deseja alterar o nome: ");
                do{
                System.out.println("\t [0] Sair  \n\t [1] Nome \n\t [2] CPf \n\t [3] Endereço \n\t [4] Telefone \n\t [5] Nome do Convenio \n\t [6] Numero do convenio");
                op = input.nextInt();
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
                
            }
            System.out.println("O paciente informado não existe");
        }
    }
    
    public List<Paciente> listarPacientes(){
        if(pacientesBD.isEmpty()){ // se a lista não estiver vazia retorna ela
            System.out.println("Nao ha nenhum paciente cadastrado!");
            return null;
        }else{
            return pacientesBD;
        }
    }
    
    public void buscarPacientePorId(){
        int id;
        boolean pacienteEncontrado = false;
        System.out.println("Informe o id do paciente: ");
        id = input.nextInt();
        for(Paciente paciente: pacientesBD){
            if(paciente.getId() == id){
                pacienteEncontrado = true;
                System.out.println("Paciente Encontrado: ");
                paciente.exibir();
            }
        }
        if(!pacienteEncontrado){
            System.out.println("Paciente não encontrado");
        }
    }
    
    public void excluirPaciente(){
        int id;
        boolean pacienteExcluido = false;
        
        System.out.println("Informe o id do paciente que será excluido: ");
        id = input.nextInt();
        for(int i=0; i<pacientesBD.size(); i ++){
            if(pacientesBD.get(i).getId() == id){
                 pacientesBD.remove(i);
                 System.out.println("Paciente excluido com sucesso!");
                 pacienteExcluido = true;
            }
        }  
        if(!pacienteExcluido){
            System.out.println("Paciente não encontrado");
        }
        
    }
    
       
}
