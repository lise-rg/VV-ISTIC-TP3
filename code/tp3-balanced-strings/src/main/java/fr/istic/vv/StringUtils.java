package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    protected StringUtils() {}

    public boolean isBalanced(String s) throws IllegalArgumentException{
        if(s != null) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '{' || c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
            return stack.isEmpty();
        }
        else {
            throw new IllegalArgumentException("Error, param s can't be null");
        }
    }
}
