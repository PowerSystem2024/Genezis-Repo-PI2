import java.util.Random;
import java.util.Scanner;

public class Cuenta {
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private String tipoCuenta;
    private boolean estaActiva;

    // Constructor para crear una nueva Cuenta
    public Cuenta(String numeroCuenta, String titular, double saldo, String tipoCuenta, boolean estado) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
        this.estaActiva = true;
    }

    //Métodos getter
    public String getNumeroCuenta() {return numeroCuenta;}
    public String getTitular() {return titular;}
    public double getSaldo() {return saldo;}
    public String getTipoCuenta() {return tipoCuenta;}
    public boolean isEstaActiva() {return estaActiva;}


    // Método para generar un número aleatorio
    private static String generarNumeroAleatorio() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }
    //metodo para Que seleccione el Tipo de cuenta
    public static String seleccionarTipoCuenta(Scanner sc) {
        while (true){
            System.out.println("Seleccione el tipo de cuenta:");
            System.out.println("1. Cuenta Corriente");
            System.out.println("2. Cuenta de Ahorros");
            System.out.println("3. Cuenta a Plazo Fijo");
            System.out.print("Ingrese el número de su elección: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: return "Cuenta Corriente";
                case 2: return "Cuenta de Ahorros";
                case 3: return "Cuentas de nómina";
                default: return null;
            }
        }
    }

    // Método para abrir una cuenta
    public static Cuenta abrirCuenta() {
        Scanner sc = new Scanner(System.in);

        String numeroCuenta = generarNumeroAleatorio();
        System.out.println("Número de cuenta generado: " + numeroCuenta);

        System.out.println("Ingrese el titular: ");
        String titular = sc.nextLine();

        System.out.println("Ingrese el saldo Inicial: ");
        double saldoInicial = sc.nextDouble();
        sc.nextLine(); // Consume el salto de línea pendiente

        String tipoCuenta = seleccionarTipoCuenta(sc);

        return new Cuenta(numeroCuenta, titular, saldoInicial, tipoCuenta, true);
    }
}