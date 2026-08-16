class Solution {
    public double myPow(double x, int n) {
        long exp = n; // use long to handle Integer.MIN_VALUE
        
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        double result = 1.0;

        while (exp > 0) {
            // if exponent is odd
            if ((exp & 1) == 1) {
                result *= x;
            }

            x *= x;      // square the base
            exp >>= 1;   // divide exponent by 2
        }

        return result;
    }
}