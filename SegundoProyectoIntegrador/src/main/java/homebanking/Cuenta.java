package homebanking;

import java.util.Random;
import java.util.Scanner;

public class Cuenta {
    private String numeroCuenta;
    private String titular;
    private double saldoEnPesos;
    private double saldoEnDolares;
    private String tipoCuenta;
    private boolean estaActiva;

    // Constructor corregido para incluir todos los parámetros necesarios
    public Cuenta(String numeroCuenta, String titular, double saldoEnPesos, double saldoEnDolares, String tipoCuenta, boolean estaActiva) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldoEnPesos = saldoEnPesos;
        this.saldoEnDolares = saldoEnDolares;
        this.tipoCuenta = tipoCuenta;
        this.estaActiva = estaActiva;
    }

    // Getters and setters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldoEnPesos() {
        return saldoEnPesos;
    }

    public void setSaldoEnPesos(double saldoEnPesos) {
        this.saldoEnPesos = saldoEnPesos;
    }

    public double getSaldoEnDolares() {
        return saldoEnDolares;
    }

    public void setSaldoEnDolares(double saldoEnDolares) {
        this.saldoEnDolares = saldoEnDolares;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public boolean isEstaActiva() {
        return estaActiva;
    }

    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }

    // Método para generar un número aleatorio de cuenta
    private static String generarNumeroAleatorio() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    // Método para seleccionar el tipo de cuenta con validación
    public static String seleccionarTipoCuenta(Scanner sc) {
        while (true) {
            try {
                System.out.println("Seleccione el tipo de cuenta:");
                System.out.println("1. homebanking.Cuenta Corriente");
                System.out.println("2. homebanking.Cuenta de Ahorros");
                System.out.println("3. homebanking.Cuenta de nómina");
                System.out.print("Ingrese el número de su elección: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Error: Debe ingresar un número válido.");
                    sc.nextLine(); // Limpiar el buffer
                    continue;
                }

                int opcion = sc.nextInt();
                sc.nextLine(); // Consume el salto de línea

                return switch (opcion) {
                    case 1 -> "homebanking.Cuenta Corriente";
                    case 2 -> "homebanking.Cuenta de Ahorros";
                    case 3 -> "homebanking.Cuenta de nómina";
                    default -> {
                        System.out.println("Error: Opción no válida. Por favor, seleccione 1, 2 o 3.");
                        yield seleccionarTipoCuenta(sc); // Recursión para volver a intentar
                    }
                };
            } catch (Exception e) {
                System.out.println("Error: Entrada no válida. Intente nuevamente.");
                sc.nextLine(); // Limpiar el buffer
            }
        }
    }

    // Método para validar el titular
    private static String validarTitular(Scanner sc) {
        while (true) {
            System.out.print("Ingrese el titular: ");
            String titular = sc.nextLine().trim();

            if (titular.isEmpty()) {
                System.out.println("Error: El nombre del titular no puede estar vacío.");
                continue;
            }

            // Validación adicional para asegurar que solo contiene letras y espacios
            if (!titular.matches("^[a-zA-Z\\s]+$")) {
                System.out.println("Error: El nombre del titular solo debe contener letras y espacios.");
                continue;
            }

            return titular;
        }
    }

    // Método para validar el saldo inicial
    private static double validarSaldoInicial(Scanner sc, String moneda) {
        while (true) {
            try {
                System.out.printf("Ingrese el saldo inicial en %s: ", moneda);
                if (!sc.hasNextDouble()) {
                    System.out.println("Error: Debe ingresar un número válido.");
                    sc.nextLine(); // Limpiar el buffer
                    continue;
                }

                double saldo = sc.nextDouble();
                sc.nextLine(); // Consume el salto de línea

                if (saldo < 0) {
                    System.out.println("Error: El saldo inicial no puede ser negativo.");
                    continue;
                }
                return saldo;
            } catch (Exception e) {
                System.out.println("Error: Entrada no válida. Intente nuevamente.");
                sc.nextLine(); // Limpiar el buffer
            }
        }
    }

    // Método para abrir una cuenta con validaciones
    public static Cuenta abrirCuenta() {
        Scanner sc = new Scanner(System.in);

        // Generar número de cuenta
        String numeroCuenta = generarNumeroAleatorio();
        System.out.println("Número de cuenta generado: " + numeroCuenta);

        // Validar titular
        String titular = validarTitular(sc);

        // Validar saldo inicial en pesos
        double saldoEnPesos = validarSaldoInicial(sc, "pesos");

        // Validar saldo inicial en dólares
        double saldoEnDolares = validarSaldoInicial(sc, "dólares");

        // Seleccionar tipo de cuenta
        String tipoCuenta = seleccionarTipoCuenta(sc);

        return new Cuenta(numeroCuenta, titular, saldoEnPesos, saldoEnDolares, tipoCuenta, true);
    }

    // Método para reducir el saldo de la cuenta
    public void retirar(double monto) {
        if (saldoEnPesos >= monto) {
            saldoEnPesos -= monto;  // Resta el monto del saldo
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }


}