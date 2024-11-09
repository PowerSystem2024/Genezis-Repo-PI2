package homebanking;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Transferencia {
    private Cuenta cuentaOrigen; // cuenta bancaria desde la cual se va a realizar la transferencia. Cuando se declara private, estamos asegurando que solo el código dentro de esta
    // clase pueda acceder directamente a esta información.
    private String aliasDestino; // Alias de la cuenta de destino
    private double monto; // Monto a transferir
    private String monedaSeleccionada; // variable para almacenar la moneda seleccionada (pesos o dólares)

    // Constructor que inicializa la cuenta de origen
    public Transferencia(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen; // Transferencia toma como parámetro una instancia de la clase Cuenta, que representa la cuenta de origen.
    }

    // Nuevo método para preguntar si el usuario desea realizar una transferencia
    public void IniciarTransferencia() {
        Scanner sc = new Scanner(System.in); // Objeto para leer la entrada del usuario desde la consola
        System.out.println("\n¿Desea realizar una transferencia? (s/n)"); // Solicita confirmación al usuario
        String respuesta = sc.nextLine();

        if (respuesta.equalsIgnoreCase("s")) { // Si la respuesta es afirmativa
            iniciarTransferencia(); // Inicia el proceso de transferencia llamando al método iniciarTransferencia
            mostrarEstadoCuenta(); // Muestra el estado actualizado de la cuenta después de la transferencia
        } else {
            System.out.println("Gracias por usar el sistema de transferencias."); // Mensaje de salida
        }
    }

    // Método para iniciar el proceso de transferencia
    public void iniciarTransferencia() {
        this.aliasDestino = ingresarAlias(); // solicita al usuario que ingrese el alias
        this.monedaSeleccionada = seleccionarMoneda(); // solicita al usuario seleccionar la moneda de la transferencia
        this.monto = ingresarMonto(); // solicita que se ingrese el monto a transferir

        if (realizarTransferencia()) { // Si la transferencia fue exitosa, se ejecuta el código
            System.out.println("Transferencia exitosa de " + monto + " " + monedaSeleccionada + " desde la cuenta " + cuentaOrigen.getNumeroCuenta());
        } else { // Si la transferencia falló
            System.out.println("Transferencia fallida.");
        }
    }

    // Método para realizar la transferencia
    private boolean realizarTransferencia() {
        if (verificarTransferencia()) { // verifica si la transferencia es válida
            // Actualiza el saldo de acuerdo a la moneda seleccionada
            if (monedaSeleccionada.equals("pesos")) { // Si la moneda es pesos, resta el monto del saldo en pesos
                cuentaOrigen.setSaldoEnPesos(cuentaOrigen.getSaldoEnPesos() - monto);
            } else { // Si la moneda es dólares, resta el monto del saldo en dólares
                cuentaOrigen.setSaldoEnDolares(cuentaOrigen.getSaldoEnDolares() - monto);
            }
            return true;
        }
        return false; // Si no se ejecuta el bloque if, significa que la verificación inicial falló y la transferencia no se realizó
    }

    // Método para verificar si la transferencia es válida
    private boolean verificarTransferencia() {
        if (monto <= 0) { // Verifica si el monto es menor o igual a cero
            System.out.println("El monto debe ser mayor a cero.");
            return false;
        }
        // Verifica si hay saldo suficiente en la moneda seleccionada
        if (monedaSeleccionada.equals("pesos") && cuentaOrigen.getSaldoEnPesos() < monto) { // Si se seleccionó pesos, verifica que el saldo en pesos sea suficiente
            System.out.println("Saldo insuficiente en pesos.");
            return false;
        } else if (monedaSeleccionada.equals("dólares") && cuentaOrigen.getSaldoEnDolares() < monto) { // Si se seleccionó dólares, verifica que el saldo en dólares sea suficiente
            System.out.println("Saldo insuficiente en dólares.");
            return false;
        }
        return true; // Si el monto es positivo y hay saldo suficiente en la moneda seleccionada, la transferencia es válida
    }

    // Método para seleccionar la moneda de la transferencia
    private String seleccionarMoneda() {
        Scanner sc = new Scanner(System.in); // Objeto para leer la entrada del usuario desde la consola
        while (true) { // bucle while infinito que se ejecutará hasta que se ingrese una opción válida
            System.out.println("Seleccione la moneda de la transferencia:");
            System.out.println("1. Pesos");
            System.out.println("2. Dólares");
            System.out.print("Ingrese el número de su elección: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Consume el salto de línea
            if (opcion == 1) { // Si elige la opción 1, se selecciona pesos
                return "pesos";
            } else if (opcion == 2) { // Si elige la opción 2, se selecciona dólares
                return "dólares";
            } else { // Si la opción ingresada no es válida, se muestra un mensaje de error
                System.out.println("Opción no válida. Por favor, seleccione 1 o 2.");
            }
        }
    }

    // Método para ingresar y validar el alias de la cuenta destino
    private String ingresarAlias() {
        Scanner sc = new Scanner(System.in); // objeto para leer la entrada del usuario desde la consola
        String alias; // variable de tipo String para almacenar el alias ingresado
        while (true) { // bucle while infinito que se ejecutará hasta que se ingrese un alias válido
            System.out.print("Ingrese el alias de la cuenta de destino: ");
            alias = sc.nextLine();
            if (alias.matches("[a-zA-Z.]+")) { // verifica si el alias ingresado solo contiene letras y puntos. Si es así, se sale del bucle.
                break;
            } else {
                System.out.println("Alias inválido. Ingrese un alias que solo contenga letras y puntos:");
            }
        }
        return alias; // retorna el alias una vez que es válido
    }

    // Método para ingresar el monto de transferencia
    private double ingresarMonto() {
        Scanner sc = new Scanner(System.in);
        double monto = -1;
        while (monto <= 0) {
            // bloque try-catch para manejar posibles excepciones, en este caso, si el usuario ingresa un valor que no es un número.
            try {
                System.out.println("Ingrese el monto a transferir:");
                monto = sc.nextDouble();
                if (monto <= 0) { // verifica que el monto sea mayor a cero
                    System.out.println("El monto debe ser mayor a cero.");
                }
            } catch (InputMismatchException e) { //InputMismatchException, consume la entrada inválida para evitar bucles infinitos.
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                sc.next(); // Consume la entrada inválida
            }
        }
        return monto; // retorna el monto una vez que es válido
    }

    // Método que muestra el estado de la cuenta después de la transferencia
    private void mostrarEstadoCuenta() {
        System.out.println("\nEstado de la cuenta después de la transferencia:");
        System.out.println("Número de cuenta: " + cuentaOrigen.getNumeroCuenta());
        System.out.println("Titular: " + cuentaOrigen.getTitular());
        System.out.println("Saldo en pesos: " + cuentaOrigen.getSaldoEnPesos());
        System.out.println("Saldo en dólares: " + cuentaOrigen.getSaldoEnDolares());
        System.out.println("Tipo de cuenta: " + cuentaOrigen.getTipoCuenta());
        System.out.println("Estado: " + (cuentaOrigen.isEstaActiva() ? "Activa" : "Inactiva"));
    }
}