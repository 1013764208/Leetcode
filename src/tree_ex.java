import java.util.*;

public class tree_ex {


    public static void main(String[] args) {

        LinkedList<Integer> intputList = new LinkedList<>(Arrays.asList(new Integer[]{1, null, 2, 3}));
//        TreeNode binaryTree = new TreeNode().creatBinaryTree(intputList);

//        List<Integer> res = postorderTraversal(binaryTree);

//        List<Integer> res = inorderTraversal(binaryTree);


        // 对于层序 {3,9,20,null,null,15,7}
        LinkedList<Integer> inPut = new LinkedList<>(Arrays.asList(new Integer[]{3, 9, null, null, 20, 15, null, null, 7}));
        TreeNode binaryTree = new TreeNode().creatBinaryTree_preOrder(inPut);

        bfs(binaryTree);
        System.out.println(levelOrder(binaryTree));


//        System.out.println(inorderTraversal(binaryTree));
//        System.out.println(beforeOderTraversal(binaryTree));
//
//
//        System.out.println(maxDepth(binaryTree));


    }


    // 前序
    public static List<Integer> beforeOderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        beforeOrder(root, res);
        return res;
    }

    private static void beforeOrder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        beforeOrder(root.left, res);
        beforeOrder(root.right, res);
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
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
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


    // 找出二叉树的最大深度
    // 方法：使用深度优先遍历求 maxdeep
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);   // 递归求得左子树深度
            int rightHeight = maxDepth(root.right); // 递归求得左子树深度

            // 取其中最大值，加根节点
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


    // 广度优先遍历，使用队列
    public static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();       // 将队头元素弹出，并赋值给node
            System.out.print(node.val + " ");   // 输出弹出元素
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            res.add(list);
        }
        return res;
    }
}
