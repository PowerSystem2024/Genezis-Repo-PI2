package homebanking.inversiones;

import homebanking.Cuenta;

import java.util.Scanner;

public class PlazoFijo {

    public Cuenta cuenta;

    public void plazoFijo() {
        System.out.println("Función de Plazo Fijo");
        Scanner sc = new Scanner(System.in);

        final double TASA_INTERES_30 = 0.32;
        final double TASA_INTERES_90 = 0.39;
        final double TASA_INTERES_180 = 0.55;

        double saldoCuenta = cuenta.getSaldoEnPesos();
        double monto;

        // Solicitar monto a invertir
        do {
            System.out.println("Ingrese el monto a invertir: "); // Se solicita al usuario el monto a invertir en el PF.
            monto = sc.nextInt();

            if (monto < 0){ // Valido que el monto ingresado no sea un número negativo
                System.out.println("Ingrese un valor mayor a cero.");
                monto = sc.nextInt();
            }else if(monto > cuenta.getSaldoEnPesos()){ // Valido que el monto ingresado no sea mayor que el saldo de la cuenta.
                System.out.println("Saldo insuficiente. Su saldo actual es: "+cuenta.getSaldoEnPesos());
                System.out.println("Ingrese el monto a invertir: ");
                monto = sc.nextInt();
            }

        }while (monto <= 0 || monto > cuenta.getSaldoEnPesos()); // El bucle finaliza cuando el monto es positivo y menor al saldo de la cuenta.

        // Selección del plazo de inversión.
        System.out.println("Seleccione el plazo de inversión: ");
        System.out.println("1. 30 DÍAS ---> Tasa de Interés: 32% Anual");
        System.out.println("2. 90 DÍAS ---> Tasa de Interés: 39% Anual");
        System.out.println("3. 180 DÍAS ---> Tasa de Interés: 55% Anual");

        int opcion;

        do {
            opcion = sc.nextInt();
            if (opcion < 1 || opcion > 3){ // Valido que el usuario seleccione una opción correcta.
                System.out.println("Por favor, ingrese una opción correcta.");
                opcion = sc.nextInt();
            }
        } while(opcion < 1 || opcion > 3);

        // Cálculo del monto final según el plazo elegido.
        double montoFinal = 0;

        switch (opcion){
            case 1: // 30 DÍAS
                montoFinal = monto*(1+ TASA_INTERES_30);
                System.out.println("Plazo fijo constituido exitosamente.");
                System.out.println("En 30 días usted cobrará: $"+montoFinal);
                break;
            case 2: // 90 DÍAS
                montoFinal = monto*(1+ TASA_INTERES_90);
                System.out.println("Plazo fijo constituido exitosamente.");
                System.out.println("En 90 días usted cobrará: $"+montoFinal);
                break;
            case 3: // 180 DÍAS
                montoFinal = monto*(1+ TASA_INTERES_180);
                System.out.println("Plazo fijo constituido exitosamente.");
                System.out.println("En 180 días usted cobrará: $"+montoFinal);
                break;
        }

        // Descontar monto invertido en el PF del saldo de la cuenta

        saldoCuenta -= monto;

        cuenta.setSaldoEnPesos(saldoCuenta);

        System.out.println("Nuevo saldo de cuenta: $"+ cuenta.getSaldoEnPesos());









    }
}
