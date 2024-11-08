/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

import java.util.Scanner;



public class MainHomebanking {

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de cuentas bancarias");

        // Abrir una nueva cuenta
        System.out.println("Vamos a abrir una nueva cuenta:");
        Cuenta nuevaCuenta = Cuenta.abrirCuenta();

//        // Mostrar los detalles de la cuenta creada
//        System.out.println("\nDetalles de la cuenta creada:");
//        System.out.println("Número de cuenta: " + nuevaCuenta.getNumeroCuenta());
//        System.out.println("Titular: " + nuevaCuenta.getTitular());
//        System.out.println("Saldo: " + nuevaCuenta.getSaldoEnPesos());
//        System.out.println("Saldo en dolares: " +nuevaCuenta.getSaldoEnDolares());
//        System.out.println("Tipo de cuenta: " + nuevaCuenta.getTipoCuenta());
//        System.out.println("Estado: " + (nuevaCuenta.isEstaActiva() ? "Activa" : "Inactiva"));



// -------------------------------------------------------------------------------------------------------------------
        // BUCLE PARA LLAMAR UNA OPCIÓN DEL MENÚ PRINCIPAL - GONZA

        boolean salir = false;

        while (!salir) {
            MenuPrincipal.mostrarMenu();
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Cuenta.abrirCuenta();
                    break;
                case 2:
                    Deposito deposito = new Deposito(nuevaCuenta);
                    deposito.realizarDeposito();
                    break;
                case 3:
//                    realizarExtraccion();
                    break;
                case 4:
//                    realizarTransferencia();
                    break;
                case 5:
//                    realizarInversion();
                    break;
                case 6:
//                    consultarSaldo();
                    break;
                case 7:
//                    consultarTarjetas();
                    break;
                case 8:
//                    consultarConsumos();
                    break;
                case 9:
//                    mostrarPreguntasFrecuentes();
                    break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        }

// -------------------------------------------------------------------------------------------------------------------




        // Código  para transferencias
        while (true) {  // ciclo while
            System.out.println("\n¿Desea realizar una transferencia? (s/n)");
            String respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("s")) {
                // Iniciar el proceso de transferencia
                Transferencia transferencia = new Transferencia(nuevaCuenta); // objeto de la clase Transferencia para gestionar la operación.
                transferencia.iniciarTransferencia(); // Llama al método encargado de realizar la transferencia

                // Mostrar el estado de la cuenta después de la transferencia
                System.out.println("\nEstado de la cuenta después de la transferencia:");
                System.out.println("Número de cuenta: " + nuevaCuenta.getNumeroCuenta());
                System.out.println("Titular: " + nuevaCuenta.getTitular());
                System.out.println("Saldo: " + nuevaCuenta.getSaldoEnPesos());
                System.out.println("Tipo de cuenta: " + nuevaCuenta.getTipoCuenta());
                System.out.println("Estado: " + (nuevaCuenta.isEstaActiva() ? "Activa" : "Inactiva"));
            } else {
                System.out.println("Gracias por usar el sistema de homebanking.");
                break;
            }
        }
        // Crear instancia de la clase que contiene el menú
        Extraccion manejoExtracciones = new Extraccion(nuevaCuenta);

        // Llamar al método que ejecuta el menú
        manejoExtracciones.mostrarMenu();
    }


}
