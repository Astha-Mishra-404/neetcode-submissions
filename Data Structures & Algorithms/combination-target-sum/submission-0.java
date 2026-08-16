class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, 0, target, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int i, int remain, List<Integer> cur) {

        // found a valid combination
        if (remain == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        // out of bounds or exceeded target
        if (i == nums.length || remain < 0) {
            return;
        }

        // choose nums[i]
        cur.add(nums[i]);
        dfs(nums, i, remain - nums[i], cur);   // stay at same index (reuse allowed)
        cur.remove(cur.size() - 1);

        // skip nums[i]
        dfs(nums, i + 1, remain, cur);
    }
}