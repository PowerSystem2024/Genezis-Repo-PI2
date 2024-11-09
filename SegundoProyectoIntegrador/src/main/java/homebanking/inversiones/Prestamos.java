package homebanking.inversiones;
import homebanking.Cuenta;
import java.util.Scanner;

public class Prestamos {
    private String tipo;
    private double tasaInteres;
    private int plazo;
    private double monto;
    private Cuenta cuenta;
    private boolean prestamoActivo;  // Indica si hay un préstamo activo para pagar

    // Constructor para inicializar la cuenta
    public Prestamos(Cuenta nuevaCuenta) {
        this.cuenta = nuevaCuenta;
        this.prestamoActivo = false; // Inicialmente no hay préstamo activo
    }

    // Método para calcular la cuota mensual
    public double calcularCuotaMensual() {
        double tasaMensual = tasaInteres / 12 / 100;
        int numPagos = plazo * 12;
        return monto * tasaMensual * Math.pow(1 + tasaMensual, numPagos) / (Math.pow(1 + tasaMensual, numPagos) - 1);
    }

    private static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║          MENÚ DE PRÉSTAMOS DISPONIBLES                          ║");
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Solicitar Préstamo PERSONAL    -> TASA: 35% - PLAZO: 3 años  ║");
        System.out.println("║ 2. Solicitar Préstamo HIPOTECARIO -> TASA: 40% - PLAZO: 20 años ║");
        System.out.println("║ 3. Solicitar Préstamo AUTOMOTRIZ  -> TASA: 50% - PLAZO: 5 años  ║");
        System.out.println("║ 4. Pagar Cuota Mensual del Préstamo                             ║");
        System.out.println("║ 0. Salir                                                        ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
    }

    public void inicioPrestamos() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Préstamo Personal
                    solicitarPrestamo(35.0, 3, "personal");
                    break;

                case 2:
                    // Préstamo Hipotecario
                    solicitarPrestamo(40.0, 20, "hipotecario");
                    break;

                case 3:
                    // Préstamo Automotriz
                    solicitarPrestamo(50.0, 5, "automotriz");
                    break;

                case 4:
                    // Pagar cuota mensual
                    pagarCuota();
                    break;

                case 0:
                    System.out.println("Saliendo del programa de préstamos...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private void solicitarPrestamo(double tasa, int plazo, String tipoPrestamo) {
        if (prestamoActivo) {
            System.out.println("Ya tiene un préstamo activo. Debe pagarlo antes de solicitar otro.");
            return;
        }

        this.tasaInteres = tasa;
        this.plazo = plazo;
        this.tipo = tipoPrestamo;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el monto del préstamo " + tipoPrestamo + ": ");
        this.monto = scanner.nextDouble();
        cuenta.setSaldoEnPesos(cuenta.getSaldoEnPesos() + monto); // Sumar el monto del préstamo al saldo
        prestamoActivo = true;  // Marcar el préstamo como activo

        System.out.printf("Préstamo %s aprobado. Nuevo saldo en cuenta: $%.2f%n", tipoPrestamo, cuenta.getSaldoEnPesos());
    }

    private void pagarCuota() {
        if (!prestamoActivo) {
            System.out.println("No tiene ningún préstamo activo para pagar.");
            return;
        }

        double cuota = calcularCuotaMensual();

        if (cuenta.getSaldoEnPesos() >= cuota) {
            cuenta.setSaldoEnPesos(cuenta.getSaldoEnPesos() - cuota);  // Restar la cuota del saldo
            System.out.printf("Cuota mensual de $%.2f pagada. Nuevo saldo en cuenta: $%.2f%n", cuota, cuenta.getSaldoEnPesos());
            System.out.printf("Préstamo %s en proceso de pago. Recuerde abonar la siguiente cuota el próximo mes.%n", tipo);
        } else {
            System.out.println("Saldo insuficiente para pagar la cuota mensual. Por favor, deposite más fondos.");
        }
    }
}
