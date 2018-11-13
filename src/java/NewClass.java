/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ruth.ramosusam
 */
public class NewClass {
    public static void main(String[] args) {
        
        
        
        String nombre="Alberto José";
        String usuario="";
        String password="";
        usuario = nombre.substring(0,6);
        int numeroAleatorio = (int) (Math.random()*998)+100;
        password= usuario+numeroAleatorio;
        System.out.println(numeroAleatorio);
        System.out.println("Nombre Usuario: "+usuario);
        System.out.println("Password: " +password);
    }
}
