/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestaobibliotecasemspringboot;

import java.io.IOException;

/**
 *
 * @author miche
 */
public class GestaoBibliotecaSemSpringBoot {

    public static void main(String[] args) {
        System.out.println("Gestão biblioteca");
        try{
            Cap9.init();
        }catch (IOException e) {
            System.err.println("Erro durante a execução do sistema: " + e.getMessage());
        }
        System.out.println("Sistema encerrado.");
    }
    
}
