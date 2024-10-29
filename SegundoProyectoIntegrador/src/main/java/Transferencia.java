
import java.util.Scanner;
import java.util.InputMismatchException;
public class Transferencia {
    private Cuenta cuentaOrigen; // Cuenta desde la cual se Realiza la transferencia

    //constructor que inicializa la cuenta de origen
    public Transferencia(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    // Método para realizar la transferencia
    public boolean realizarTransferencia(double monto) {
        if (verificarTransferencia(monto)) {
            // Resta el monto del saldo de la cuenta de origen
            cuentaOrigen.retirar(monto);
            System.out.println("Transferencia exitosa de " + monto + " desde la cuenta " + cuentaOrigen.getNumeroCuenta());
            return true;
        } else {
            // Mensaje si no se puede realizar la transferencia

            System.out.println("Transferencia fallida. Saldo Insuficiente o cuenta inactiva");
            return false;
        }
    }

    //Método para verificar si la transferencia es valida
    private boolean verificarTransferencia(double monto) {
        if (monto <= 0){
            System.out.println("El monto debe ser mayor a cero.");
            return false;
        }
        if (!cuentaOrigen.isEstaActiva()){
            System.out.println("El cuenta no esta activa.");
            return false;
        }
        if (cuentaOrigen.getSaldo()< monto){
            System.out.println("Saldo insuficiente en la cuenta origen.");
            return false;
        }
        return true;
    }
    // Método auxiliar para ingresar el monto de transferencia
    public static double ingresarMonto() {
        Scanner sc = new Scanner(System.in);
        double monto = -1;

        while (monto <= 0) {
            try {
                System.out.println("Ingrese el monto a transferir:");
                monto = sc.nextDouble();

                if (monto <= 0) {
                    System.out.println("El monto debe ser mayor a cero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                sc.next(); // Consume la entrada inválida
            }
        }
        return monto;
    }


}
