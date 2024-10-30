
import java.util.Scanner;
import java.util.InputMismatchException;
public class Transferencia {
    private Cuenta cuentaOrigen; //cuenta bancaria desde la cual se va a realizar la transferencia. Cuando se declara private, estamos asegurando que solo el código dentro de esta
                                 // clase pueda acceder directamente a esta información.
    private String aliasDestino; // Alias de la cuenta de destino
    private double monto;

    // Constructor que inicializa la cuenta de origen
    public Transferencia(Cuenta cuentaOrigen) { // Transferencia toma como parámetro una instancia de la clase Cuenta, que representa la cuenta de origen.
        this.cuentaOrigen = cuentaOrigen; // Transferencia toma como parámetro una instancia de la clase Cuenta, que representa la cuenta de origen.
    }

    // Método para iniciar el proceso de transferencia

    public void iniciarTransferencia() {  //inicia el proceso de una transferencia bancaria
        this.aliasDestino = ingresarAlias(); // solicita al usaurio que ingrese el alias
        this.monto = ingresarMonto(); // solicita que se ingrese el monto a transferir

        if (realizarTransferencia()) { // Si la transferencia fue exitosa, se ejecuta el código
            System.out.println("Transferencia exitosa de " + monto + " desde la cuenta " + cuentaOrigen.getNumeroCuenta());
        } else { // Si la transferencia falló
            System.out.println("Transferencia fallida.");
        }
    }

    // Método para realizar la transferencia
    private boolean realizarTransferencia() {
        if (verificarTransferencia()) {
            double nuevoSaldo = cuentaOrigen.getSaldo() - monto; // Si la verificación fue exitosa, se calcula el nuevo saldo restando el monto a transferir del saldo actual de la cuenta de origen.
            cuentaOrigen.setSaldo(nuevoSaldo); // Actualizar el saldo utilizando el setter
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
        if (cuentaOrigen.getSaldo() < monto) { // verifica si el saldo es menor al monto a transferir
            System.out.println("Saldo insuficiente en la cuenta de origen.");
            return false;
        }
        return true; // si el monto es positivo y hay suficiente saldo la transferencia es valida
    }

    // Método para ingresar y validar el alias de la cuenta destino
    private String ingresarAlias() {
        Scanner sc = new Scanner(System.in); // objeto para leer la entrada del usuario desde la consola
        String alias; // variable de tipo String para almacenar el alias ingresado.
        while (true) { // bucle while infinito que se ejecutará hasta que se ingrese un alias válido
            System.out.print("Ingrese el alias de la cuenta de destino: ");
            alias = sc.nextLine();
            if (alias.matches("[a-zA-Z]+")) { // verifica si el alias ingresado solo contiene letras Si es así, se sale del bucle.
                break;
            } else {
                System.out.println("Alias inválido. Ingrese un alias que solo contenga letras:");
            }
        }
        return alias;
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
                if (monto <= 0) {
                    System.out.println("El monto debe ser mayor a cero.");
                }
            } catch (InputMismatchException e) { //InputMismatchException, consume la entrada inválida para evitar bucles infinitos.
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                sc.next(); // Consume la entrada inválida
            }
        }
        return monto;
    }


}
