package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {
    class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }
}
