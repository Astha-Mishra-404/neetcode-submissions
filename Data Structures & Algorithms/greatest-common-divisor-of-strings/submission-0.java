class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        // If concatenating in different orders gives different results,
        // there is no common divisor string.
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Find GCD of the two string lengths
        int gcdLength = gcd(str1.length(), str2.length());

        // Return the prefix of that length
        return str1.substring(0, gcdLength);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}