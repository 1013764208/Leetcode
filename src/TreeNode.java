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
     * 构建二叉树
     * @param inputList 输入序列
     * @return  返回根节点
     */
    public TreeNode creatBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if (inputList ==null||inputList.isEmpty()){
            return null;
        }
        Integer data = inputList.removeFirst();     //去除并返回LinkedList中的第一个元素
        if (data!=null){
            node = new TreeNode(data);
            node.left=creatBinaryTree(inputList);
            node.right = creatBinaryTree(inputList);
        }
        return node;
    }
}

