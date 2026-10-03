class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        // Map each number to its next greater element
        Map<Integer, Integer> map = new HashMap<>();
        
        // Monotonic decreasing stack
        Stack<Integer> stack = new Stack<>();

        // Find next greater element for every number in nums2
        for (int num : nums2) {
            
            // If current number is greater than stack top,
            // then current number is the next greater element
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            
            stack.push(num);
        }

        // Elements remaining in stack have no greater element
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Build answer for nums1
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}