package Hw4_23001938_NguyenVanThang.practice.exercise4;

public class SumOfLeftLeaf {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {

          }
          TreeNode(int val) {
              this.val = val;
          }
          TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
          }
      }

    public boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        int count = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            count += (root.left).val;
        }
        count += sumOfLeftLeaves(root.left);
        count += sumOfLeftLeaves(root.right);
        return count;
    }
}
