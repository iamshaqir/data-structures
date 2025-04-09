package com.ms.data.structures.stacks;

public class ReverseStack {


    public void reverse(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }
        int data = stack.pop();
        reverse(stack);
        pushAtBottom(data, stack);
    }

    private void pushAtBottom(int data, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int topData = stack.pop();
        pushAtBottom(data, stack);
        stack.push(topData);
    }
}
