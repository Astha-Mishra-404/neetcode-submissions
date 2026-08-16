class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int max = 0;

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {

                int h = heights[stack.pop()];

                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                max = Math.max(max, h * width);
            }

            stack.push(i);
        }

        // process remaining bars
        while (!stack.isEmpty()) {

            int h = heights[stack.pop()];

            int width;
            if (stack.isEmpty()) {
                width = n;
            } else {
                width = n - stack.peek() - 1;
            }

            max = Math.max(max, h * width);
        }

        return max;
    }
}
