package headfirst.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author geyan
 * @date 2025/11/30
 */
public class Main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    List<TreeNode> ans = new ArrayList<>();

    /**
     * 前序遍历 递归
     */
    void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 前序遍历 非递归
     */
    List<TreeNode> preOrderTraversal(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return result;
    }

    /**
     * 中序遍历
     */
    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        ans.add(root);
        inOrder(root.right);
    }

    /**
     * 中序遍历 非递归
     * 左中右
     */
    List<TreeNode> inOrderTraversal(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            // 一直走到最左边
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 弹出栈顶 当前子树的根
            cur = stack.pop();
            result.add(cur);
            // 转向右子树
            cur = cur.right;
        }
        return result;
    }

    /**
     * 后序遍历
     */
    void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        ans.add(root);
    }

    /**
     * 后序遍历 非递归
     */
    List<TreeNode> postOrderTraversal(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode lastVisited = null;

        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right != null && peek.right != lastVisited) {
                    cur = peek.right;
                } else {
                    result.add(peek);
                    lastVisited = stack.pop();
                }
            }
        }
        return result;
    }
}
