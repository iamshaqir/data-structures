package com.ms.data.structures.stacks;

public class DuplicateParenthesis {

    public static boolean isDuplicate(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar != ')') {
                stack.push(currentChar);
                continue;
            }

            int count = 0;
            while (!stack.isEmpty() && stack.peek() != '(') {
                stack.pop();
                count++;
            }

            if (count < 1) {
                return true;
            } else {
                stack.pop();
            }
        }
        return false;
    }
}
