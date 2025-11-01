package minilang.utils;

import java.util.Iterator;

public class StringIterator implements Iterator<Character> {
    public String s;
    public int index = 0;

    public StringIterator(String input) {
        this.s = input;
    }

    @Override
    public boolean hasNext() {
        return index != s.length();
    }

    @Override
    public Character next() {
        if(index >= s.length()){
            return null;
        }
        return s.charAt(index++);
    }
}
