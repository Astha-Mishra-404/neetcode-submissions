class Solution {
    public int countSeniors(String[] details) {
        int count = 0;

        for (String passenger : details) {
            // Age is stored at index 11 and 12
            int age = Integer.parseInt(passenger.substring(11, 13));

            if (age > 60) {
                count++;
            }
        }

        return count;
    }
}