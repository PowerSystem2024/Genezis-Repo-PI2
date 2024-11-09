package homebanking;/* Autor: Marcos Rodriguez - Grupo Genezis TUP 2024 */

import java.util.Scanner;

public class ConsultaSaldos {
    //Variables globales que se utilizarán en los métodos
    private Cuenta cuenta;
    private Scanner sc;

    // constructor
    public ConsultaSaldos(Cuenta cuenta){
        this.cuenta = cuenta;
        this.sc = new Scanner(System.in);
    }

    // Menú interactivo

    public void mostrarMenu(){

        int opcion;

        do {
            System.out.println("Consulta de Saldos.");
            System.out.println("1.Consulta saldo de cuenta en pesos.");
            System.out.println("2.Consulta saldo de cuenta en dólares estadounidenses.");
            System.out.println("3. Regresar al menú principal.");

            //Validación para que el usuario ingrese un número
            while (!sc.hasNextInt()) {
                System.out.println("Por favor ingrese un número válido.");
                sc.next(); // Limpia el valor ingresado incorrecto
            }

            opcion = sc.nextInt();

            // Según la opcion elegida, se ejecuta una acción de las siguientes:

            switch(opcion){
                case 1:
                    consultaSaldoPesos();
                    break;
                case 2:
                    consultaSaldoDolares();
                    break;
                case 3:
                    System.out.println("Regresando al menú principal...");

                    break;
                default:
                    System.out.println("Opción inválida. Ingrese un valor correcto.");

            }

        } while (opcion != 3);

    }


    public void consultaSaldoPesos(){
        System.out.println("Saldo actual de la cuenta en pesos: $"+cuenta.getSaldoEnPesos());
    }

    public void consultaSaldoDolares(){
        System.out.println("Saldo actual de la cuenta en dólares estadounidenses: U$D "+cuenta.getSaldoEnDolares());
    }

}
