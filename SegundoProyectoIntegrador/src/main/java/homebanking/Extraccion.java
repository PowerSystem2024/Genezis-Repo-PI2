package homebanking;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Extraccion {
    // Variables globales
    private double montoExtraccion;
    private Cuenta cuentaOrigen;

    // Constructor para inicializar la cuenta de origen
    public Extraccion(Cuenta cuenta) {
        this.cuentaOrigen = cuenta;
    }

    // Método para mostrar el menú y manejar las opciones
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar menú
            System.out.println("\n--- Menú de Cuenta Bancaria ---");
            System.out.println("1. Realizar Extracción en Pesos");
            System.out.println("2. Realizar Extracción en Dólares");
            System.out.println("3. Consultar Saldos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        realizarExtraccionConsola("PESOS");
                        break;
                    case 2:
                        realizarExtraccionConsola("DOLARES");
                        break;
                    case 3:
                        // Mostrar ambos saldos
                        System.out.println("Saldo en Pesos: $" + cuentaOrigen.getSaldoEnPesos());
                        System.out.println("Saldo en Dólares: U$D " + cuentaOrigen.getSaldoEnDolares());
                        break;
                    case 4:
                        System.out.println("Gracias por utilizar nuestro servicio. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                sc.next();
                opcion = 0;
            }
        } while (opcion != 4);
    }

    // Método modificado para realizar la extracción con tipo de moneda
    public void realizarExtraccionConsola(String tipoMoneda) {
        Scanner sc = new Scanner(System.in);
        double extraccion = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Ingrese el monto que desea retirar en " + tipoMoneda + ": ");
                extraccion = sc.nextDouble();

                if (extraccion <= 0) {
                    System.out.println("Por favor, ingrese un monto positivo.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                sc.next();
            }
        }

        realizarExtraccion(extraccion, tipoMoneda);
    }

    // Método modificado para realizar la extracción según el tipo de moneda
    public void realizarExtraccion(double extraccion, String tipoMoneda) {
        this.montoExtraccion = extraccion;

        if (tipoMoneda.equals("PESOS")) {
            if (verificarExtraccionPesos(montoExtraccion)) {
                cuentaOrigen.setSaldoEnPesos(cuentaOrigen.getSaldoEnPesos() - montoExtraccion);
                System.out.println("Extracción exitosa. Has retirado: $" + montoExtraccion);
                System.out.println("Saldo restante en pesos: $" + cuentaOrigen.getSaldoEnPesos());
            } else {
                System.out.println("Extracción fallida. Saldo insuficiente en pesos.");
            }
        } else {  // DOLARES
            if (verificarExtraccionDolares(montoExtraccion)) {
                cuentaOrigen.setSaldoEnDolares(cuentaOrigen.getSaldoEnDolares() - montoExtraccion);
                System.out.println("Extracción exitosa. Has retirado: U$D " + montoExtraccion);
                System.out.println("Saldo restante en dólares: U$D " + cuentaOrigen.getSaldoEnDolares());
            } else {
                System.out.println("Extracción fallida. Saldo insuficiente en dólares.");
            }
        }
    }

    // Método para verificar saldo en pesos
    private boolean verificarExtraccionPesos(double cantidad) {
        return cuentaOrigen.getSaldoEnPesos() >= cantidad;
    }

    // Método para verificar saldo en dólares
    private boolean verificarExtraccionDolares(double cantidad) {
        return cuentaOrigen.getSaldoEnDolares() >= cantidad;
    }
}