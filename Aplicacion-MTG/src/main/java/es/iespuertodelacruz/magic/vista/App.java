package es.iespuertodelacruz.magic.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import es.iespuertodelacruz.magic.controlador.MagicController;
import es.iespuertodelacruz.magic.modelo.MagicModelo;

public class App {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        MagicController magicController;
        magicController = new MagicController();

        // Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("0. Salir");
            System.out.println("1. Entrar como administrador");
            System.out.println("2. Entrar como usuario");

            try {

                System.out.println("Escribe una de las opciones");
                int opcion = sn.nextInt();

                while (!salir) {

                    try {

                        System.out.println("Escribe una de las opciones");

                        switch (opcion) {

                            case 1:
                                System.out.println("Bienvenido al modo administrador");
                                System.out.println("Elige una opcion a realizar");
                                System.out.println("");
                                System.out.println("0.Salir");
                                System.out.println("1.Insertar una Carta");
                                System.out.println("2.Modificar una Carta");
                                System.out.println("3.Buscar una Carta");
                                int opcion1 = sn.nextInt();
                                switch (opcion1) {
                                    case 0:
                                        salir = true;
                                        break;
                                    case 1:
                                        magicController.insertar();
                                        break;
                                    case 2:
                                        magicController.modificar();
                                        break;
                                    case 3:
                                        magicController.buscar();
                                        break;
                                    default:
                                        System.out.println("Solo números entre 0 y 3");
                                }
                                break;

                            case 2:

                                System.out.println("Bienvenido al modo usuario");
                                System.out.println("Elige una opcion a realizar");
                                System.out.println("");
                                System.out.println("0.Salir");
                                System.out.println("1.Buscar una Carta");
                                int opcion2 = sn.nextInt();
                                switch (opcion2) {
                                    case 0:
                                        salir = true;
                                        break;
                                    case 1:
                                        magicController.buscar();
                                        break;
                                    default:
                                        System.out.println("Solo números entre 0 y 1");
                                }
                            case 0:
                                salir = true;
                                break;
                            default:
                                System.out.println("Solo números entre 0 y 2");
                        }
                    } catch (InputMismatchException e) {
                        System.err.println("Debes insertar un número");
                        salir = true;
                    }
                }

            } catch (InputMismatchException e) {
                System.err.println("Debes insertar un número");
                salir = true;
            }
        }

    }
}
