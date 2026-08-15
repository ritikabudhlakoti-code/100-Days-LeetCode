class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        helper(root, targetSum, path, ans);
        return ans;
    }

    private void helper(TreeNode root, int remaining,
                        List<Integer> path, List<List<Integer>> ans) {

        if (root == null) {
            return;
        }

        path.add(root.val);
        remaining = remaining - root.val;

        if (root.left == null && root.right == null) {
            if (remaining == 0) {
                ans.add(new ArrayList<>(path));
            }
        }

        helper(root.left, remaining, path, ans);
        helper(root.right, remaining, path, ans);

        path.remove(path.size() - 1);
    }
}
