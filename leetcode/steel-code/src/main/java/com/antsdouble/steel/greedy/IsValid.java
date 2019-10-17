package com.antsdouble.steel.greedy;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author lyy
 * @Deprecated 有效的括号
 * @date 2019/10/17
 */
public class IsValid {
    private HashMap<Character, Character> mappings;

    public IsValid() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValidString(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }

}
