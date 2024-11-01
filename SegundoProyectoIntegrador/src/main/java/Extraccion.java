import java.util.Scanner;
import java.util.InputMismatchException;

public class Extraccion {


        // Variables globales
        private double montoExtraccion;
        private Cuenta cuentaOrigen;

        // Constructor para inicializar la cuenta de origen
    public Extraccion(Cuenta cuenta) {
        this.cuentaOrigen = cuenta;
    }

    // Método para mostrar el menú y manejar las opciones
        public void mostrarMenu() {
            Scanner sc = new Scanner(System.in);
            int opcion;

            do {
                // Mostrar menú
                System.out.println("\n--- Menú de Cuenta Bancaria ---");
                System.out.println("1. Realizar Extracción");
                System.out.println("2. Consultar Saldo");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");

                // Validación de entrada para evitar errores
                try {
                    opcion = sc.nextInt();
                    switch (opcion) {
                        case 1:
                            // Opción para realizar extracción
                            realizarExtraccionConsola();
                            break;
                        case 2:
                            // Opción para consultar saldo
                            System.out.println("Saldo actual: $" + cuentaOrigen.getSaldoEnPesos());
                            break;
                        case 3:
                            // Opción para salir
                            System.out.println("Gracias por utilizar nuestro servicio. ¡Hasta luego!");
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                    sc.next(); // Limpiar la entrada incorrecta
                    opcion = 0; // Reiniciar la opción para que no salga del bucle
                }
            } while (opcion != 3); // El bucle continúa hasta que el usuario elija salir

        }

        // Método para realizar la extracción de dinero con entrada desde la consola
        public void realizarExtraccionConsola() {
            Scanner sc = new Scanner(System.in);
            double extraccion = 0;
            boolean entradaValida = false;

            // Bucle para solicitar un monto positivo y numérico
            while (!entradaValida) {
                try {
                    System.out.print("Ingrese el monto que desea retirar: ");
                    extraccion = sc.nextDouble();

                    // Validar si el monto es positivo
                    if (extraccion <= 0) {
                        System.out.println("Por favor, ingrese un monto positivo.");
                    } else {
                        entradaValida = true; // Marca la entrada como válida
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                    sc.next(); // Limpia la entrada incorrecta del scanner
                }
            }

            // Llama al método realizarExtraccion con el monto ingresado
            realizarExtraccion(extraccion);
        }

        // Método para realizar la extracción de dinero
        public void realizarExtraccion(double extraccion) {
            this.montoExtraccion = extraccion;

            if (verificarExtraccion(montoExtraccion)) {
                cuentaOrigen.retirar(montoExtraccion);
                System.out.println("Extracción exitosa. Has retirado: $" + montoExtraccion);
                System.out.println("Saldo restante en cuenta: $" + cuentaOrigen.getSaldoEnPesos());
            } else {
                System.out.println("Extracción fallida. Saldo insuficiente.");
            }
        }

        // Método para verificar si hay saldo suficiente
        private boolean verificarExtraccion(double cantidad) {
            return cuentaOrigen.getSaldoEnPesos() >= cantidad;
        }
    }



