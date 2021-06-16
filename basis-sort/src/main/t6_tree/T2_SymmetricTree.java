package t6_tree;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 *  
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cmz
 * @date 2021-06-15 23:50
 */
public class T2_SymmetricTree {


    public boolean isSymmetric(TreeNode root) {

        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode h1, TreeNode h2) {

        if (h1 == null ^ h2 == null) {
            return false;
        }

        if (h1 == null) {
            return true;
        }

        return h1.val == h2.val && isMirror(h1.left, h2.right) && isMirror(h1.right, h2.left);

    }


}
