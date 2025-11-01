import minilang.lexing.Lexer;
import minilang.lexing.Token;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String expression = "2 + 3";

        List<Token> tokens = new Lexer().tokenize(expression);
        System.out.println("end");
    }
}