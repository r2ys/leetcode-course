package top.r2ys.leetcodecourse;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @program: leetcode-course
 * @description: 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @author: HU
 * @create: 2021-02-10 14:53
 */
public class Leet20 {

    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}'); put('[',']'); put('(',')'); put('?','?');
    }};
    private static final Map<Character, Character> pairs = new HashMap<Character, Character>() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Deque<Character> stack = new LinkedList<Character>();
        stack.push('1');
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<Character>() {{ add('?'); }};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.addLast(c);
            } else if (map.get(stack.removeLast()) != c) {
                return false;
            }
        }
        return stack.size() == 1;
    }

    public static void main(String[] args) {
        Leet20 leet20 = new Leet20();
        System.out.println(leet20.isValid("()"));
        System.out.println(leet20.isValid("()[]{}"));
        System.out.println(leet20.isValid("(]"));
        System.out.println(leet20.isValid("([)]"));
        System.out.println(leet20.isValid("{[]}"));
        System.out.println(leet20.isValid("{()[()]}"));
    }
}
