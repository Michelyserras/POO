/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quebracabeca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import quebracabeca.Model.Borda;
import quebracabeca.Model.Peca;
import quebracabeca.Model.PecaComum;

public class QuebraCabeca {

    public static void main(String[] args) {
        int op, num1, num2;
        List<Peca> pecas = criarPecas();
        String numPeca1, numPeca2;
        Scanner input = new Scanner(System.in);
    
        
       do{
         op = menu();
         
         switch(op){
             case 1 ->{
                 ExibirPecas(pecas);
             }
             case 2 -> {
    do {
        System.out.println("Informe uma peça: (Ex: Peca 1-9)");
        numPeca1 = input.nextLine();
        System.out.println("Informe a segunda peça: (Ex: Peca 1-9)");
        numPeca2 = input.nextLine();
        System.out.println("Informe um dos lados da borda da primeira peça (1-4):");
        num1 = input.nextInt();
        System.out.println("Informe um dos lados da borda da segunda peça (1-4):");
        num2 = input.nextInt();
        input.nextLine(); 

        Peca peca1 = null, peca2 = null;

        
        for (Peca peca : pecas) {
            if (peca.getDescricao().equalsIgnoreCase(numPeca1)) {
                peca1 = peca;
            }
            if (peca.getDescricao().equalsIgnoreCase(numPeca2)) {
                peca2 = peca;
            }
        }

        if (peca1 != null && peca2 != null) {
            boolean encaixe = peca1.encaixaCom(peca2, num1 - 1, num2 - 1);
            System.out.println("Encaixe entre as peças: " + encaixe);
        } else {
            System.out.println("Peças inválidas. Verifique as descrições informadas.");
        }
    } while (num1 < 1 || num1 > 4 || num2 < 1 || num2 > 4);
     }

             }
             
            default ->{System.out.println("Opcao invalida");}
         }
           
       }while(op != 2);
        
       
   }
    
    public static List<Peca> criarPecas(){
        List<Peca> pecas = new ArrayList<>();
        
        Borda borda1 = new Borda(new boolean[]{true, false});
        Borda borda2 = new Borda(new boolean[]{false, true});
        Borda borda3 = new Borda(new boolean[]{true, true});
        Borda borda4 = new Borda(new boolean[]{false, false});

        Borda borda5 = new Borda(new boolean[]{false, true});
        Borda borda6 = new Borda(new boolean[]{true, false});
        Borda borda7 = new Borda(new boolean[]{false, false});
        Borda borda8 = new Borda(new boolean[]{true, true});
        
        


        Peca peca1 = new PecaComum("Peca 1", new Borda[]{borda1, borda2, borda3, borda4});
        Peca peca2 = new PecaComum("Peca 2", new Borda[]{borda5, borda6, borda7, borda8});
        Peca peca3 = new PecaComum("Peca 3", new Borda[]{borda2, borda1, borda4, borda3});
        Peca peca4 = new PecaComum("Peca 4", new Borda[]{borda6, borda5, borda8, borda7});
        Peca peca5 = new PecaComum("Peca 5", new Borda[]{borda1, borda2, borda5, borda6});
        Peca peca6 = new PecaComum("Peca 6", new Borda[]{borda5, borda6, borda1, borda2});
        Peca peca7 = new PecaComum("Peca 7", new Borda[]{borda3, borda4, borda3, borda4});
        Peca peca8 = new PecaComum("Peca 8", new Borda[]{borda5, borda6, borda3, borda3});
        Peca peca9 = new PecaComum("Peca 9", new Borda[]{borda3, borda3, borda3, borda4});
        
        
        pecas.add(peca1);
        pecas.add(peca2);
        pecas.add(peca3);
        pecas.add(peca4);
        pecas.add(peca5);
        pecas.add(peca6);
        pecas.add(peca7);
        pecas.add(peca8);
        pecas.add(peca9);
        
        return pecas;
        
    }
    
    public static void ExibirPecas(List<Peca> pecas){
        for(Peca peca: pecas){
            peca.exibir();
        }  
    }
    
    public static int menu(){
        int op;
        Scanner input = new Scanner(System.in);
        System.out.println("Informe uma opcao: \n\t [0]- Sair \n\t [1]-Exibir pecas \n\t [2]- Encaixar Pecas");
        op = input.nextInt();
        return op;
    }
}

  

