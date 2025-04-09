package com.ms.data.structures.stacks;

import java.util.List;

public class TrappingRainWater {

    public static int trap(List<Integer> height) {
        int n = height.size(); // Number of elements in the height array
        int water = 0;         // Initialize the total trapped water volume
        Stack<Integer> stack = new Stack<>(); // Stack to store indices of height elements
        // Iterate through the heights
        for (int right = 0; right < n; right++) {
            // Process each height to trap water
            while (!stack.isEmpty() && height.get(stack.peek()) < height.get(right)) {
                // If the current height is greater than the height at the top of the stack
                int mid = stack.pop(); // Get the index of the height at the top of the stack
                // If the stack becomes empty, no more water can be trapped
                if (stack.isEmpty())
                    break;
                int left = stack.peek();                                                      // Get the index of the next height from the top of the stack
                int minHeight = Math.min(height.get(right) - height.get(mid), height.get(left) - height.get(mid)); // Calculate the minimum height of the two borders
                int width = right - left - 1;                                                 // Calculate the width between the left and right borders
                water += minHeight * width;                                                   // Calculate the trapped water volume and add it to the total
            }
            stack.push(right); // Push the current index onto the stack
        }
        return water; // Return the total trapped water volume
    }
}
