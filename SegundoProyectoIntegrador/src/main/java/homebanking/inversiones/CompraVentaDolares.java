package homebanking.inversiones;
import homebanking.*;

import java.util.Scanner;

/**
 * Clase que maneja las operaciones de compra y venta de dólares en el sistema de homebanking
 */
public class CompraVentaDolares {
    // Variables de instancia para manejar los tipos de cambio y la cuenta del usuario
    private double tipoCambioCompra;  // Precio al que el banco compra dólares
    private double tipoCambioVenta;   // Precio al que el banco vende dólares
    private Cuenta cuenta;            // Cuenta del usuario donde se realizarán las operaciones

    /**
     * Constructor que inicializa la cuenta del usuario
     * @param nuevaCuenta Cuenta donde se realizarán las operaciones
     */
    public CompraVentaDolares(Cuenta nuevaCuenta) {
        cuenta = nuevaCuenta;
    }

    /**
     * Muestra el menú de opciones para operaciones con dólares
     */
    private void mostrarMenuDolares() {
        System.out.println("\nMenú Compra/Venta de Dólares");
        System.out.println("1. Comprar Dólares");
        System.out.println("2. Vender Dólares");
        System.out.println("0. Volver al menú principal");
        System.out.println("==================================");
    }

    /**
     * Método principal que gestiona el flujo de operaciones de compra/venta de dólares
     */
    public void gestionarCompraVentaDolares() {
        // Inicialización de los tipos de cambio
        tipoCambioCompra = 1190;  // El banco compra a 1190 pesos cada dólar
        tipoCambioVenta = 1180;   // El banco vende a 1180 pesos cada dólar

        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        // Bucle principal del menú
        while (!salir) {
            mostrarMenuDolares();
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            // Procesamiento de la opción seleccionada
            switch (opcion) {
                case 1:
                    comprarDolares();
                    break;
                case 2:
                    venderDolares();
                    break;
                case 0:
                    salir = true;
                    System.out.println("Volviendo al menú de Inversiones...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        }
    }

    /**
     * Maneja el proceso de compra de dólares
     */
    private void comprarDolares() {
        Scanner sc = new Scanner(System.in);
        boolean transaccionExitosa = false;

        while (!transaccionExitosa) {
            System.out.println("Ingrese el monto de dólares que desea comprar:");
            double monto = sc.nextDouble();

            // Validación del monto ingresado
            if (monto <= 0) {
                System.out.println("El monto debe ser mayor a 0. Inténtelo nuevamente.");
                continue;
            }

            // Cálculo del costo en pesos
            double pesosNecesarios = monto * tipoCambioVenta;

            // Verificación de saldo suficiente
            if (cuenta.getSaldoEnPesos() < pesosNecesarios) {
                System.out.println("No tiene suficientes pesos para la compra. Inténtelo nuevamente.");
                continue;
            }

            // Realización de la transacción
            cuenta.setSaldoEnPesos(cuenta.getSaldoEnPesos() - pesosNecesarios);
            cuenta.setSaldoEnDolares(cuenta.getSaldoEnDolares() + monto);

            // Mostrar resultado de la operación
            System.out.println("Compra de dólares realizada con éxito.");
            System.out.println("Saldo actual en pesos: $" + cuenta.getSaldoEnPesos());
            System.out.println("Saldo actual en dólares: USD " + cuenta.getSaldoEnDolares());
            transaccionExitosa = true;
        }
    }

    /**
     * Maneja el proceso de venta de dólares
     */
    private void venderDolares() {
        Scanner sc = new Scanner(System.in);
        boolean transaccionExitosa = false;

        while (!transaccionExitosa) {
            System.out.println("Ingrese el monto de dólares que desea vender:");
            double montoDolares = sc.nextDouble();

            // Validación del monto ingresado
            if (montoDolares <= 0) {
                System.out.println("El monto debe ser mayor a 0. Inténtelo nuevamente.");
                continue;
            }

            // Verificación de saldo suficiente
            if (montoDolares > cuenta.getSaldoEnDolares()) {
                System.out.println("No tiene suficientes dólares para la venta. Inténtelo nuevamente.");
                continue;
            }

            // Realización de la transacción
            double pesosARecibir = montoDolares * tipoCambioCompra;
            cuenta.setSaldoEnDolares(cuenta.getSaldoEnDolares() - montoDolares);
            cuenta.setSaldoEnPesos(cuenta.getSaldoEnPesos() + pesosARecibir);

            // Mostrar resultado de la operación
            System.out.println("Venta de dólares realizada con éxito. Recibiste $" + pesosARecibir + " pesos.");
            System.out.println("Saldo actual en pesos: $" + cuenta.getSaldoEnPesos());
            System.out.println("Saldo actual en dólares: USD " + cuenta.getSaldoEnDolares());
            transaccionExitosa = true;
        }
    }
}