import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AliasCBU {
    // Listas de palabras base para la creación de alias
    private static final List<String> adjetivos = Arrays.asList("Rápido", "Rojo", "Lento", "Feliz", "Ágil");
    private static final List<String> sustantivos = Arrays.asList("León", "Águila", "Tigre", "Delfín", "Lobo");
    private static final List<String> verbos = Arrays.asList("Corre", "Vuela", "Nada", "Salta", "Caza");

    // Simulación de una "base de datos" en memoria para almacenar alias y CBUs generados
    private static List<String> aliasExistentes = new ArrayList<>();
    private static List<String> cbuExistentes = new ArrayList<>();

    // Generador de números aleatorios para alias y CBU
    private static final Random random = new Random();

    public static void aliasCBU(String[] args) {
        // Crear instancia de la clase para acceder a métodos de generación
        AliasCBU aliasCBU = new AliasCBU();
        
        // Generación de alias único y muestra en pantalla
        String alias = aliasCBU.generarAlias();
        System.out.println("Alias generado: " + alias);
        
        // Generación de CBU único y muestra en pantalla
        String cbu = aliasCBU.generarCBU();
        System.out.println("CBU generado: " + cbu);
        
        // Almacena el alias y el CBU generados en las listas de "existentes" (simulación de base de datos)
        aliasExistentes.add(alias);
        cbuExistentes.add(cbu);
    }

    // Método para generar un alias único en formato adjetivo.sustantivo.verbo
    public String generarAlias() {
        String alias = ""; // Inicialización del alias
        boolean esUnico = false;

        // Bucle que sigue generando hasta obtener un alias único
        while (!esUnico) {
            // Selección de palabras al azar de cada lista
            String palabra1 = adjetivos.get(random.nextInt(adjetivos.size()));
            String palabra2 = sustantivos.get(random.nextInt(sustantivos.size()));
            String palabra3 = verbos.get(random.nextInt(verbos.size()));
            
            // Formato del alias: adjetivo.sustantivo.verbo
            alias = palabra1 + "." + palabra2 + "." + palabra3;

            // Limita la longitud del alias a 20 caracteres, si es necesario
            if (alias.length() > 20) {
                alias = alias.substring(0, 20);
            }

            // Verifica que el alias no exista ya en la lista de alias existentes
            esUnico = !aliasExistentes.contains(alias);
        }
        return alias;
    }

    // Método para generar un CBU único de 22 dígitos
    public String generarCBU() {
        String cbu;

        // Bucle que sigue generando hasta obtener un CBU único
        do {
            StringBuilder cbuBuilder = new StringBuilder();
            
            // Genera 22 dígitos aleatorios y los agrega al CBU
            for (int i = 0; i < 22; i++) {
                cbuBuilder.append(random.nextInt(10)); // Añade un dígito aleatorio entre 0 y 9
            }
            
            cbu = cbuBuilder.toString();

        // Verifica que el CBU no exista ya en la lista de CBU existentes
        } while (cbuExistentes.contains(cbu)); // Repite si el CBU ya existe

        return cbu;
    }
}
