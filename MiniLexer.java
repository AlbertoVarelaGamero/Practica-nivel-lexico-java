import java.util.Scanner;

enum TipoToken{
    PALABRA_CLAVE,
    IDENTIFICADOR,
    LITERAL_NUMERICO,
    OPERADOR,
    DELIMITADOR

}

class Token {
    TipoToken tipo;
    String lexema;

    public Token(TipoToken tipo, String lexema){
        this.tipo = tipo;
        this.lexema = lexema;
    }
    @Override
    public String toString() { 
        return "Token: <" + tipo + ", \"" + lexema + "\">";
    }

}



public class MiniLexer {
    public static void main(String args []){
        Scanner entrada = new Scanner(System.in);


        System.out.println("Introduce el codigo , sepado todo con espacios. ");
        String TextoUsuario = entrada.nextLine();

        String [] partes = TextoUsuario.split(" ");

        Token [] listaTokens = new Token[partes.length];

        for (int i = 0; i < partes.length ; i++){
            String lexemaActual = partes[i];

            TipoToken tipoEncontrado = clasificarToken(lexemaActual);

            listaTokens[i] = new Token(tipoEncontrado, lexemaActual);
            System.out.println(listaTokens[i]);

            public static TipoToken clasificarToken(String lexema){
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
