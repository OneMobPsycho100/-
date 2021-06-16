package t6_tree;

import java.util.HashMap;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author cmz
 * @date 2021-06-16 22:37
 */
public class T4_ConstructBinaryTreeFromPreorderAndInorderTraversal {


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int L1, int R1, int[] inorder, int L2, int R2) {
        if (L1 > R1) {
            return null;
        }

        /* 二叉树的头结点一定是先序遍历的第一个
         * 先中序遍历中找到头结点的位置就能确定二叉树的左右结构
         * 将中序遍历的值存入hash表方便查找
         */
        HashMap<Integer, Integer> in = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            in.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, in);
    }


    public TreeNode build(int[] preorder, int L1, int R1, int[] inorder, int L2, int R2, HashMap<Integer, Integer> in) {
        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = in.get(head.val);
        // 先序遍历的左树左边界
        // 因为不管是先序遍历还是中序遍历，左右树的节点数量是相同的，所以find-L2 就是左树节点的数量，L1+find-L2 就是先序遍历左边界
        head.left = build(preorder, L1 + 1, L1 + find - L2, inorder, L2, find - 1, in);
        head.right = build(preorder, L1 + find - L2 + 1, R1, inorder, find + 1, R2, in);
        return head;
    }


    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        T4_ConstructBinaryTreeFromPreorderAndInorderTraversal t4 = new T4_ConstructBinaryTreeFromPreorderAndInorderTraversal();
        System.out.println(t4.buildTree(preorder, inorder));
    }
}
