package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SameTree_100 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void isSameTree(TreeNode p, TreeNode q) {
        List<Integer> list1 = inorderTravel(p);
        List<Integer> list2 = inorderTravel(q);
        System.out.println(list1);
        System.out.println(list2);
//        if (list1.isEmpty() && list2.isEmpty()) {
//            return true;
//        }
//        if (list1.isEmpty() || list2.isEmpty()) {
//            return false;
//        }
//        for (int i = 0; i < list1.size(); i++) {
//            if (list1.get(i) != list2.get(i)) {
//                return false;
//            }
//        }
//        return true;
    }

    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
//            list.add(null);
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public static List<Integer> inorderTravel(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode();
        TreeNode q = new TreeNode(0);

//        System.out.println(isSameTree(p, q));
        isSameTree(p, q);
    }
}
