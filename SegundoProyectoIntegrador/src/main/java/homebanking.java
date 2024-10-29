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
        System.out.println("Saldo: " + nuevaCuenta.getSaldo());
        System.out.println("Tipo de cuenta: " + nuevaCuenta.getTipoCuenta());
        System.out.println("Estado: " + (nuevaCuenta.isEstaActiva() ? "Activa" : "Inactiva"));

        // Código agregado para transferencias
        while (true) {
            // Preguntar si desea realizar una transferencia
            System.out.println("\n¿Desea realizar una transferencia? (s/n)");
            String respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("s")) {
                // Iniciar el proceso de transferencia
                System.out.print("Ingrese el alias de la cuenta de destino : ");
                String aliasDestino = sc.nextLine();

                // Validar alias
                while (!aliasDestino.matches("[a-zA-Z]+")) { //  bucle que se repetirá indefinidamente mientras el valor de aliasDestino no sea una cadena compuesta exclusivamente por letras.
                    System.out.println("Alias inválido. Ingrese un alias que solo contenga letras:");
                    aliasDestino = sc.nextLine();
                }

                double montoTransferencia = Transferencia.ingresarMonto();
                Transferencia transferencia = new Transferencia(nuevaCuenta);

                // Mostrar el estado de la cuenta después de la transferencia
                System.out.println("\nEstado de la cuenta después de la transferencia:");
                System.out.println("Número de cuenta: " + nuevaCuenta.getNumeroCuenta());
                System.out.println("Titular: " + nuevaCuenta.getTitular());
                System.out.println("Saldo: " + nuevaCuenta.getSaldo());
                System.out.println("Tipo de cuenta: " + nuevaCuenta.getTipoCuenta());
                System.out.println("Estado: " + (nuevaCuenta.isEstaActiva() ? "Activa" : "Inactiva"));
            } else {
                System.out.println("Gracias por usar el sistema de homebanking.");
                break;
            }
        }
    }

}
