package minilang.lexing;

import minilang.utils.StringIterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Lexer {
    public List<Token> tokenize(String input){
        List<Token> tokens = new LinkedList<>();
        Iterator<Character> it = new StringIterator(input);

        while(it.hasNext()){
            Character c = it.next();

            if(isOperator(c)){
                tokens.add(new Token(TokenType.Operator, c.toString()));
            } else if (Character.isDigit(c)){
                StringBuilder value = new StringBuilder();
                while (Character.isDigit(c)){
                    value.append(c);
                    if(it.hasNext()){
                        c = it.next();
                    } else {
                        // Pour éviter les boucles infinies quand on arrive à la fin de la chaine.
                        break;
                    }
                }
                tokens.add(new Token(TokenType.Number, value.toString()));
            }
        }

        tokens.add(new Token(TokenType.End, "$"));

        return tokens;
    }

    private boolean isOperator(char c){
        return switch (c) {
            case '+', '-', '*', '/' -> true;
            default -> false;
        };
    }
}
