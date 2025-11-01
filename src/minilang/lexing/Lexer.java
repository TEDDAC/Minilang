package minilang.lexing;

import minilang.utils.StringIterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Lexer {
    public List<Token> tokenize(String input){
        List<Token> tokens = new LinkedList<>();
        Iterator<Character> it = new StringIterator(input);

        Character c = it.next();
        while(c != null){
            if (Character.isDigit(c)){
                StringBuilder value = new StringBuilder();
                while (c != null && Character.isDigit(c)){
                    value.append(c);
                    c = it.next();
                }
                tokens.add(new Token(TokenType.Number, value.toString()));
                // continue pour sauter le it.next() à la fin de la boucle. Et éviter de sauter des caractères.
                continue;
            }
            else if(isOperator(c)){
                tokens.add(new Token(TokenType.Operator, c.toString()));
            }
            else if(c == '(' || c == ')'){
                tokens.add(new Token(TokenType.Parenthesis, c.toString()));
            }

            c = it.next();
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
