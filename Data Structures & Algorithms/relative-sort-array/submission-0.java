
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];

        // Count frequency of each element
        for (int num : arr1) {
            count[num]++;
        }

        int[] result = new int[arr1.length];
        int index = 0;

        // Add elements in the order of arr2
        for (int num : arr2) {
            while (count[num] > 0) {
                result[index++] = num;
                count[num]--;
            }
        }

        // Add remaining elements in ascending order
        for (int num = 0; num < count.length; num++) {
            while (count[num] > 0) {
                result[index++] = num;
                count[num]--;
            }
        }

        return result;
    }
}
