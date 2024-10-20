
import java.util.Scanner;

public class FAQ {
    public static void main(String[] args) {
        FAQ();
    }

    // Método para mostrar las preguntas frecuentes
    public static void FAQ() {
        Scanner entrada = new Scanner(System.in);
        int opcionFAQs;

        do {
            // Mustra el menú de opciones de preguntas frecuentes
            System.out.println("Preguntas Frecuentes:");
            System.out.println("1. ¿Qué es un fondo común de inversión?");
            System.out.println("2. ¿Cómo puedo solicitar un préstamo?");
            System.out.println("3. ¿Qué documentos necesito para un préstamo?");
            System.out.println("4. ¿Cuánto tiempo demora el proceso de un préstamo?");
            System.out.println("5. ¿Puedo cancelar un préstamo antes del plazo establecido?");
            System.out.println("6. ¿Qué intereses se aplican a los préstamos?");
            System.out.println("7. ¿Cuáles son los requisitos para abrir una cuenta bancaria?");
            System.out.println("8. ¿Cómo puedo transferir dinero a otra cuenta?");
            System.out.println("9. ¿Cuáles son los tipos de inversiones disponibles?");
            System.out.println("10. Volver al Menú Principal");
            System.out.println("Seleccione una opción: ");
            
            opcionFAQs = Integer.parseInt(entrada.nextLine());
            
            // Selecciona la opción y muestra la respuesta correspondiente
            switch (opcionFAQs) {
                case 1 -> {
                    System.out.println("¿Qué es un fondo común de inversión?");
                    System.out.println("Un fondo común de inversión es un instrumento financiero");
                    System.out.println("que agrupa el dinero de muchos inversionistas para invertirlo en una variedad de activos.");
                }
                case 2 -> {
                    System.out.println("¿Cómo puedo solicitar un préstamo?");
                    System.out.println("Puede solicitar un préstamo visitando una sucursal bancaria");
                    System.out.println("o mediante el sitio web de la entidad financiera.");
                }
                case 3 -> {
                    System.out.println("¿Qué documentos necesito para un préstamo?");
                    System.out.println("Generalmente se requieren identificación, bono de sueldo");
                    System.out.println("y domicilio del solicitante.");
                }
                case 4 -> {
                    System.out.println("¿Cuánto tiempo demora el proceso de un préstamo?");
                    System.out.println("El proceso puede variar dependiendo de la entidad financiera.");
                    System.out.println("Generalmente, puede tomar entre 5 a 10 días hábiles.");
                }
                case 5 -> {
                    System.out.println("¿Puedo cancelar un préstamo antes del plazo establecido?");
                    System.out.println("Sí, la mayoría de las entidades permiten la cancelación anticipada,");
                    System.out.println("aunque pueden aplicarse comisiones o penalizaciones.");
                }
                case 6 -> {
                    System.out.println("¿Qué intereses se aplican a los préstamos?");
                    System.out.println("Las tasas de interés pueden variar según el tipo de préstamo,");
                    System.out.println("el monto solicitado y el perfil crediticio del solicitante.");
                }
                case 7 -> {
                    System.out.println("¿Cuáles son los requisitos para abrir una cuenta bancaria?");
                    System.out.println("Los requisitos típicos incluyen una identificación válida,");
                    System.out.println("comprobante de domicilio y un monto mínimo de apertura.");
                }
                case 8 -> {
                    System.out.println("¿Cómo puedo transferir dinero a otra cuenta?");
                    System.out.println("Puede transferir dinero a otra cuenta utilizando la banca en línea,");
                    System.out.println("una aplicación móvil o visitando una sucursal bancaria.");
                }
                case 9 -> {
                    System.out.println("¿Cuáles son los tipos de inversiones disponibles?");
                    System.out.println("Existen varios tipos de inversiones, como:");
                    System.out.println(" - Acciones: Comprar participaciones en empresas.");
                    System.out.println(" - Bonos: Préstamos que haces a empresas o gobiernos.");
                    System.out.println(" - Bienes raíces: Inversiones en propiedades.");
                    System.out.println(" - Fondos mutuos: Inversiones diversificadas en varios activos.");
                }
                case 10 -> System.out.println("Volviendo al Menú Principal...");
                default -> System.out.println("No se encontró ningún resultado. Intente nuevamente.");
            }
            // Pausa antes de volver a mostrar el menú, excepto si selecciona volver al menú principal
            if (opcionFAQs != 10) {
                System.out.println("");
                System.out.println("Presione cualquier tecla para volver al menú de FAQs.");
            }
        } while (opcionFAQs != 10);  // Repite hasta que seleccione la opción "Volver al Menú Principal"
    }
}

