package ec.edu.espe.src;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Dany Fernando Lasso Ayala
 */
public class Juego {

    private String nombre;
    private int numCreditos;

    public static Tarjeta leerTarjeta(Tarjeta tarjeta, int numCreditos) {
        Random randomGenerator = new Random();
        if (tarjeta.getCredito() >= numCreditos) {
            tarjeta.setCredito(tarjeta.getCredito() - numCreditos);
            tarjeta.setTickets(tarjeta.getTickets() + (randomGenerator.nextInt(9) + 1) * 10);
            return tarjeta;
        } else {
            System.out.println("No tiene los creditos suficientes, para jugar...");
            return null;
        }
        
    }

    public Juego(String nombre, int numCreditos) {
        this.nombre = nombre;
        this.numCreditos = numCreditos;
    }

    public static int desplegarJuegos(List<Juego> juegos) {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        boolean salir = true;
        
        do {

            for (int i = 0; i < juegos.size(); i++) {
                System.out.println(i + ") Nombre del juego: " + juegos.get(i).getNombre() + "  Numero de creditos: " + juegos.get(i).getNumCreditos());
            }
            System.out.println(juegos.size() + ") Regresar");

            System.out.println("Presione enter para continuar...");
            sc.nextLine();
            System.out.println("Ingrese la opcion");
            opcion = sc.nextInt();
            
            if(opcion >= 0 && opcion < juegos.size() ){
                System.out.println("Juego seleccionado " + juegos.get(opcion).getNombre());
                salir = false;
            }else if(opcion == juegos.size()){
                salir = false;
            }else{
                System.out.println("No existe el juego seleccionado...");
            }
        } while (salir);
        return opcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumCreditos() {
        return numCreditos;
    }

    public void setNumCreditos(int numCreditos) {
        this.numCreditos = numCreditos;
    }

}
