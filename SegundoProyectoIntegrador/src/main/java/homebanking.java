/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class homebanking {

    
    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de cuentas bancarias");

        // Abrir una nueva cuenta
        System.out.println("Vamos a abrir una nueva cuenta:");
        Cuenta nuevaCuenta = Cuenta.abrirCuenta();

        // Mostrar los detalles de la cuenta creada
        System.out.println("\nDetalles de la cuenta creada:");
        System.out.println("Número de cuenta: " + nuevaCuenta.getNumeroCuenta());
        System.out.println("Titular: " + nuevaCuenta.getTitular());
        System.out.println("Saldo: " + nuevaCuenta.getSaldo());
        System.out.println("Tipo de cuenta: " + nuevaCuenta.getTipoCuenta());
        System.out.println("Estado: " + (nuevaCuenta.isEstaActiva() ? "Activa" : "Inactiva"));
    }

}
