package homebanking;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Transferencia {
    private final Cuenta cuentaOrigen;
    private static final Scanner scanner = new Scanner(System.in);
    private String destinoId;
    private double monto;
    private String moneda;

    public Transferencia(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public void iniciarTransferencia() {
        while (true) {
            System.out.println("\n=== MENÚ DE TRANSFERENCIAS ===\n1. Transferir por Alias\n2. Transferir por CBU\n0. Volver");

            switch (leerOpcion(0, 2)) {
                case 0: return;
                case 1: transferir("alias"); break;
                case 2: transferir("cbu"); break;
            }
        }
    }

    private void transferir(String tipo) {
        if (!ingresarDestino(tipo)) return;
        procesarTransferencia();
    }

    private void procesarTransferencia() {
        while (true) {
            if (!seleccionarMoneda()) return;
            if (procesarMonto()) {
                if (validarTransferencia()) {
                    ejecutarTransferencia();
                    mostrarResultado();
                    return;
                }
            }
            // Si el monto es inválido o la validación falla, continúa el ciclo
            // volviendo al menú de selección de moneda
        }
    }

    private boolean ingresarDestino(String tipo) {
        while (true) {
            System.out.printf("\n=== INGRESO DE %s ===\n1. Ingresar %s\n0. Volver\n", tipo.toUpperCase(), tipo);

            if (leerOpcion(0, 1) == 0) return false;

            System.out.printf("Ingrese el %s: ", tipo);
            String input = scanner.nextLine();

            if (validarDestino(tipo, input)) {
                destinoId = input;
                return true;
            }
            System.out.printf("%s inválido. ", tipo.toUpperCase());
            System.out.println(tipo.equals("cbu") ? "Debe contener 22 números." : "Solo letras y puntos permitidos.");
        }
    }

    private boolean validarDestino(String tipo, String input) {
        return tipo.equals("cbu") ? input.matches("\\d{22}") : input.matches("[a-zA-Z.]+");
    }

    private boolean seleccionarMoneda() {
        while (true) {
            System.out.println("\n=== SELECCIÓN DE MONEDA ===\n1. Pesos\n2. Dólares\n0. Volver");

            switch (leerOpcion(0, 2)) {
                case 0: return false;
                case 1: moneda = "pesos"; return true;
                case 2: moneda = "dólares"; return true;
            }
        }
    }

    private boolean procesarMonto() {
        System.out.println("\n=== INGRESO DE MONTO ===\n1. Ingresar monto\n0. Volver");

        if (leerOpcion(0, 1) == 0) return false;

        System.out.println("Ingrese el monto a transferir:");
        try {
            monto = scanner.nextDouble();
            scanner.nextLine();
            if (monto <= 0) {
                System.out.println("El monto debe ser mayor a cero.");
                return false;
            }
            return true;
        } catch (InputMismatchException e) {
            System.out.println("Monto inválido.");
            scanner.nextLine();
            return false;
        }
    }

    private boolean validarTransferencia() {
        double saldoDisponible = moneda.equals("pesos") ?
                cuentaOrigen.getSaldoEnPesos() : cuentaOrigen.getSaldoEnDolares();

        if (saldoDisponible < monto) {
            System.out.printf("Saldo insuficiente en %s.\n", moneda);
            return false;
        }
        return true;
    }

    private void ejecutarTransferencia() {
        if (moneda.equals("pesos")) {
            cuentaOrigen.setSaldoEnPesos(cuentaOrigen.getSaldoEnPesos() - monto);
        } else {
            cuentaOrigen.setSaldoEnDolares(cuentaOrigen.getSaldoEnDolares() - monto);
        }
    }

    private void mostrarResultado() {
        System.out.printf("Transferencia exitosa de %.2f %s\nDesde: %s\nHacia: %s: %s\nSaldo actual en %s: %.2f\n",
                monto, moneda, cuentaOrigen.getNumeroCuenta(),
                destinoId.matches("\\d{22}") ? "CBU" : "Alias", destinoId,
                moneda, moneda.equals("pesos") ? cuentaOrigen.getSaldoEnPesos() : cuentaOrigen.getSaldoEnDolares());
    }

    private int leerOpcion(int min, int max) {
        while (true) {
            try {
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion >= min && opcion <= max) return opcion;
                System.out.println("Opción inválida.");
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine();
            }
        }
    }
}