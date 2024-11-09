package homebanking.inversiones;

import java.util.Scanner;

public class Prestamos {
    private String tipo;
    private double tasaInteres;
    private int plazo;
    private double monto;

    // Constructor (para inicializar los atributos)
    public Prestamos(String tipo, double tasaInteres, int plazo, double monto) {
        this.tipo = tipo;
        this.tasaInteres = tasaInteres;
        this.plazo = plazo;
        this.monto = monto;
    }

    

    // Método para calcular la cuota mensual
    public double calcularCuotaMensual() {
        // Fórmula para calcular la cuota mensual (interés compuesto)
        double tasaMensual = tasaInteres / 12 / 100;
        int numPagos = plazo * 12;
        double cuota = monto * tasaMensual * Math.pow(1 + tasaMensual, numPagos) / (Math.pow(1 + tasaMensual, numPagos) - 1);
        return cuota;
    }

    public static void mostrarMenu() {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║          MENÚ DE PRESTAMOS DISPONIBLES                   ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Prestamos PERSONAL    -> TASA: 35% - PLAZO: 3 años    ║");
        System.out.println("║ 2. Prestamos HIPOTECARIO -> TASA: 40% - PLAZO: 20 años   ║");
        System.out.println("║ 3. Prestamos AUTOMOTRIZ  -> TASA: 50% - PLAZO: 5 años    ║");
        System.out.println("║ 0. Salir                                                 ║");
        System.out.println("║----------------------------------------------------------║");
        System.out.println("║ INGRESE UNA OPCIÓN:                                      ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }

    public static void  (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();

            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Prestamos Personal (ejemplo con monto inventado)
                    Prestamos prestamosPersonal = new Prestamos("Personal", 35, 3, 100000);
                    double cuotaMensual = prestamosPersonal.calcularCuotaMensual();
                    System.out.println("La cuota mensual del préstamo personal es: $" + cuotaMensual);
                    break;
                case 2:
                    // Prestamos Hipotecario (ejemplo con monto inventado)
                    Prestamos prestamosHipotecario = new Prestamos("Hipotecario", 40, 20, 500000);
                    cuotaMensual = prestamosHipotecario.calcularCuotaMensual();
                    System.out.println("La cuota mensual del préstamo hipotecario es: $" + cuotaMensual);
                    break;
                case 3:
                    // Prestamos Automotriz (ejemplo con monto inventado)
                    Prestamos prestamosAutomotriz = new Prestamos("Automotriz", 50, 5, 30000);
                    cuotaMensual = prestamosAutomotriz.calcularCuotaMensual();
                    System.out.println("La cuota mensual del préstamo automotriz es: $" + cuotaMensual);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }
}