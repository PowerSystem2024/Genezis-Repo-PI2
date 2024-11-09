package homebanking;

//importacion de librerías
import java.util.Scanner;
import java.util.InputMismatchException;

public class Transferencia { //clase que se encarga de realizar transferencias -> BY Javier Quiroga
    private final Cuenta cuentaOrigen; // cuenta desde la cual se realiza la transferencia
    private static final Scanner scanner = new Scanner(System.in); // objeto para leer la entrada del usario

    // Constructor que recibe la cuenta origen para hacer las transferencias
    public Transferencia(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    // Método principal que muestra el menú de opciones y maneja la selección del tipo de transferencia (alias o CBU)
    public void iniciarTransferencia() {
        while (true) { // "Bucle que mantiene el menú de opciones activo hasta que el usuario elige regresar al menú principal.

            // Menú de opciones de transferencia
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║        MENÚ DE TRANSFERENCIAS      ║");
            System.out.println("╠════════════════════════════════════╣");
            System.out.println("║ 1. Transferir por Alias            ║");
            System.out.println("║ 2. Transferir por CBU              ║");
            System.out.println("║ 0. Volver al menú principal        ║");
            System.out.println("╚════════════════════════════════════╝");

            // Leer la opción seleccionada por el usuario
            int opcion = leerOpcion(0, 2);
            if (opcion == 0) return; // Si la opción es 0, volvemos al menú principal

            // Llamamos al método realizarTransferencia según la opción seleccionada (alias o cbu)
            realizarTransferencia(opcion == 1 ? "alias" : "cbu");
        }
    }

    // Método para realizar la transferencia, que se adapta al tipo de transferencia (alias o cbu)
    private void realizarTransferencia(String tipo) { //Método que gestiona el flujo completo de la transferencia: obtiene el destino, selecciona la moneda, valida el saldo y realiza la transferencia.
        // 1. Obtener destino
        String destino = obtenerDestino(tipo);
        if (destino == null) return;

        // 2. Seleccionar moneda (peso o dólares)
        String moneda = obtenerMoneda();
        if (moneda == null) return; // si el usario cancela retorna

        // 3. Obtener y validar monto
        while (true) {
            double monto = obtenerMonto();
            if (monto == -1) return;  // Usuario canceló la operación

            // Validar saldo disponible según la moneda seleccionada
            double saldoDisponible = moneda.equals("pesos") ?
                    cuentaOrigen.getSaldoEnPesos() :
                    cuentaOrigen.getSaldoEnDolares();

            // Si el saldo disponible es insuficiente, se muestra un mensaje y se vuelve a pedir el monto
            if (saldoDisponible < monto) {
                System.out.printf("Saldo insuficiente en %s. Saldo actual: %.2f\n",
                        moneda, saldoDisponible);
                continue;  // Si no hay suficiente saldo, vuelve a pedir el monto
            }

            // Ejecutar transferencia restando el monto del saldo en la cuenta
            if (moneda.equals("pesos")) {
                cuentaOrigen.setSaldoEnPesos(cuentaOrigen.getSaldoEnPesos() - monto);
            } else {
                cuentaOrigen.setSaldoEnDolares(cuentaOrigen.getSaldoEnDolares() - monto);
            }

            // Mostrar el resultado de la transferencia
            System.out.printf("\nTransferencia exitosa de %.2f %s\n", monto, moneda);
            System.out.printf("Desde: %s\n", cuentaOrigen.getNumeroCuenta());
            System.out.printf("Hacia %s: %s\n", tipo.toUpperCase(), destino);
            System.out.printf("Nuevo saldo en %s: %.2f\n",
                    moneda, moneda.equals("pesos") ?
                            cuentaOrigen.getSaldoEnPesos() :
                            cuentaOrigen.getSaldoEnDolares());
            return;
        }
    }

    // Método para obtener el destino (Alias o CBU) dependiendo del tipo de transferencia
    private String obtenerDestino(String tipo) {
        while (true) {
            // Pedir al usuario el alias o CBU del destinatario
            System.out.printf("\nIngrese el %s del destinatario (0 <- VOLVER AL MENÚ): ", tipo.toUpperCase());
            String input = scanner.nextLine();

            if (input.equals("0")) return null; // Si el usuario cancela, se retorna null

            // Validar el formato de alias o CBU
            if (tipo.equals("cbu") && input.matches("\\d{22}")) {
                return input; // Si el CBU tiene 22 dígitos, lo acepta
            } else if (tipo.equals("alias") && input.matches("[a-zA-Z.]+")) {
                return input; // Si el alias solo tiene letras y puntos, lo acepta
            }

            // Si el formato no es válido, mostramos un mensaje de error
            System.out.printf("Error: %s inválido. ", tipo.toUpperCase());
            System.out.println(tipo.equals("cbu") ?
                    "Debe contener 22 números." :
                    "Solo puede contener letras y puntos.");
        }
    }

    // Método para obtener la moneda seleccionada por el usuario (Pesos o Dólares)
    private String obtenerMoneda() {
        while (true) {
            // Menú para seleccionar la moneda
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║          SELECCIONAR MONEDA        ║");
            System.out.println("╠════════════════════════════════════╣");
            System.out.println("║ 1. Pesos                           ║");  // Si selecciona pesos, retorna "pesos"
            System.out.println("║ 2. Dólares                         ║");  // Si selecciona dólares, retorna "dólares"
            System.out.println("║ 0. Cancelar                        ║"); // Si cancela, retorna null
            System.out.println("╚════════════════════════════════════╝");

            // Leer la opción seleccionada
            int opcion = leerOpcion(0, 2);
            switch (opcion) {
                case 0: return null; // Si cancela, retorna null
                case 1: return "pesos"; // Si selecciona pesos, retorna "pesos"
                case 2: return "dólares"; // Si selecciona dólares, retorna "dólares"
            }
        }
    }

    // Método para obtener el monto de la transferencia, valida que sea positivo
    private double obtenerMonto() { // Solicita al usuario el monto de la transferencia y valida que sea un número positivo mayor que cero
        while (true) {
            System.out.println("\nIngrese el monto a transferir ( 0 <- VOLVER AL MENÚ):");
            try {
                double monto = scanner.nextDouble();
                scanner.nextLine();

                if (monto == 0) return -1;  // Usuario canceló, retornamos -1

                if (monto > 0) {
                    return monto; // Si el monto es mayor que cero, lo retornamos
                }

                System.out.println("El monto debe ser mayor a cero.");
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine();
            }
        }
    }

    // Método para leer una opción válida entre un rango mínimo y máximo
    private int leerOpcion(int min, int max) { // Valida que la opción ingresada por el usuario esté dentro del rango especificado
        while (true) {
            try {
                System.out.print("Ingrese su opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion >= min && opcion <= max) {
                    return opcion; // Si la opción está dentro del rango, la retornamos
                }

                System.out.println("Opción inválida.");
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine();
            }
        }
    }
}
