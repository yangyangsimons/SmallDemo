import apple.laf.JRSUIUtils;

public class BST {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        node2.left = node4;
        node2.right = node5;
        System.out.println(findNode(node1,9));
        System.out.println(addNode(node1, 9));
        System.out.println(findNode(node1,9));
    }
    public static boolean findNode(TreeNode root, int value) {
        TreeNode node = root;
        while (node != null) {
            if (node.val == value) {
                return true;
            } else if (node.val > value) {
                // search left tree;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    public static boolean addNode(TreeNode root, int value) {
        TreeNode node = root;
        while (node != null) {
            if (node.val == value) {
                return false;
            } else if (node.val > value) {
                if (node.left == null) {
                    node.left = new TreeNode(value);
                    return true;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(value);
                    return true;
                }
                node = node.right;
            }
        }
        return false;
    }
}
