package homebanking.inversiones;
import homebanking.*;

import java.util.Scanner;

public class CompraVentaDolares {
    private double tipoCambioCompra;
    private double tipoCambioVenta;
    private Cuenta cuenta;

    public CompraVentaDolares(Cuenta nuevaCuenta) {
        cuenta = nuevaCuenta;
    }

    public void gestionarCompraVentaDolares() {
        tipoCambioCompra = 1190;
        tipoCambioVenta = 1180;

        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            MenuPrincipal.mostrarMenu();  // Asegúrate de que este menú muestra opciones claras para compra/venta de dólares
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    comprarDolares();
                    break;
                case 2:
                    venderDolares();
                    break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        }

        scanner.close();  // Cierra el Scanner después de que termine el bucle
    }


    private void comprarDolares() {
        Scanner sc = new Scanner(System.in);
        boolean transaccionExitosa = false;

        while (!transaccionExitosa) {
            System.out.println("Ingrese el monto de dólares que desea comprar:");
            double monto = sc.nextDouble();

            if (monto <= 0) {
                System.out.println("El monto debe ser mayor a 0. Inténtelo nuevamente.");
                continue;
            }

            double pesosNecesarios = monto * tipoCambioVenta;

            if (cuenta.getSaldoEnPesos() < pesosNecesarios) {
                System.out.println("No tiene suficientes pesos para la compra. Inténtelo nuevamente.");
                continue;
            }

            cuenta.setSaldoEnPesos(cuenta.getSaldoEnPesos() - pesosNecesarios);
            cuenta.setSaldoEnDolares(cuenta.getSaldoEnDolares() + monto);
            System.out.println("Compra de dólares realizada con éxito.");
            transaccionExitosa = true;
        }
    }

    private void venderDolares() {
        Scanner sc = new Scanner(System.in);
        boolean transaccionExitosa = false;

        while (!transaccionExitosa) {
            System.out.println("Ingrese el monto de dólares que desea vender:");
            double montoDolares = sc.nextDouble();

            if (montoDolares <= 0) {
                System.out.println("El monto debe ser mayor a 0. Inténtelo nuevamente.");
                continue;
            }

            if (montoDolares > cuenta.getSaldoEnDolares()) {
                System.out.println("No tiene suficientes dólares para la venta. Inténtelo nuevamente.");
                continue;
            }

            double pesosARecibir = montoDolares * tipoCambioCompra;
            cuenta.setSaldoEnDolares(cuenta.getSaldoEnDolares() - montoDolares);
            cuenta.setSaldoEnPesos(cuenta.getSaldoEnPesos() + pesosARecibir);
            System.out.println("Venta de dólares realizada con éxito. Recibiste " + pesosARecibir + " pesos.");
            transaccionExitosa = true;
        }
    }
}
