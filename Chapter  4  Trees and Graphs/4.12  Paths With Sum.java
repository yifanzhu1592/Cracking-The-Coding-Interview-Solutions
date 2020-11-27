int countPathsWithSum(TreeNode root, int targetSum) {
  if (root == null) return 0;
  
  /* Count paths with sum starting from the root. */
  int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
  
  /* Try the nodes on the left and right. */
  int pathsOnLeft = countPathsWithSum(root.left, targetSum);
  int pathsOnRight = countPathsWithSum(root.right, targetSum);
  
  return pathsFromRoot + pathsOnLeft + pathsOnRight;
}

/* Returns the number of paths with this sum starting from this node. */
int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
  if (node == null) return 0;
  
  currentSum += node.data;
  
  int totalPaths = 0;
  if (currentSum == targetSum) { // Found a path from the root
    totalPaths++;
  }
  
  totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum);
  totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum);
  return totalPaths;
}
