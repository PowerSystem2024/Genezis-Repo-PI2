
package SubModulo_FCI;

import java.util.Scanner;

public class SubModulo_FCI {
    //Muestra información sobre Fondos Comunes de Inversión
    public static void mostrarFondos(double[] saldoDeCuenta) {
        Scanner sc = new Scanner(System.in);
        int opcionFondo;
        String tipoFondo;
        double montoAInvertir;
        double montoInvertidoFondoA = 0, montoInvertidoFondoB = 0, montoInvertidoFondoC = 0;
        double montoAInvertirFondoA = 0, montoAInvertirFondoB = 0, montoAInvertirFondoC = 0;

        do {
            // Muestra las opciones de fondos comunes de inversión disponibles
            System.out.println("==============================================================");
            System.out.println("                 Fondo Comun de Inversion");
            System.out.println("==============================================================");
            System.out.println("1. Fondo A - Rentabilidad: 5% - Riesgo: Bajo");
            System.out.println("2. Fondo B - Rentabilidad: 10% - Riesgo: Medio");
            System.out.println("3. Fondo C - Rentabilidad: 15% - Riesgo: Alto");
            System.out.println("");
            System.out.println("4. Ver resumen de Inversiones");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcionFondo = sc.nextInt();

            // Aquí selecciona el fondo elegido
            switch (opcionFondo) {
                case 1:
                    limpiarPantalla();
                    System.out.println("==============================================================");
                    System.out.println("                  Detalles del Fondo A");
                    System.out.println("==============================================================");
                    System.out.println("  - Rentabilidad: 5%");
                    System.out.println("  - Riesgo: Bajo");
                    System.out.println("  - Composición: 70% bonos, 30% acciones");
                    System.out.println("");
                    System.out.print("¿Desea Invertir en este Fondo (Y/N)? ");
                    tipoFondo = sc.next().toLowerCase();

                    while (!tipoFondo.equals("y") && !tipoFondo.equals("n")) {
                        limpiarPantalla();
                        System.out.println("==============================================================");
                        System.out.println("                  Detalles del Fondo A");
                        System.out.println("==============================================================");
                        System.out.print("No válido, ingréselo de nuevo (Y/N): ");
                        tipoFondo = sc.next().toLowerCase();
                    }

                    if (tipoFondo.equals("y")) {
                        limpiarPantalla();
                        System.out.println("==============================================================");
                        System.out.println("                  Fondo A - Seleccionado");
                        System.out.println("==============================================================");
                        System.out.print("Ingrese el Monto que desea invertir: ");
                        montoAInvertir = sc.nextDouble();

                        while (montoAInvertir < 0 || montoAInvertir > saldoDeCuenta[0]) {
                            if (montoAInvertir < 0) {
                                limpiarPantalla();
                                System.out.println("==============================================================");
                                System.out.println("                  Fondo A - Seleccionado");
                                System.out.println("==============================================================");
                                System.out.print("Ingrese un Monto POSITIVO: ");
                            } else {
                                limpiarPantalla();
                                System.out.println("==============================================================");
                                System.out.println("                  Fondo A - Seleccionado");
                                System.out.println("==============================================================");
                                System.out.print("Saldo insuficiente, ingrese un monto válido: ");
                            }
                            montoAInvertir = sc.nextDouble();
                        }

                        saldoDeCuenta[0] -= montoAInvertir;
                        montoAInvertirFondoA = montoAInvertir;
                        montoInvertidoFondoA = montoAInvertir * 1.05;

                        limpiarPantalla();
                        System.out.println("==============================================================");
                        System.out.println("                  Fondo A - Seleccionado");
                        System.out.println("==============================================================");
                        System.out.printf("Saldo de cuenta: $%.2f%n", saldoDeCuenta[0]);
                        System.out.printf("Usted ha invertido en el Fondo A: $%.2f%n", montoAInvertir);
                        System.out.printf("En un mes usted obtendrá: $%.2f%n", montoInvertidoFondoA);
                    }
                    System.out.println("Presione Enter para volver al menú de fondos.");
                    sc.nextLine(); 
                    sc.nextLine();
                    break;

                case 2:
                    
                    limpiarPantalla();
                    System.out.println("==============================================================");
                    System.out.println("                  Detalles del Fondo B");
                    System.out.println("==============================================================");
                    System.out.println("  - Rentabilidad: 10%");
                    System.out.println("  - Riesgo: Medio");
                    System.out.println("  - Composición: 50% bonos, 50% acciones");
                    System.out.println("");
                    System.out.print("¿Desea Invertir en este Fondo (Y/N)? ");
                    tipoFondo = sc.next().toLowerCase();

                    while (!tipoFondo.equals("y") && !tipoFondo.equals("n")) {
                        limpiarPantalla();
                        System.out.println("==============================================================");
                        System.out.println("                  Detalles del Fondo B");
                        System.out.println("==============================================================");
                        System.out.print("No válido, ingréselo de nuevo (Y/N): ");
                        tipoFondo = sc.next().toLowerCase();
                    }

                    if (tipoFondo.equals("y")) {
                        limpiarPantalla();
                        System.out.println("==============================================================");
                        System.out.println("                  Fondo B - Seleccionado");
                        System.out.println("==============================================================");
                        System.out.print("Ingrese el Monto que desea invertir: ");
                        montoAInvertir = sc.nextDouble();

                        while (montoAInvertir < 0 || montoAInvertir > saldoDeCuenta[0]) {
                            if (montoAInvertir < 0) {
                                limpiarPantalla();
                                System.out.println("==============================================================");
                                System.out.println("                  Fondo B - Seleccionado");
                                System.out.println("==============================================================");
                                System.out.print("Ingrese un Monto POSITIVO: ");
                            } else {
                                limpiarPantalla();
                                System.out.println("==============================================================");
                                System.out.println("                  Fondo B - Seleccionado");
                                System.out.println("==============================================================");
                                System.out.print("Saldo insuficiente, ingrese un monto válido: ");
                            }
                            montoAInvertir = sc.nextDouble();
                        }

                        saldoDeCuenta[0] -= montoAInvertir;
                        montoAInvertirFondoB = montoAInvertir;
                        montoInvertidoFondoB = montoAInvertir * 1.10;

                        limpiarPantalla();
                        System.out.println("==============================================================");
                        System.out.println("                  Fondo B - Seleccionado");
                        System.out.println("==============================================================");
                        System.out.printf("Saldo de cuenta: $%.2f%n", saldoDeCuenta[0]);
                        System.out.printf("Usted ha invertido en el Fondo B: $%.2f%n", montoAInvertir);
                        System.out.printf("En un mes usted obtendrá: $%.2f%n", montoInvertidoFondoB);
                    }
                    System.out.println("Presione Enter para volver al menú de fondos.");
                    sc.nextLine();
                    sc.nextLine();
                    break;

                case 3:
                    
                    limpiarPantalla();
                    System.out.println("==============================================================");
                    System.out.println("                  Detalles del Fondo C");
                    System.out.println("==============================================================");
                    System.out.println("  - Rentabilidad: 15%");
                    System.out.println("  - Riesgo: Alto");
                    System.out.println("  - Composición: 30% bonos, 70% acciones");
                    System.out.println("");
                    System.out.print("¿Desea Invertir en este Fondo (Y/N)? ");
                    tipoFondo = sc.next().toLowerCase();

                    while (!tipoFondo.equals("y") && !tipoFondo.equals("n")) {
                        limpiarPantalla();
                        System.out.println("==============================================================");
                        System.out.println("                  Detalles del Fondo C");
                        System.out.println("==============================================================");
                        System.out.print("No válido, ingréselo de nuevo (Y/N): ");
                        tipoFondo = sc.next().toLowerCase();
                    }

                    if (tipoFondo.equals("y")) {
                        limpiarPantalla();
                        System.out.println("==============================================================");
                        System.out.println("                  Fondo C - Seleccionado");
                        System.out.println("==============================================================");
                        System.out.print("Ingrese el Monto que desea invertir: ");
                        montoAInvertir = sc.nextDouble();

                        while (montoAInvertir < 0 || montoAInvertir > saldoDeCuenta[0]) {
                            if (montoAInvertir < 0) {
                                limpiarPantalla();
                                System.out.println("==============================================================");
                                System.out.println("                  Fondo C - Seleccionado");
                                System.out.println("==============================================================");
                                System.out.print("Ingrese un Monto POSITIVO: ");
                            } else {
                                limpiarPantalla();
                                System.out.println("==============================================================");
                                System.out.println("                  Fondo C - Seleccionado");
                                System.out.println("==============================================================");
                                System.out.print("Saldo insuficiente, ingrese un monto válido: ");
                            }
                            montoAInvertir = sc.nextDouble();
                        }

                        saldoDeCuenta[0] -= montoAInvertir;
                        montoAInvertirFondoC = montoAInvertir;
                        montoInvertidoFondoC = montoAInvertir * 1.15;

                        limpiarPantalla();
                        System.out.println("==============================================================");
                        System.out.println("                  Fondo C - Seleccionado");
                        System.out.println("==============================================================");
                        System.out.printf("Saldo de cuenta: $%.2f%n", saldoDeCuenta[0]);
                        System.out.printf("Usted ha invertido en el Fondo C: $%.2f%n", montoAInvertir);
                        System.out.printf("En un mes usted obtendrá: $%.2f%n", montoInvertidoFondoC);
                    }
                    System.out.println("Presione Enter para volver al menú de fondos.");
                    sc.nextLine();
                    sc.nextLine();
                    break;

                case 4:
                    limpiarPantalla();
                    System.out.println("==============================================================");
                    System.out.println("                  Resumen de Inversiones");
                    System.out.println("==============================================================");
                    System.out.printf("Monto invertido en el Fondo A: $%.2f - Retorno: $%.2f%n", montoAInvertirFondoA, montoInvertidoFondoA);
                    System.out.printf("Monto invertido en el Fondo B: $%.2f - Retorno: $%.2f%n", montoAInvertirFondoB, montoInvertidoFondoB);
                    System.out.printf("Monto invertido en el Fondo C: $%.2f - Retorno: $%.2f%n", montoAInvertirFondoC, montoInvertidoFondoC);
                    System.out.printf("Saldo de cuenta actual: $%.2f%n", saldoDeCuenta[0]);
                    System.out.println("Presione Enter para volver al menú de fondos.");
                    sc.nextLine();
                    sc.nextLine();
                    break;

                case 5:
                    limpiarPantalla();
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    limpiarPantalla();
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcionFondo != 5);
    }

    //Método para limpiar la pantalla
    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //Método principal para ejecutar el programa
    public static void main(String[] args) {
        double[] saldoDeCuenta = {100000.00}; //Saldo inicial
        mostrarFondos(saldoDeCuenta);
    }
}


