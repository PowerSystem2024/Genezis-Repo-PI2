import java.util.Random;
import java.util.Scanner;

public class Cuenta {
    String numeroCuenta;
    String titular;
    double saldo;
    String tipoCuenta;
    boolean estaActiva;


    // Constructor para crear una nueva Cuenta
    public Cuenta(String numeroCuenta, String titular, double saldo, String tipoCuenta, boolean estado) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
        this.estaActiva = true;
    }

    //Metodo Getters and setters
    public String getNumeroCuenta() {return numeroCuenta;}
    public void setNumeroCuenta(String numeroCuenta) {this.numeroCuenta = numeroCuenta;}

    public String getTitular() {return titular;}
    public void setTitular(String titular) {this.titular = titular;}

    public double getSaldo() {return saldo;}
    public void setSaldo(double saldo) {this.saldo = saldo;}

    public String getTipoCuenta() {return tipoCuenta;}
    public void setTipoCuenta(String tipoCuenta) {this.tipoCuenta = tipoCuenta;}

    public boolean isEstaActiva() {return estaActiva;}
    public void setEstaActiva(boolean estaActiva) {this.estaActiva = estaActiva;}
    //================================================================================================================\\


    // Método para generar un número aleatorio
    private static String generarNumeroAleatorio() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    //metodo para Que seleccione el Tipo de cuenta con validación
    public static String seleccionarTipoCuenta(Scanner sc) {
        while (true) {
            try {
                System.out.println("Seleccione el tipo de cuenta:");
                System.out.println("1. Cuenta Corriente");
                System.out.println("2. Cuenta de Ahorros");
                System.out.println("3. Cuenta a Plazo Fijo");
                System.out.print("Ingrese el número de su elección: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Error: Debe ingresar un número válido.");
                    sc.nextLine(); // Limpiar el buffer
                    continue;
                }

                int opcion = sc.nextInt();
                sc.nextLine(); // Consume el salto de línea

                switch (opcion) {
                    case 1: return "Cuenta Corriente";
                    case 2: return "Cuenta de Ahorros";
                    case 3: return "Cuentas de nómina";
                    default:
                        System.out.println("Error: Opción no válida. Por favor, seleccione 1, 2 o 3.");
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada no válida. Intente nuevamente.");
                sc.nextLine(); // Limpiar el buffer
            }
        }
    }

    // Método para validar el titular
    private static String validarTitular(Scanner sc) {
        while (true) {
            System.out.println("Ingrese el titular: ");
            String titular = sc.nextLine().trim();

            if (titular.isEmpty()) {
                System.out.println("Error: El nombre del titular no puede estar vacío.");
                continue;
            }
            return titular;
        }
    }

    // Método para validar el saldo inicial
    private static double validarSaldoInicial(Scanner sc) {
        while (true) {
            try {
                System.out.println("Ingrese el saldo Inicial: ");
                if (!sc.hasNextDouble()) {
                    System.out.println("Error: Debe ingresar un número válido.");
                    sc.nextLine(); // Limpiar el buffer
                    continue;
                }

                double saldo = sc.nextDouble();
                sc.nextLine(); // Consume el salto de línea

                if (saldo <= 0) {
                    System.out.println("Error: El saldo inicial no puede ser negativo.");
                    continue;
                }
                return saldo;
            } catch (Exception e) {
                System.out.println("Error: Entrada no válida. Intente nuevamente.");
                sc.nextLine(); // Limpiar el buffer
            }
        }
    }

    // Método para abrir una cuenta con validaciones
    public static Cuenta abrirCuenta() {
        Scanner sc = new Scanner(System.in);

        // Generar número de cuenta
        String numeroCuenta = generarNumeroAleatorio();
        System.out.println("Número de cuenta generado: " + numeroCuenta);

        // Validar titular
        String titular = validarTitular(sc);

        // Validar saldo inicial
        double saldoInicial = validarSaldoInicial(sc);

        // Seleccionar tipo de cuenta
        String tipoCuenta = seleccionarTipoCuenta(sc);

        return new Cuenta(numeroCuenta, titular, saldoInicial, tipoCuenta, true);
    }

}