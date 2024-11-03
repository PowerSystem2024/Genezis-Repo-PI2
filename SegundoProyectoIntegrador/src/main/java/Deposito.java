import java.util.Scanner;

public class Deposito {
    //variables globales
    private double montoDeposito;
    private Cuenta cuentaDestino;

    //constructor
    public Deposito(Cuenta cuenta) {
        this.cuentaDestino = cuenta;
    }

    //metodo para realizar el deposito
    public void realizarDeposito() {
        Scanner scanner = new Scanner(System.in);
        double deposito;

        //comienzo de ciclo
        do {

            System.out.println("DEPOSITOS");

            System.out.println("Ingrese el monto que desea depositar: ");
            deposito = scanner.nextDouble();

            //verifica si el monto es valido
            if (verificarDeposito(deposito)) {
                cuentaDestino.agregarSaldo(deposito);
                System.out.println("Depósito exitoso.");
                System.out.println("Su nuevo saldo es: $" + cuentaDestino.obtenerSaldo());
            } else {
                System.out.println("El monto ingresado no es válido. Debe ser mayor que cero.");
            }

            System.out.println("¿Desea realizar otro depósito? (S/N): ");
            String continuar = scanner.next().toLowerCase();

            //validacion
            while (!continuar.equals("n") && !continuar.equals("s")) {
                System.out.println("No válido, por favor ingrese (N/S): ");
                continuar = scanner.next().toLowerCase();
            }

            if (continuar.equals("n")) { //si elije no continuar, se rompe el ciclo
                break;
            }

        } while (true);

        System.out.println("Gracias por utilizar el sistema de depósitos. Su saldo final es: $" + cuentaDestino.obtenerSaldo());
    }

    private boolean verificarDeposito(double monto) {
        return monto > 0;
    }
}