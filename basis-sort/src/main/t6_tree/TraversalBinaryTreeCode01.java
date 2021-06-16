package t6_tree;

/**
 * TraversalBinaryTreeCode01
 *
 * @author cmz
 * @date 2021-06-15 23:17
 */
public class TraversalBinaryTreeCode01 {


    //先序遍历： 根左右
    public static void pre(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        pre(head.left);
        pre(head.right);
    }

    // 中序遍历：左根右
    public static void in(TreeNode head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.println(head.val);
        in(head.right);
    }

    // 后序遍历：左右根
    public static void pos(TreeNode head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.val);

    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        pos(head);
        System.out.println("========");

    }


}
