package homebanking;

import java.util.Scanner;

public class Deposito {
    private double montoDeposito;
    private Cuenta cuentaDestino;

    public Deposito(Cuenta cuenta) {
        this.cuentaDestino = cuenta;
    }

    public void realizarDeposito() {
        Scanner scanner = new Scanner(System.in);
        double deposito;
        String tipoMoneda;

        do {
            System.out.println("DEPOSITOS");
            System.out.println("Seleccione el tipo de moneda:");
            System.out.println("1. Pesos");
            System.out.println("2. Dólares");

            int opcionMoneda;
            do {
                System.out.println("Ingrese su opción (1 o 2): ");
                opcionMoneda = scanner.nextInt();
            } while (opcionMoneda != 1 && opcionMoneda != 2);

            tipoMoneda = (opcionMoneda == 1) ? "PESOS" : "DOLARES";

            System.out.println("Ingrese el monto que desea depositar en " + tipoMoneda + ": ");
            deposito = scanner.nextDouble();

            if (verificarDeposito(deposito)) {
                if (tipoMoneda.equals("PESOS")) {
                    cuentaDestino.setSaldoEnPesos(cuentaDestino.getSaldoEnPesos() + deposito);
                    System.out.println("Depósito exitoso.");
                    System.out.println("Su nuevo saldo en pesos es: $" + cuentaDestino.getSaldoEnPesos());
                } else {
                    cuentaDestino.setSaldoEnDolares(cuentaDestino.getSaldoEnDolares() + deposito);
                    System.out.println("Depósito exitoso.");
                    System.out.println("Su nuevo saldo en dólares es: U$D " + cuentaDestino.getSaldoEnDolares());
                }
            } else {
                System.out.println("El monto ingresado no es válido. Debe ser mayor que cero.");
            }

            System.out.println("¿Desea realizar otro depósito? (S/N): ");
            String continuar = scanner.next().toLowerCase();

            while (!continuar.equals("n") && !continuar.equals("s")) {
                System.out.println("No válido, por favor ingrese (S/N): ");
                continuar = scanner.next().toLowerCase();
            }

            if (continuar.equals("n")) {
                break;
            }
        } while (true);

        System.out.println("\nResumen final de su cuenta:");
        System.out.println("Saldo en pesos: $" + cuentaDestino.getSaldoEnPesos());
        System.out.println("Saldo en dólares: U$D " + cuentaDestino.getSaldoEnDolares());
    }

    private boolean verificarDeposito(double monto) {
        return monto > 0;
    }
}