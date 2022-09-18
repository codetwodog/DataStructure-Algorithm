package xin.twodog.algorithm.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * 记录孩子，并放入队列。
 * 出队列，同时记录孩子，并放入队列。
 *
 *
 * 1. 空的特殊判断下，返回空数组
 * 2. 用队列存节点
 * 3. 循环条件是队列里面节点为空
 * 4. poll 一个节点出来做两个操作，统计值，子节点入队。
 */
public class TreeProblem {
    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> treeNodes = new LinkedList<>();
        //Use the queue to store the parent node
        if (root == null) return new int[]{};
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            TreeNode treeNode = treeNodes.poll();
            list.add(treeNode.val);
            if (treeNode.left != null) treeNodes.add(treeNode.left);
            if (treeNode.right != null) treeNodes.add(treeNode.right);
        }
        int[] array = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}