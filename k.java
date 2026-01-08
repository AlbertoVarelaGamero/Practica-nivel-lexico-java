import java.util.Scanner;

// 1.a. Enumeración de Tipos con las 5 categorías clave [cite: 8]
enum TipoToken {
    PALABRA_CLAVE,
    IDENTIFICADOR,
    LITERAL_NUMERICO,
    OPERADOR,
    DELIMITADOR
}

// 1.b. Clase Token con atributos tipo y lexema [cite: 9, 10]
class Token {
    TipoToken tipo;
    String lexema;

    public Token(TipoToken tipo, String lexema) {
        this.tipo = tipo;
        this.lexema = lexema;
    }

    // Método para imprimir según el resultado esperado [cite: 32]
    @Override
    public String toString() {
        return "Token: <" + tipo + ", \"" + lexema + "\">";
    }
}

public class k {

    public static void main(String[] args) {
        // Se cambia 'sc' por 'entrada' para mayor claridad
        Scanner entrada = new Scanner(System.in);

        // 2.a. Solicitud de instrucciones al usuario 
        System.out.println("Introduce las instrucciones (separa todo con espacios):");
        String textoUsuario = entrada.nextLine();

        // Separación usando split() como indica la práctica 
        String[] partes = textoUsuario.split(" ");

        // 2.c. Array para guardar los objetos Token [cite: 30]
        Token[] listaTokens = new Token[partes.length];

        // Recorrer la lista de tokens de entrada [cite: 29]
        for (int i = 0; i < partes.length; i++) {
            String lexemaActual = partes[i];
            
            // Llamada a clasificarToken [cite: 29]
            TipoToken tipoEncontrado = clasificarToken(lexemaActual);
            
            // Crear el objeto e imprimirlo [cite: 29]
            listaTokens[i] = new Token(tipoEncontrado, lexemaActual);
            System.out.println(listaTokens[i]);
        }
    }

    // 2.b. Lógica de Clasificación usando if/else y equals [cite: 19, 22]
    public static TipoToken clasificarToken(String lexema) {
        
        // Palabras Clave: if, int [cite: 25]
        if (lexema.equals("if") || lexema.equals("int")) {
            return TipoToken.PALABRA_CLAVE;
        } 
        // Operadores y Delimitadores [cite: 27]
        else if (lexema.equals("+") || lexema.equals("=")) {
            return TipoToken.OPERADOR;
        } 
        else if (lexema.equals(";") || lexema.equals("(") || lexema.equals(")")) {
            return TipoToken.DELIMITADOR;
        } 
        // Literales Numéricos usando matches [cite: 27]
        else if (lexema.matches("[0-9]+")) {
            return TipoToken.LITERAL_NUMERICO;
        } 
        // Identificadores: Cláusula else final [cite: 28]
        else {
            return TipoToken.IDENTIFICADOR;
        }

        
    }
}