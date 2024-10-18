/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Cuenta {
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private String tipoCuenta;
    private boolean estaActiva;

    //contructor para crear una nueva Cuenta
    public Cuenta(String numeroCuenta, String titular, double saldo, String tipoCuenta, boolean estado) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
        this.estaActiva = true;
    }

    //metodo para abrir una cuenta
    public static Cuenta abrirCuenta(){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Ingrese el numero de cuenta: ");
        String numeroCuenta = sc.nextLine();

        System.out.println("Ingrese el titular: ");
        String titular = sc.nextLine();

        System.out.println("Ingrese el saldo Inicial: ");
        double saldoInicial = sc.nextDouble();

        System.out.println("Ingrese el tipo de cuenta: ");
        String tipoCuenta = sc.nextLine();

        return new Cuenta(numeroCuenta, titular, saldoInicial, tipoCuenta, true);
    }

    //metodo para cerrar una cuenta
    public void cerrarCuenta(){
        if(estaActiva){
            estaActiva = false;
            System.out.println("La Cuenta ha sido Cerrada");
        }else {
            System.out.println("La Cuenta ya esta cerrada");
        }
    }

}
