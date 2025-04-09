package com.ms.data.structures.stacks;

public class StockSpanRealTime {

    int currentDayIdx;
    Stack<Pair> stack = new Stack<>();

    public StockSpanRealTime() {
        this.currentDayIdx = -1;
        stack.push(new Pair(-1, -1));
    }

    public int StockSpan(int next) {
        currentDayIdx = currentDayIdx + 1;
        while (!stack.isEmpty() && stack.peek().value <= next) {
            stack.pop();
        }
        int prevDayIdx = stack.isEmpty() ? -1 : stack.peek().index;
        stack.push(new Pair(currentDayIdx, next));
        return currentDayIdx - prevDayIdx;
    }

    private class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    Stack<int[]> stackInt = new Stack<>();
    public int stockSpanOpt(int price) {
        int result = 1;
        while (!stackInt.isEmpty() && stackInt.peek()[0] <= price) {
            result += stackInt.pop()[1];
        }
        stackInt.push(new int[]{price, result});
        return result;
    }
}
