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
        Scanner sc = new Scanner(System.in);

        final double TASA_INTERES_30 = 0.32;
        final double TASA_INTERES_90 = 0.39;
        final double TASA_INTERES_180 = 0.55;
        double monto;

        // Solicitar monto a invertir
        do {
            System.out.println("Ingrese el monto a invertir: "); // Se solicita al usuario el monto a invertir en el PF.
            monto = sc.nextInt();

            if (monto < 0){ // Valido que el monto ingresado no sea un número negativo
                System.out.println("Ingrese un valor mayor a cero.");
                monto = sc.nextInt();
            }else if(monto > saldoDeCuenta[0]){ // Valido que el monto ingresado no sea mayor que el saldo de la cuenta.
                System.out.println("Saldo insuficiente. Su saldo actual es: "+saldoDeCuenta[0]);
                System.out.println("Ingrese el monto a invertir: ");
                monto = sc.nextInt();
            }

        }while (monto <= 0 || monto > saldoDeCuenta[0]); // El bucle finaliza cuando el monto es positivo y menor al saldo de la cuenta.

        // Selección del plazo de inversión.
        System.out.println("Seleccione el plazo de inversión: ");
        System.out.println("1. 30 DÍAS ---> Tasa de Interés: 32% Anual");
        System.out.println("2. 90 DÍAS ---> Tasa de Interés: 39% Anual");
        System.out.println("3. 180 DÍAS ---> Tasa de Interés: 55% Anual");

        int opcion;

        do {
            opcion = sc.nextInt();
            if (opcion < 1 || opcion > 3){ // Valido que el usuario seleccione una opción correcta.
                System.out.println("Por favor, ingrese una opción correcta.");
                opcion = sc.nextInt();
            }
        } while(opcion < 1 || opcion > 3);

        // Cálculo del monto final según el plazo elegido.
        double montoFinal = 0;

        switch (opcion){
            case 1: // 30 DÍAS
                montoFinal = monto*(1+ TASA_INTERES_30);
                System.out.println("Plazo fijo constituido exitosamente.");
                System.out.println("En 30 días usted cobrará: $"+montoFinal);
                break;
            case 2: // 90 DÍAS
                montoFinal = monto*(1+ TASA_INTERES_90);
                System.out.println("Plazo fijo constituido exitosamente.");
                System.out.println("En 90 días usted cobrará: $"+montoFinal);
                break;
            case 3: // 180 DÍAS
                montoFinal = monto*(1+ TASA_INTERES_180);
                System.out.println("Plazo fijo constituido exitosamente.");
                System.out.println("En 180 días usted cobrará: $"+montoFinal);
                break;
        }

        // Descontar monto invertido en el PF del saldo de la cuenta
        saldoDeCuenta[0] -= monto;
        System.out.println("Nuevo saldo de cuenta: $"+saldoDeCuenta[0]);









    }

    public static void mostrarFondos(double[] saldoDeCuenta) {
        System.out.println("Función de Fondo Común de Inversión");
    }

    public static void mostrarPrestamos(double[] saldoDeCuenta) {
        System.out.println("Función de Préstamos");
    }
}
