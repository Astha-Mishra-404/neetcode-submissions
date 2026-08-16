class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (op.equals("+")) {
                int a = stack.pop();
                int b = stack.peek();

                stack.push(a);
                stack.push(a + b);

            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());

            } else if (op.equals("C")) {
                stack.pop();

            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}