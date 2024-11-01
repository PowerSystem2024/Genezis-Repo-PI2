package módulo_inversiones;

import java.util.Scanner;

public class Inversiones {
    public static void main(String[] args) {
        double[] saldoDeCuenta = {10000};   // Saldo inicial de cuenta
        double[] saldoEnDolares = {500};    // Saldo inicial en dólares
        double[] saldoPlazoFijo = {2000};   // Saldo inicial en plazo fijo

        // Llama al método de inversiones con las variables iniciales
        inversiones(saldoDeCuenta, saldoEnDolares, saldoPlazoFijo);
    }

    public static void inversiones(double[] saldoDeCuenta, double[] saldoEnDolares, double[] saldoPlazoFijo) {
        Scanner scanner = new Scanner(System.in);
        int opcionMainInversiones;

        // Menú principal
        do {
            
            System.out.println("\n");
            
            // Muestra el menú
            System.out.println("==============================================================");
            System.out.println("                     MIS INVERSIONES");
            System.out.println("==============================================================");
            System.out.println("1. Compra y venta de Dolares");
            System.out.println("2. Plazo Fijo");
            System.out.println("3. Fondo Común de Inversión");
            System.out.println("4. Prestamos");
            System.out.println("5. Salir al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcionMainInversiones = scanner.nextInt();

            // Ejecutamos la opción seleccionada
            switch (opcionMainInversiones) {
                case 1:
                    System.out.println("Compra y venta de Dólares");
                    compraVentaUSD(saldoDeCuenta, saldoEnDolares);
                    break;
                case 2:
                    System.out.println("Plazo Fijo");
                    plazoFijo(saldoDeCuenta, saldoPlazoFijo);
                    break;
                case 3:
                    System.out.println("Fondo Común de Inversión");
                    mostrarFondos(saldoDeCuenta);
                    break;
                case 4:
                    System.out.println("Préstamos");
                    mostrarPrestamos(saldoDeCuenta);
                    break;
                case 5:
                    System.out.println("Saliendo al MENÚ PRINCIPAL");
                    try {
                        Thread.sleep(2000); // Pausa de 2 segundos
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo con una opción correcta.");
                    break;
            }
        } while (opcionMainInversiones != 5);
    }

    
    public static void compraVentaUSD(double[] saldoDeCuenta, double[] saldoEnDolares) {       
        System.out.println("Función de Compra y Venta de Dólares");
    }
    
    public static void plazoFijo(double[] saldoDeCuenta, double[] saldoPlazoFijo) {
        System.out.println("Función de Plazo Fijo");
    }

    public static void mostrarFondos(double[] saldoDeCuenta) {
        System.out.println("Función de Fondo Común de Inversión");
    }

    public static void mostrarPrestamos(double[] saldoDeCuenta) {
        System.out.println("Función de Préstamos");
    }
}
