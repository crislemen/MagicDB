package es.iespuertodelacruz.magic.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
    }
    private void menu() {
 
            Scanner sn = new Scanner(System.in);
            boolean salir = false;
             //Guardaremos la opcion del usuario
     
            while (!salir) {
     
                System.out.println("0. Salir");
                System.out.println("1. Entrar como administrador");
                System.out.println("2. Entrar como usuario");
     
                try {
     
                    System.out.println("Escribe una de las opciones");
                    int opcion = sn.nextInt();
     
                    while(!salir){

                        System.out.println("Bienvenido al modo administrador");
                        System.out.println("Elige una opcion a realizar");
                        System.out.println("");
                        System.out.println("0.Salir");
                        System.out.println("1.Insertar una Carta");
                        System.out.println("2.Modificar una Carta");
                        System.out.println("3.Buscar una Carta");

                        

                        try {

                            System.out.println("Escribe una de las opciones");
                            int opcion1 = sn.nextInt();

                            switch (opcion1) {

                                case 1:
                                
                                    System.out.println("Has seleccionado la opcion 1");                                  
                                    break;

                                case 2:

                                    System.out.println("Has seleccionado la opcion 2");
                                    break;

                                case 3:
                                    System.out.println("Has seleccionado la opcion 3");                                 
                                    break;
                                case 0:
                                    salir = true;
                                    break;
                                default:
                                    System.out.println("Solo números entre 1 y 3");
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("Debes insertar un número");
                            salir=true;
                        }
                    }
                    
                    
                } catch (InputMismatchException e) {
                    System.err.println("Debes insertar un número");
                    salir=true;
                }
            }
     
        }
}
