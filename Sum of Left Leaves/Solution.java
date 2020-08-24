class Solution {
    //potpie solution on leetcode
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        System.out.println(s.sumOfLeftLeaves(treeNode));
    }
}