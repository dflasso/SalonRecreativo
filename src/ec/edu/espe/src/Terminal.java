package ec.edu.espe.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Oracle Academy Prácticas - Sección 7: Noche de diversión en el salón
 * recreativo
 *
 * @Dany Fernando Familia Lasso Ayala
 */
public class Terminal {

    private List<Tarjeta> tarjetas;
    private List<CategoriaPremio> categoriaPremios;

    public Terminal(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
        inicializarPremios();
    }

    public void inicializarPremios() {
        categoriaPremios = new ArrayList<CategoriaPremio>();
        categoriaPremios.add(new CategoriaPremio("peluche", 10));
        categoriaPremios.add(new CategoriaPremio("juguete", 20));
        categoriaPremios.add(new CategoriaPremio("silbato", 30));
    }

    public List<Tarjeta> menuTerminal() {

        int opcion = 0;

        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("Menu del Terminal");
            System.out.println("1.- Cargar créditos en tarjeta");
            System.out.println("2.- Transfiera el saldo de créditos y tickets");
            System.out.println("3.- Consultar saldo Tarjetas");
            System.out.println("4.- Solicitar Premios");
            System.out.println("5.- Regresar");

            System.out.println("Presione enter para continuar...");
            sc.nextLine();
            System.out.println("Ingrese la opcion");
            opcion = sc.nextInt();

            responderSeleccionUsuario(opcion);
        } while (opcion != 5);
        return this.tarjetas;
    }

    public void responderSeleccionUsuario(int opcion) {
        switch (opcion) {
            case 1: //Cargar créditos en tarjeta
                SeleccionarTarjetas();
                break;
            case 2:
                transferirSaldos();
                break;
            case 3:
                ConsultarTarjetas();
                break;
            case 4:
                 solicitarPremios();
                break;
            case 5:
                break;
            default:
                break;
        }
    }

    public void SeleccionarTarjetas() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("\n\n1.-Desea desplegar el numero de las tarjetas registradas");
            System.out.println("2.- Ingresar el Numero de la tarjeta que para cargar los creditos");
            System.out.println("3.- Regresar");

            System.out.println("Presione enter para continuar...");
            sc.nextLine();
            System.out.println("Ingrese la opcion");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    desplgarTarjetasRegistradas();
                    break;
                case 2:
                    Tarjeta tarjeta = buscarTarjeta();
                    CargarCreditoTarjetas(tarjeta);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("La opcion ingresada no existe... ");
                    break;

            }
        } while (opcion != 3);

    }

    public void ConsultarTarjetas() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n\n1.-Desea desplegar el numero de las tarjetas registradas");
            System.out.println("2.- Ingresar el Numero de la tarjeta ");
            System.out.println("3.- Regresar");

            System.out.println("Presione enter para continuar...");
            sc.nextLine();
            System.out.println("Ingrese la opcion");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    desplgarTarjetasRegistradas();
                    break;
                case 2:
                    Tarjeta tarjeta = buscarTarjeta();
                    mostrarSaldosTarjeta(tarjeta);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("La opcion ingresada no existe... ");
                    break;

            }
        } while (opcion != 3);

    }

    public void desplgarTarjetasRegistradas() {
        System.out.println("Tarjetas Registradas");
        for (Tarjeta tarjeta : this.tarjetas) {
            System.out.println("Numero de tarjeta:  " + tarjeta.getNumTarjeta());
        }
    }

    public Tarjeta buscarTarjeta() {
        Tarjeta tarjetaBuscada = null;
        int numTarjeta = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el numero de la Tarjeta  (1001 o 1002)");
        numTarjeta = sc.nextInt();

        for (Tarjeta tarjeta : this.tarjetas) {
            if (tarjeta.getNumTarjeta() == numTarjeta) {
                tarjetaBuscada = tarjeta;
            }
        }

        if (tarjetaBuscada == null) {
            System.out.println("No se encontro la tarjeta ingresada\n\n");
        }
        return tarjetaBuscada;
    }

    public void CargarCreditoTarjetas(Tarjeta tarjeta) {
        int dolares = 0;
        int creditos = 0;
        Scanner sc = new Scanner(System.in);

        if (tarjeta != null) {

            do {
                System.out.println("Ingrese el valor en dolares que desea cargar a la tarjeta");
                dolares = sc.nextInt();
                System.out.println(((dolares < 1) ? "Ingrese un valor mayor a cero, por favor.\n" : ""));
            } while (dolares < 1);

            creditos = dolares * 2;

            for (Tarjeta tarjeta1Registro : this.tarjetas) {
                if (tarjeta1Registro.getNumTarjeta() == tarjeta.getNumTarjeta()) {
                    tarjeta1Registro.setCredito(creditos);
                    System.out.println("Registro exitoso!! \n\n");
                    mostrarSaldosTarjeta(tarjeta1Registro);
                }
            }

        }
    }

    public void mostrarSaldosTarjeta(Tarjeta tarjeta) {
        System.out.println("Numero Tarjet " + tarjeta.getNumTarjeta());
        System.out.println("Saldo Credito " + tarjeta.getCredito());
        System.out.println("Saldo Tickets " + tarjeta.getTickets());
    }

    public void transferirSaldos() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n\n1.-Desea desplegar el numero de las tarjetas registradas");
            System.out.println("2.- Hacer la transferencia ");
            System.out.println("3.- Regresar");

            System.out.println("Presione enter para continuar...");
            sc.nextLine();
            System.out.println("Ingrese la opcion");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    desplgarTarjetasRegistradas();
                    break;
                case 2:
                    editarSaldos();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("La opcion ingresada no existe... ");
                    break;

            }
        } while (opcion != 3);

    }

    public void editarSaldos() {
        System.out.println("Tarjeta que va a transferir sus saldos ");
        Tarjeta tarjetaEmisora = buscarTarjeta();

        System.out.println("Tarjeta que va a recibir sus saldos ");
        Tarjeta tarjetaReceptora = buscarTarjeta();

        int valorTransferencia = 0;
        if (tarjetaEmisora != null && tarjetaReceptora != null) {

            valorTransferencia = transferirSaldo(tarjetaEmisora.getCredito(), "credito");

            tarjetaEmisora.setCredito(tarjetaEmisora.getCredito() - valorTransferencia);

            tarjetaReceptora.setCredito(tarjetaReceptora.getCredito() + valorTransferencia);

            valorTransferencia = transferirSaldo(tarjetaEmisora.getCredito(), "tickets");

            tarjetaEmisora.setTickets(tarjetaEmisora.getTickets() - valorTransferencia);

            tarjetaReceptora.setTickets(tarjetaReceptora.getTickets() + valorTransferencia);

            actualizarValores(tarjetaEmisora);
            actualizarValores(tarjetaReceptora);
        }

    }

    public int transferirSaldo(int saldo, String tipoTransferencia) {
        int opcion = 0;
        int valor = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Desea transferir su " + tipoTransferencia + " ?");
            System.out.println("1.- Si");
            System.out.println("2.- No");
            opcion = sc.nextInt();
            if (opcion == 1) {

                do {
                    System.out.println("Ingrese el valor del saldo que va a transferir");
                    valor = sc.nextInt();
                    System.out.println(((saldo <= valor) ? "El valor ingresado supera el saldo actual" : ""));
                } while (saldo <= valor);
                opcion = 2;
            }
        } while (opcion != 2);
        return valor;
    }

    public void actualizarValores(Tarjeta tarjeta) {
        for (Tarjeta tarjetaRegistrada : this.tarjetas) {
            if (tarjetaRegistrada.getNumTarjeta() == tarjeta.getNumTarjeta()) {
                tarjetaRegistrada.setCredito(tarjeta.getCredito());
                tarjetaRegistrada.setTickets(tarjeta.getTickets());
                System.out.println("Registro exitoso!! \n\n");
                mostrarSaldosTarjeta(tarjetaRegistrada);
            }
        }
    }

    public void solicitarPremios() {
        boolean salir = true;
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        Tarjeta tarjetaSeleccionada =null;
        do {
            System.out.println("Premios disponibles");

            for (int i = 0; i < categoriaPremios.size(); i++) {
                System.out.println(i + ") Nombre: " + categoriaPremios.get(i).getNombre() + "Tickets: " + categoriaPremios.get(i).getNumTickets());
            }
            System.out.println(categoriaPremios.size() + ") Regresar");

            System.out.println("Presione enter para continuar...");
            sc.nextLine();
            System.out.println("Ingrese la opcion");
            opcion = sc.nextInt();
            
            if(opcion  >= 0 && opcion < categoriaPremios.size() ){
                salir = false;
                tarjetaSeleccionada = buscarTarjeta();
                if(tarjetaSeleccionada != null){
                    if(tarjetaSeleccionada.getTickets() >= categoriaPremios.get(opcion).getNumTickets()){
                        tarjetaSeleccionada.setTickets(tarjetaSeleccionada.getTickets() -  categoriaPremios.get(opcion).getNumTickets());
                        actualizarValores(tarjetaSeleccionada);
                    }
                }
            }else if(opcion == categoriaPremios.size()){
                salir = false;
            }else{
                System.out.println("No existe el premio seleccionado...");
            }
            
        } while (salir);

    }
}
