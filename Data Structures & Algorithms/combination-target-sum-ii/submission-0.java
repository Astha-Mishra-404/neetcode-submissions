class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int target, int start, List<Integer> path) {

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            // skip duplicates on the same level
            if (i > start && nums[i] == nums[i - 1]) continue;

            // pruning
            if (nums[i] > target) break;

            path.add(nums[i]);

            // move to next index (each number can be used once)
            backtrack(nums, target - nums[i], i + 1, path);

            path.remove(path.size() - 1);
        }
    }
}