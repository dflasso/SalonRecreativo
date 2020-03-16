package ec.edu.espe.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Oracle Academy Prácticas - Sección 7: Noche de diversión en el salón
 * recreativo En esta clase se desarrollara toda la logica del programa
 * Despliegue de menus y opciones
 *
 * @Dany Fernando Familia Lasso Ayala
 */
public class SalonRecreativo {

    private Terminal terminal;
    private List<Tarjeta> tarjetas;
    private List<Juego> juegos;

    public void App() {
        inicializarDatos();
        menuPrincipal();
    }

    /**
     * Segun los terminos del ejercicio pide que se instancien dos tarjetas y
     * los objetos que sean necesario para el funcionamiento del programa
     */
    public void inicializarDatos() {

        //creacion de las dos tarjetas
        this.tarjetas = new ArrayList<Tarjeta>();
        tarjetas.add(new Tarjeta(0, 0, 1001));
        tarjetas.add(new Tarjeta(0, 0, 1002));

        //Creacion de juegos
        this.juegos = new ArrayList<Juego>();
        juegos.add(new Juego("La culebrita", 10));
        juegos.add(new Juego("Pac - man", 20));
        juegos.add(new Juego("Solitario", 8));

        this.terminal = new Terminal(this.tarjetas);
    }

    /**
     * Despliega el menu principal de la Aplicacion
     */
    public void menuPrincipal() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("Menu Principal");
            System.out.println("1.- Terminales\n\tEn esta seccion puede:"
                    + "\n\t *Cargar créditos en tarjetas."
                    + "\n\t *Transfiera el saldo de créditos y tickets"
                    + "\n\t *Solicitar Premios");
            System.out.println("2.- Juegos");
            System.out.println("3.- Salir");

            opcion = sc.nextInt();

            responerSeleccionMenu(opcion);

        } while (opcion != 3);

    }

    /**
     * asigana el valor al campo selecionMenuPrincipal, instancia el objeto que
     * las opciones que solicita el usuario y despliega mensaje en caso de error
     *
     * @param opcionSeleccionada
     */
    public void responerSeleccionMenu(int opcionSeleccionada) {
        switch (opcionSeleccionada) {
            case 1:
                tarjetas = terminal.menuTerminal();
                break;
            case 2:
                menuJuegos();
                break;
            case 3:
                System.out.println("Cerrando la Aplicacion...");
                break;
            default:
                System.out.println("La opcion ingresada no existe... ");
                break;
        }
    }

    /**
     * Menu de Juegos
     */
    public void menuJuegos() {
        int opcion = 0;
        Tarjeta tarjetaSeleccionada;
        Scanner sc = new Scanner(System.in);
        int indexJuego = -1;
        do {
            System.out.println("1.- Seleccionar juego");
            System.out.println("2.- Desplegar juegos disponibles");
            System.out.println("3.- Regresar");

            System.out.println("Presione enter para continuar...");
            sc.nextLine();
            System.out.println("Ingrese la opcion");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.println("Seleccion la tarjeta");
                tarjetaSeleccionada = terminal.buscarTarjeta();

                if (tarjetaSeleccionada != null) {
                    indexJuego = Juego.desplegarJuegos(juegos);
                    Tarjeta tarjetaModifica = Juego.leerTarjeta(tarjetaSeleccionada, juegos.get(indexJuego).getNumCreditos());
                    if (tarjetaModifica != null) {
                        terminal.actualizarValores(tarjetaModifica);
                        terminal.mostrarSaldosTarjeta(tarjetaSeleccionada);
                    }
                }

            } else if (opcion == 2) {
                System.out.println("\n\n");
                for (Juego juegoObj : juegos) {
                    System.out.println("Nombre: " + juegoObj.getNombre() + "  Creditos: " + juegoObj.getNumCreditos());
                }
                System.out.println("\n\n");
            }

        } while (opcion != 3);
    }

}
