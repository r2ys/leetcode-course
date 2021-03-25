package top.r2ys.leetcodecourse;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode-course
 * @description:  基本计算器 II
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 * 迭代表达式字符:2+5*7-8/2
 * 人为认定第一个数字前面有个运算符+，表达式为：+2+5*7-8/2，缓存运算符+
 *
 * [i==0][element=2]
 * 遍历到数字2：缓存2，
 * 当前栈：[]
 *
 * [i==1][element=+]
 * 遍历到运算符+：+，因为缓存运算符是+，所以将2入栈，缓存当前运算符+
 * 当前栈：[2]
 *
 * [i==2][element=5]
 * 遍历数字5: 缓存5
 * 当前栈：[2]
 *
 * [i==3][element=*]
 * 遍历到运算符*
 * 因为缓存运算符是+，所以将5入栈，缓存当前运算符*
 * 当前栈：[2,5]
 *
 * [i==4][element=7]
 * 遍历数字7: 缓存7
 * 当前栈：[2,5]
 *
 * [i==5][element=-]
 * 遍历到运算符-：，因为缓存运算符是*，所以将5出栈，计算5*7，将35入栈，缓存当前运算符-
 * 当前栈：[2,35]
 *
 * [i==6][element=8]
 * 遍历数字8: 缓存8
 * 当前栈：[2,35]
 *
 * [i==7][element=÷]
 * 遍历到运算符÷：，因为缓存运算符是-，所以将8做负数入栈为-8，缓存当前运算符÷
 * 当前栈：[2,35,-8]
 *
 * [i==8][element=2]
 * 遍历数字2: 缓存2，
 * 因为是最后一个元素，需要运算，缓存运算符是÷，所以将-8出栈，计算-8*2，将-4入栈
 * 当前栈：[2,35,-4]
 *
 * 最终，将栈中的所有数字累加
 * (2)+(35)+(-4)
 *
 * @author: HU
 * @create: 2021-02-10 10:26
 */
public class Leet227 {

    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<Integer>();
        // 引入中间变量preSign的意义在于下次循环时使用
        char preSign = '+';
        // 引入中间变量num的意义在于下次循环时使用
        int num = 0;
        int n = s.length();
        // 迭代表达式字符
        for (int i = 0; i < n; ++i) {
            char ele = s.charAt(i);
            // 数字
            if (Character.isDigit(ele)) {
                num = num * 10 + ele - '0';
            }
            // 运算符
            // 如果是最后一个数字
            if (!Character.isDigit(ele) && ele != ' ' || i == n - 1) {
                // 上个循环的数字的前一个运算符
                switch (preSign) {
                    case '+':
                        // 上个循环的数字入栈
                        stack.push(num);
                        break;
                    case '-':
                        // 上个循环的数字入栈为负数
                        stack.push(-num);
                        break;
                    case '*':
                        // 上个循环的数字和栈顶的数字，做乘运算，结果入栈
                        // 如果是最后一个数字，将栈顶的数字和当前最后元素的数字，做乘运算，结果入栈
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        // 上个循环的数字和栈顶的数字，做除运算，结果入栈
                        // 如果是最后一个数字，将栈顶的数字和当前最后元素的数字，做除运算，结果入栈
                        stack.push(stack.pop() / num);
                }
                preSign = ele;
                num = 0;
            }
        }

        // 最终，将栈中的所有数字累加
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Leet227 leet227 = new Leet227();
        int result = leet227.calculate("2+5*7-8/2");
        System.out.println(result);
    }

}
