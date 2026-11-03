
class Solution {
    public String largestGoodInteger(String num) {
        String res = "";

        // Check every substring of length 3
        for (int i = 0; i < num.length() - 2; i++) {

            // Check if all three digits are equal
            if (num.charAt(i) == num.charAt(i + 1) &&
                num.charAt(i + 1) == num.charAt(i + 2)) {

                String curr = num.substring(i, i + 3);

                // Keep the largest good integer
                if (res.isEmpty() || curr.compareTo(res) > 0) {
                    res = curr;
                }
            }
        }

        return res;
    }
}
