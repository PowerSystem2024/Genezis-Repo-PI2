/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class homebanking {

    
    public static void main(String[] args) {
       // Crear una instancia de AliasCBU
        AliasCBU aliasCBU = new AliasCBU();

        // Generar un alias y un CBU y mostrarlos
        String aliasUnico = aliasCBU.generarAlias();
        String cbuUnico = aliasCBU.generarCBU();

        System.out.println("Alias generado: " + aliasUnico);
        System.out.println("CBU generado: " + cbuUnico);
    }

}
