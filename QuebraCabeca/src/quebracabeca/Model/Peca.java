/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quebracabeca.Model;
public abstract class Peca{
    private String descricao;
    private Borda[] bordas; // Cada peça tem 4 bordas

    public Peca(String descricao, Borda[] bordas) {
        if (bordas.length != 4) {
            System.out.println("Uma peça deve ter exatamente 4 bordas.");
        }
        this.descricao = descricao;
        this.bordas = bordas;
    }

    public String getDescricao() {
        return descricao;
    }

    public Borda getBorda(int indice) {
        if (indice < 0 || indice >= 4) {
            System.out.println("O índice da borda deve estar entre 0 e 3.");
        }
        return bordas[indice];
    }

    
    public abstract boolean encaixaCom(Peca outra, int minhaBorda, int bordaOutra);

  
    public void exibir() {
        System.out.println("Peca: " + descricao);
        System.out.println("Bordas:");
        for(Borda borda: bordas){
            borda.exibir();
        }
        System.out.println("\n");
    }
}


