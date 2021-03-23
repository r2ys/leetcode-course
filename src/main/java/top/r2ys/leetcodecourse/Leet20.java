package top.r2ys.leetcodecourse;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @program: leetcode-course
 * @description: 有效的括号
 * 开括号入栈，遍历到闭括号，就做匹配、然后出栈
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @author: HU
 * @create: 2021-02-10 14:53
 */
public class Leet20 {

    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}'); put('[',']'); put('(',')');
    }};

    public boolean isValid(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) {
            return false;
        }
        Deque<Character> stack = new LinkedList<Character>() {{  }};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !c.equals(map.get(stack.peek()))) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Leet20 leet20 = new Leet20();
//        System.out.println(leet20.isValid("()"));
//        System.out.println(leet20.isValid("()[]{}"));
//        System.out.println(leet20.isValid("(]"));
        System.out.println(leet20.isValid("([)]"));
//        System.out.println(leet20.isValid("{[]}"));
//        System.out.println(leet20.isValid("{()[()]}"));
//        System.out.println(leet20.isValid("(){}}{"));
    }
}
