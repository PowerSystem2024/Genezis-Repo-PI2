import java.util.Random;

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

    //Metodo Para Generar un numero Aleatorio
    private static String generarNumeroAleatorio(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++){
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    //metodo para abrir una cuenta
    public static Cuenta abrirCuenta(){
        java.util.Scanner sc = new java.util.Scanner(System.in);

        String numeroCuenta = generarNumeroAleatorio();
        System.out.println("Número de cuenta generado: " + numeroCuenta);

        System.out.println("Ingrese el titular: ");
        String titular = sc.nextLine();

        System.out.println("Ingrese el saldo Inicial: ");
        double saldoInicial = sc.nextDouble();

        System.out.println("Ingrese el tipo de cuenta: ");
        String tipoCuenta = sc.nextLine();

        return new Cuenta(numeroCuenta, titular, saldoInicial, tipoCuenta, true);
    }

}
