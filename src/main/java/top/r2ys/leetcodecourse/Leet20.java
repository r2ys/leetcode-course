package top.r2ys.leetcodecourse;

import java.util.HashMap;
import java.util.LinkedList;

public class Leet20 {

    public boolean isValid(String s) {
        HashMap<Character, Character> pairs = new HashMap<>();
        pairs.put('{', '}');
        pairs.put('(', ')');
        pairs.put('[', ']');
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character symbol = s.charAt(i);
            if (pairs.containsKey(symbol)) {
                stack.push(pairs.get(symbol));
            } else {
                if (stack.isEmpty() || !symbol.equals(stack.pop())) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Leet20 leet20 = new Leet20();
        System.out.println(leet20.isValid("{[]}"));
    }
}
