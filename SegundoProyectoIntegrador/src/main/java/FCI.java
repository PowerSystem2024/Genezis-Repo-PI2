package SubModulo_FCI;

import java.util.Scanner;

public class SubModulo_FCI {
    private double[] saldoDeCuenta; //Arreglo que almacena el saldo de la cuenta
    private double montoInvertidoFondoA = 0, montoInvertidoFondoB = 0, montoInvertidoFondoC = 0; 
    private double montoAInvertirFondoA = 0, montoAInvertirFondoB = 0, montoAInvertirFondoC = 0; 

    //Constructor que recibe el saldo inicial y lo asigna a la cuenta
    public SubModulo_FCI(double saldoInicial) {
        this.saldoDeCuenta = new double[]{saldoInicial};
    }

    //Método para mostrar el menú de opciones para el usuario
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcionFondo; 

        do {
            //Aquí nos muestra las opciones de fondos disponibles
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

            switch (opcionFondo) {
                case 1:
                    invertirEnFondo("A", 1.05, sc); 
                    break;
                case 2:
                    invertirEnFondo("B", 1.10, sc); 
                    break;
                case 3:
                    invertirEnFondo("C", 1.15, sc); 
                    break;
                case 4:
                    mostrarResumen(); //Muestra el resumen de inversiones
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
        } while (opcionFondo != 5); //Repite hasta que el usuario elija salir
    }

    //Aquí va a gestionar la inversión en un fondo específico
    private void invertirEnFondo(String fondo, double rentabilidad, Scanner sc) {
        limpiarPantalla();
        System.out.println("==============================================================");
        System.out.println("                  Detalles del Fondo " + fondo);
        System.out.println("==============================================================");
        System.out.println("  - Rentabilidad: " + (int)((rentabilidad - 1) * 100) + "%");
        System.out.println("  - Riesgo: " + (fondo.equals("A") ? "Bajo" : (fondo.equals("B") ? "Medio" : "Alto")));
        System.out.println("  - Composición: " + (fondo.equals("A") ? "70% bonos, 30% acciones" :
                (fondo.equals("B") ? "50% bonos, 50% acciones" : "30% bonos, 70% acciones")));
        System.out.println("");
        System.out.print("¿Desea Invertir en este Fondo (Y/N)? ");
        String tipoFondo = sc.next().toLowerCase(); 

        
        while (!tipoFondo.equals("y") && !tipoFondo.equals("n")) {
            limpiarPantalla();
            System.out.println("==============================================================");
            System.out.println("                  Detalles del Fondo " + fondo);
            System.out.println("==============================================================");
            System.out.print("No válido, ingréselo de nuevo (Y/N): ");
            tipoFondo = sc.next().toLowerCase();
        }

        
        if (tipoFondo.equals("y")) {
            limpiarPantalla();
            System.out.println("==============================================================");
            System.out.println("                  Fondo " + fondo + " - Seleccionado");
            System.out.println("==============================================================");
            System.out.print("Ingrese el Monto que desea invertir: ");
            double montoAInvertir = sc.nextDouble(); 

            
            while (montoAInvertir < 0 || montoAInvertir > saldoDeCuenta[0]) {
                if (montoAInvertir < 0) {
                    limpiarPantalla();
                    System.out.println("==============================================================");
                    System.out.println("                  Fondo " + fondo + " - Seleccionado");
                    System.out.println("==============================================================");
                    System.out.print("Ingrese un Monto POSITIVO: ");
                } else {
                    limpiarPantalla();
                    System.out.println("==============================================================");
                    System.out.println("                  Fondo " + fondo + " - Seleccionado");
                    System.out.println("==============================================================");
                    System.out.print("Saldo insuficiente, ingrese un monto válido: ");
                }
                montoAInvertir = sc.nextDouble(); 
            }

            saldoDeCuenta[0] -= montoAInvertir; //Resta el monto invertido del saldo de la cuenta
            double montoInvertido = montoAInvertir * rentabilidad; //Calcula el retorno de la inversión

            //Asigna el monto invertido y retorna según el fondo
            if (fondo.equals("A")) {
                montoAInvertirFondoA = montoAInvertir;
                montoInvertidoFondoA = montoInvertido;
            } else if (fondo.equals("B")) {
                montoAInvertirFondoB = montoAInvertir;
                montoInvertidoFondoB = montoInvertido;
            } else {
                montoAInvertirFondoC = montoAInvertir;
                montoInvertidoFondoC = montoInvertido;
            }

            limpiarPantalla();
            System.out.println("==============================================================");
            System.out.println("                  Fondo " + fondo + " - Seleccionado");
            System.out.println("==============================================================");
            System.out.printf("Saldo de cuenta: $%.2f%n", saldoDeCuenta[0]);
            System.out.printf("Usted ha invertido en el Fondo " + fondo + ": $%.2f%n", montoAInvertir);
            System.out.printf("En un mes usted obtendrá: $%.2f%n", montoInvertido);
        }
        System.out.println("Presione Enter para volver al menú de fondos.");
        sc.nextLine();
        sc.nextLine(); 
    }

    //Muestra un resumen de las inversiones
    private void mostrarResumen() {
        limpiarPantalla();
        System.out.println("==============================================================");
        System.out.println("                  Resumen de Inversiones");
        System.out.println("==============================================================");
        // Muestra los detalles de las inversiones en cada fondo
        System.out.printf("Monto invertido en el Fondo A: $%.2f - Retorno: $%.2f%n", montoAInvertirFondoA, montoInvertidoFondoA);
        System.out.printf("Monto invertido en el Fondo B: $%.2f - Retorno: $%.2f%n", montoAInvertirFondoB, montoInvertidoFondoB);
        System.out.printf("Monto invertido en el Fondo C: $%.2f - Retorno: $%.2f%n", montoAInvertirFondoC, montoInvertidoFondoC);
        System.out.printf("Saldo de cuenta actual: $%.2f%n", saldoDeCuenta[0]);
        System.out.println("Presione Enter para volver al menú de fondos.");
        new Scanner(System.in).nextLine(); 
    }

    //Limpia la pantalla
    private void limpiarPantalla() {
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
    }
}


