class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int ast : asteroids) {
            // Flag to track if the current asteroid survives
            boolean alive = true;
            
            // Collision condition: Top of stack is moving RIGHT (> 0) 
            // and current asteroid is moving LEFT (< 0)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                // If the top asteroid is smaller, it explodes. Current continues.
                if (stack.peek() < Math.abs(ast)) {
                    stack.pop();
                    continue; // Check against the next top element
                } 
                // If they are equal size, both explode.
                else if (stack.peek() == Math.abs(ast)) {
                    stack.pop();
                    alive = false;
                    break;
                } 
                // If top asteroid is bigger, current asteroid explodes.
                else {
                    alive = false;
                    break;
                }
            }
            
            // If the current asteroid survived all collisions, add it to stack
            if (alive) {
                stack.push(ast);
            }
        }
        
        // Convert the stack elements back into an array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}