
class Solution {
    public List<String> commonChars(String[] words) {
            int[] common = new int[26];
                    Arrays.fill(common, Integer.MAX_VALUE);

                            // Find minimum frequency of each character
                                    for (String word : words) {
                                                int[] count = new int[26];

                                                            for (char c : word.toCharArray()) {
                                                                            count[c - 'a']++;
                                                                                        }

                                                                                                    for (int i = 0; i < 26; i++) {
                                                                                                                    common[i] = Math.min(common[i], count[i]);
                                                                                                                                }
                                                                                                                                        }

                                                                                                                                                // Build result
                                                                                                                                                        List<String> result = new ArrayList<>();

                                                                                                                                                                for (int i = 0; i < 26; i++) {
                                                                                                                                                                            while (common[i] > 0) {
                                                                                                                                                                                            result.add(String.valueOf((char) (i + 'a')));
                                                                                                                                                                                                            common[i]--;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                        return result;
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            