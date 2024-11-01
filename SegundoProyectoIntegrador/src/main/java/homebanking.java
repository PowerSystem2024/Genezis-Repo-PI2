/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

import java.util.Scanner;

public class homebanking {

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de cuentas bancarias");

        // Abrir una nueva cuenta
        System.out.println("Vamos a abrir una nueva cuenta:");
        Cuenta nuevaCuenta = Cuenta.abrirCuenta();

        // Mostrar los detalles de la cuenta creada
        System.out.println("\nDetalles de la cuenta creada:");
        System.out.println("Número de cuenta: " + nuevaCuenta.getNumeroCuenta());
        System.out.println("Titular: " + nuevaCuenta.getTitular());
        System.out.println("Saldo: " + nuevaCuenta.getSaldoEnPesos());
        System.out.println("Saldo en dolares: " +nuevaCuenta.getSaldoEnDolares());
        System.out.println("Tipo de cuenta: " + nuevaCuenta.getTipoCuenta());
        System.out.println("Estado: " + (nuevaCuenta.isEstaActiva() ? "Activa" : "Inactiva"));


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
    }


}
