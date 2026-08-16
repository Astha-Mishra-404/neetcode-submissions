class Solution {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, nums);
        return res;
    }

    private void backtrack(int start, int[] nums) {
        res.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {

            // skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            subset.add(nums[i]);
            backtrack(i + 1, nums);
            subset.remove(subset.size() - 1);
        }
    }
}
