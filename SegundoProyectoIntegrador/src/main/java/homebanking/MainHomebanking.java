package homebanking; /**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

import homebanking.inversiones.Inversiones;
import homebanking.inversiones.PlazoFijo;

import java.util.Scanner;



public class MainHomebanking {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de cuentas bancarias");

        // Abrir una nueva cuenta
        System.out.println("Vamos a abrir una nueva cuenta:");
        Cuenta nuevaCuenta = Cuenta.abrirCuenta();

        //Instanciar el Método de homebanking.AliasCBU

        AliasCBU.InicioAliasCBU();


// -------------------------------------------------------------------------------------------------------------------
        // BUCLE PARA LLAMAR UNA OPCIÓN DEL MENÚ PRINCIPAL - GONZA

        boolean salir = false;

        while (!salir) {
            MenuPrincipal.mostrarMenu();
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    Deposito deposito = new Deposito(nuevaCuenta);
                    deposito.realizarDeposito();
                    break;
                case 2:
                    // Crear instancia de la clase que contiene el menú
                    Extraccion manejoExtracciones = new Extraccion(nuevaCuenta);

                    // Llamar al método que ejecuta el menú
                    manejoExtracciones.mostrarMenu();
                    break;
                case 3:
                    // Iniciar el proceso de transferencia
                    Transferencia transferencia = new Transferencia(nuevaCuenta); // objeto de la clase homebanking.Transferencia para gestionar la operación.
                    transferencia.iniciarTransferencia(); // Llama al método encargado de realizar la transferencia
                    break;
                case 4:
//
                    // BUCLE PARA MENÚ INVERSIONES

                    boolean salirMenu = false;

                    while (!salirMenu) {
                        Inversiones.mostrarMenuInversiones();
                        Scanner scanner2 = new Scanner(System.in);
                        int opcionMenu = scanner.nextInt();

                        switch (opcionMenu) {

                            case 1:
                                //Compra Venta de Dolares
                                break;
                            case 2:
                                //Prestamos
                                break;

                            case 3:
//
                                PlazoFijo pf = new PlazoFijo(nuevaCuenta);
                                pf.plazoFijo();
                                break;

                            case 0:
                                salirMenu = true;
                                System.out.println("Saliendo del Menú de Inversiones...");
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                        }
                    }

                    break;
                case 5:
//                    consultarSaldo();
                    ConsultaSaldos consultaSaldos = new ConsultaSaldos(nuevaCuenta);
                    consultaSaldos.mostrarMenu();

                    break;
                case 6:
//                    consultarTarjetas();
                    break;
                case 7:
//                    consultarConsumos();
                    break;
                case 8:
//                    mostrarPreguntasFrecuentes();
                    break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        }

// -------------------------------------------------------------------------------------------------------------------


    }

}
