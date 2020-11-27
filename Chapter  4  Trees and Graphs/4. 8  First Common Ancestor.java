TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
  /* Error check - one node is not in the tree. */
  if (!covers(root, p) || !covers(root, q)) {
    return null;
  }
  return ancestorHelper(root, p, q);
}

TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
  if (root == null || root == p || root == q) {
    return root;
  }
  
  boolean pIsOnLeft = covers(root.left, p);
  boolean qIsOnLeft = covers(root.left, q);
  if (pIsOnLeft != qIsOnLeft) { // Nodes are on different side
    return root;
  }
  TreeNode childSide = pIsOnLeft ? root.left : root.right;
  return ancestorHelper(childSide, p, q);
}

boolean covers(TreeNode root, TreeNode p) {
  if (root == null) return false;
  if (root == p) return true;
  return covers(root.left, p) || covers(root.right, p);
}
