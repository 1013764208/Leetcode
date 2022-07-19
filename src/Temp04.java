import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Temp04 {


    public static void main(String[] args) {

        LinkedList<Integer> intputList = new LinkedList<>(Arrays.asList(new Integer[]{1, null, 2, 3}));
        TreeNode binaryTree = new TreeNode().creatBinaryTree(intputList);

//        List<Integer> res = postorderTraversal(binaryTree);

        List<Integer> res = inorderTraversal(binaryTree);
        System.out.println(res);
    }


    /**
     * 后序遍历：左右根
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public static void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    /**
     * 中序遍历：左根右
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }

    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
