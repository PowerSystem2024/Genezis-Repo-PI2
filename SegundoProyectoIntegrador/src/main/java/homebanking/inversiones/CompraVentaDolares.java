package homebanking.inversiones;
import homebanking.*;

import java.util.Scanner;

public class CompraVentaDolares {
    private double tipoCambioCompra;
    private double tipoCambioVenta;
    private Cuenta cuenta;

    public CompraVentaDolares(Cuenta nuevaCuenta) {
        cuenta = nuevaCuenta;
        // Inicializar tipos de cambio en el constructor en lugar de en gestionarCompraVentaDolares
        tipoCambioCompra = 1190;
        tipoCambioVenta = 1180;
    }

    private void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private void pausar() {
        System.out.println("\nPresione ENTER para continuar...");
        try {
            System.in.read();
        } catch(Exception e) {}
    }

    private void mostrarMenuDolares() {
        limpiarPantalla();
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║     MENÚ COMPRA/VENTA DÓLARES      ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ 1. Comprar Dólares                 ║");
        System.out.println("║ 2. Vender Dólares                  ║");
        System.out.println("║ 0. Volver al menú principal        ║");
        System.out.println("╚════════════════════════════════════╝");
        mostrarCotizaciones();
    }

    private void mostrarCotizaciones() {
        System.out.println("\n┌────────────────────────────────────┐");
        System.out.println("│         COTIZACIONES DEL DÍA       │");
        System.out.println("├────────────────────────────────────┤");
        System.out.printf("│ Compra: $%-25.2f │%n", tipoCambioCompra);
        System.out.printf("│ Venta:  $%-25.2f │%n", tipoCambioVenta);
        System.out.println("└────────────────────────────────────┘");
        System.out.println("\nSeleccione una opción: ");
    }

    public void gestionarCompraVentaDolares() {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            mostrarMenuDolares();
            String input = scanner.nextLine();

            try {
                int opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        comprarDolares();
                        break;
                    case 2:
                        venderDolares();
                        break;
                    case 0:
                        limpiarPantalla();
                        salir = true;
                        System.out.println("Volviendo al menú de inversiones...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                        pausar();
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
                pausar();
            }
        }
    }

    private void comprarDolares() {
        Scanner sc = new Scanner(System.in);
        boolean transaccionExitosa = false;

        while (!transaccionExitosa) {
            limpiarPantalla();
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║           COMPRAR DÓLARES          ║");
            System.out.println("╚════════════════════════════════════╝");
            System.out.printf("\nSaldo disponible en pesos: $%.2f%n", cuenta.getSaldoEnPesos());
            System.out.println("\nIngrese el monto de dólares que desea comprar:");

            try {
                double monto = Double.parseDouble(sc.nextLine());

                if (monto <= 0) {
                    System.out.println("El monto debe ser mayor a 0. Inténtelo nuevamente.");
                    pausar();
                    continue;
                }

                double pesosNecesarios = monto * tipoCambioCompra;

                if (cuenta.getSaldoEnPesos() < pesosNecesarios) {
                    System.out.println("No tiene suficientes pesos para la compra. Inténtelo nuevamente.");
                    pausar();
                    continue;
                }

                cuenta.setSaldoEnPesos(cuenta.getSaldoEnPesos() - pesosNecesarios);
                cuenta.setSaldoEnDolares(cuenta.getSaldoEnDolares() + monto);

                mostrarResultadoOperacion("Compra", monto, pesosNecesarios);
                transaccionExitosa = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un monto válido.");
                pausar();
            }
        }
    }

    private void venderDolares() {
        Scanner sc = new Scanner(System.in);
        boolean transaccionExitosa = false;

        while (!transaccionExitosa) {
            limpiarPantalla();
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║           VENDER DÓLARES           ║");
            System.out.println("╚════════════════════════════════════╝");
            System.out.printf("\nSaldo disponible en dólares: USD %.2f%n", cuenta.getSaldoEnDolares());
            System.out.println("\nIngrese el monto de dólares que desea vender:");

            try {
                double montoDolares = Double.parseDouble(sc.nextLine());

                if (montoDolares <= 0) {
                    System.out.println("El monto debe ser mayor a 0. Inténtelo nuevamente.");
                    pausar();
                    continue;
                }

                if (montoDolares > cuenta.getSaldoEnDolares()) {
                    System.out.println("No tiene suficientes dólares para la venta. Inténtelo nuevamente.");
                    pausar();
                    continue;
                }

                double pesosARecibir = montoDolares * tipoCambioVenta;
                cuenta.setSaldoEnDolares(cuenta.getSaldoEnDolares() - montoDolares);
                cuenta.setSaldoEnPesos(cuenta.getSaldoEnPesos() + pesosARecibir);

                mostrarResultadoOperacion("Venta", montoDolares, pesosARecibir);
                transaccionExitosa = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un monto válido.");
                pausar();
            }
        }
    }

    private void mostrarResultadoOperacion(String tipoOperacion, double montoDolares, double montoEnPesos) {
        limpiarPantalla();
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║         RESULTADO OPERACIÓN        ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.printf("║ %s exitosa de:                  ║%n", tipoOperacion);
        System.out.printf("║ USD %-27.2f    ║%n", montoDolares);
        System.out.printf("║ $ %-29.2f    ║%n", montoEnPesos);
        System.out.println("╠════════════════════════════════════╣");
        System.out.printf("║ Saldo en pesos:  $%-16.2f ║%n", cuenta.getSaldoEnPesos());
        System.out.printf("║ Saldo en dólares: USD %-13.2f║%n", cuenta.getSaldoEnDolares());
        System.out.println("╚════════════════════════════════════╝");

        pausar();
    }
}