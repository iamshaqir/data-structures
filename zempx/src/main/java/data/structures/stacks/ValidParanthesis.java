package com.ms.data.structures.stacks;

public class ValidParanthesis {

    //()[]{}

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                stack.push(currentChar);
                continue;
            }

            if (!stack.isEmpty()) {
                char topChar = stack.peek();
                if (topChar == '(' && currentChar == ')' ||
                        topChar == '{' && currentChar == '}' ||
                        topChar == '[' && currentChar == ']') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
