import java.util.LinkedList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 构建二叉树（先序创建）
     */
    public TreeNode creatBinaryTree_preOrder(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();     //去除并返回LinkedList中的第一个元素
        if (data != null) {
            node = new TreeNode(data);  // 创建结点
            node.left = creatBinaryTree_preOrder(inputList);
            node.right = creatBinaryTree_preOrder(inputList);
        }
        return node;


    }

    // 层序创建二叉树（使用队列）
    public TreeNode creatBinaryTree_strata(LinkedList<Integer> inputList) {
        return null;
    }
}

