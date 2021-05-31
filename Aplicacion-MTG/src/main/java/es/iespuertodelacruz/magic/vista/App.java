package es.iespuertodelacruz.magic.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import es.iespuertodelacruz.magic.api.Carta;
import es.iespuertodelacruz.magic.controlador.MagicController;
import es.iespuertodelacruz.magic.exception.CartaException;
import es.iespuertodelacruz.magic.exception.PersistenciaException;
import es.iespuertodelacruz.magic.modelo.MagicModelo;

public class App {
    public static void main(String[] args) throws CartaException, PersistenciaException {
        menu();
    }

    private static void menu() throws CartaException, PersistenciaException {
        Carta carta;
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        MagicController magicController;
        magicController = new MagicController();

        // Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Entrar como administrador");
            System.out.println("2. Entrar como usuario");
            System.out.println("");
            System.out.println("0. Salir");

            try {
                System.out.println("");
                System.out.println("> Escribe una de las opciones");
                int opcion = sn.nextInt();

                while (!salir) {
                    System.out.println("");
                    System.out.println("> Escribe una de las opciones");

                    switch (opcion) {

                        case 1:
                            System.out.println("");
                            System.out.println("|--------------------------------------|");
                            System.out.println("|[+]BIENVENIDO AL MODO ADMINISTRADOR[+]|");
                            System.out.println("|--------------------------------------|");
                            System.out.println("");
                            System.out.println("> Elige una opcion a realizar");
                            System.out.println("");
                            System.out.println("");
                            System.out.println("1.- Insertar una Carta");
                            System.out.println("2.- Modificar una Carta");
                            System.out.println("3.- Buscar una Carta");
                            System.out.println("");
                            System.out.println("0.- Salir");
                            int opcion1 = sn.nextInt();
                            switch (opcion1) {
                                case 0:
                                    salir = true;
                                    break;
                                case 1:
                                    System.out.println("");
                                    magicController.insertar(crearCarta());
                                    break;
                                case 2:
                                    crearCarta();
                                    magicController.modificar(crearCarta());
                                    break;
                                case 3:
                                    System.out.println("");
                                    System.out.println("> Elige una opcion a realizar");
                                    System.out.println("");

                                    System.out.println("1.- Buscar por nombre");
                                    System.out.println("2.- Buscar por ID");
                                    System.out.println("3.- Buscar por coste de mana");
                                    System.out.println("");
                                    System.out.println("0.- Salir");
                                    int opcion3 = sn.nextInt();
                                    switch (opcion3) {
                                        case 0:
                                            salir = true;
                                            break;
                                        case 1:
                                            System.out.println("");
                                            System.out.println("> Inserta el nombre de la carta a buscar");
                                            String nombreCarta = sn.next();
                                            magicController.buscarPorNombre(nombreCarta);
                                            break;
                                        case 2:
                                            System.out.println("");
                                            System.out.println("> Inserta el id de la carta a buscar");
                                            int id = sn.nextInt();
                                            magicController.buscarPorID(id);
                                            break;
                                        case 3:
                                            System.out.println("");
                                            System.out.println("> Inserta el coste de mana");
                                            String costeMana = sn.next();
                                            magicController.buscarPorCosteMana(costeMana);
                                            break;
                                    }
                                    break;
                                default:
                                    System.out.println("[!]Solo números entre 0 y 3[!]");
                            }
                            break;

                        case 2:
                            System.out.println("");
                            System.out.println("|--------------------------------|");
                            System.out.println("|[+]BIENVENIDO AL MODO USUARIO[+]|");
                            System.out.println("|--------------------------------|");
                            System.out.println("");
                            System.out.println("> Elige una opcion a realizar");
                            System.out.println("");

                            System.out.println("1.- Buscar una Carta");
                            System.out.println("");
                            System.out.println("0.- Salir");
                            int opcion2 = sn.nextInt();
                            switch (opcion2) {
                                case 0:
                                    salir = true;
                                    break;
                                case 1:
                                case 3:
                                    System.out.println("");
                                    System.out.println("> Elige una opcion a realizar");
                                    System.out.println("");

                                    System.out.println("1.- Buscar por nombre");
                                    System.out.println("2.- Buscar por ID");
                                    System.out.println("3.- Buscar por coste de mana");
                                    System.out.println("");
                                    System.out.println("0.- Salir");
                                    int opcion4 = sn.nextInt();
                                    switch (opcion4) {
                                        case 0:
                                            salir = true;
                                            break;
                                        case 1:
                                            System.out.println("");
                                            System.out.println("> Inserta el nombre de la carta a buscar");
                                            String nombreCarta = sn.next();
                                            magicController.buscarPorNombre(nombreCarta);;
                                            break;
                                        case 2:
                                            System.out.println("");
                                            System.out.println("> Inserta el id de la carta a buscar");
                                            int id = sn.nextInt();
                                            magicController.buscarPorID(id);
                                            break;
                                        case 3:
                                            System.out.println("");
                                            System.out.println("> Inserta el coste de mana");
                                            String costeMana = sn.next();
                                            magicController.buscarPorCosteMana(costeMana);
                                            break;
                                    }
                                    break;
                                default:
                                    System.err.println("[!]Solo números entre 0 y 1[!]");
                            }
                            break;
                        case 0:
                            salir = true;
                            break;
                        default:
                            System.err.println("[!]Solo números entre 0 y 2[!]");

                    }
                }

            } catch (InputMismatchException e) {
                System.err.println("[!]Debes insertar un número[!]");
                salir = true;
            }
        }

    }

    /**
     * Metodo encargado de crear carta
     * @return 
     * 
     * @throws CartaException        error controlado
     * @throws PersistenciaException error controlado
     */
    public static Carta crearCarta() throws CartaException, PersistenciaException {

        Scanner sn = new Scanner(System.in);

        Scanner str = new Scanner(System.in);

        System.out.println("[*]Inserte los siguientes valores[*]");
        System.out.println("");

        System.out.println("> Inserte la Id de la carta(Formato Numerico)");
        int id = sn.nextInt();
        System.out.println("");

        System.out.println("> Inserte el nombre de la carta");
        String nombreCarta = sn.next();
        System.out.println("");

        System.out.println("> Inserta el tipo de la carta(Formato: texto)");
        String tipo = sn.next();
        System.out.println("");

        System.out.println("> Inserta el simbolo de expansion(ORI)");
        String simboloExpansion = sn.next();
        System.out.println("");

        System.out.println("> Inserta la rareza(Formato:Un caracter)");
        String campoRareza = sn.next();
        char rareza = campoRareza.charAt(0);
        System.out.println("");

        System.out.println("> Inserta el coste de mana(Debe tener el siguiente formato:{}{})");
        String costeMana = sn.next();
        System.out.println("");

        System.out.println("> Inserta el coste de mana convertido(Formato numerico)");
        int costeManaConvertido = sn.nextInt();
        System.out.println("");

        System.out.println("> Inserta la fuerza(Formato numerico)");
        String fuerza = sn.next();
        System.out.println("");

        System.out.println("> Inserta la resistencia(Formato numerico)");
        String resistencia = sn.next();
        System.out.println("");

        System.out.println("> Inserta la lealtad(Formato numerico)");
        int loyalty = sn.nextInt();
        System.out.println("");

        System.out.println("> Inserta la descripcion de la carta(Formato texto)");
        String descripcion = sn.next();
        System.out.println("");

        System.out.println("> Inserte el codigo de artista(Formato numerico)");
        int codigoArtista = sn.nextInt();
        System.out.println("");

        System.out.println("> Inserta el color(Formato texto)");
        String color = sn.next();
        System.out.println("");

        System.out.println("> Inserta el mana generado(Formato texto)");
        String generatedMana = sn.next();
        System.out.println("");

        System.out.println("> Inserta el formato");
        String nombreFormato = str.nextLine();
        return new Carta(id, nombreCarta, tipo, simboloExpansion, rareza, costeMana, costeManaConvertido, fuerza, resistencia,loyalty,descripcion,codigoArtista,
        color,generatedMana,nombreFormato);

    }
}
