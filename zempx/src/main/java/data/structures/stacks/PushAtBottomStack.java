package com.ms.data.structures.stacks;

public class PushAtBottomStack {


    public void pushAtBottomBrute(int data, Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        stack.push(data);
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public void pushAtBottomBetter(int data, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int topData = stack.pop();
        pushAtBottomBetter(data, stack);
        stack.push(topData);
    }
}
