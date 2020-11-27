boolean containsTree(TreeNode t1, TreeNode t2) {
  if (t2 == null) return true; // The empty tree is always a subtree
  return subTree(t1, t2);
}

boolean subTree(TreeNode r1, TreeNode r2) {
  if (r1 == null) {
    return false; // big tree empty & subtree still not found.
  } else if (r1.data == r2.data && matchTree(r1, r2)) {
    return true;
  }
  return subTree(r1.left, r2) || subTree(r1.right, r2);
}

boolean matchTree(TreeNode r1, TreeNode r2) {
  if (r1 == null && r2 == null) {
    return true; // nothing left in the subtree
  } else if (r1 == null || r2 == null) {
    return false; // exactly one tree is empty, therefore trees don't match
  } else if (r1.data != r2.data) {
    return false; // data doesn't match
  } else {
    return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
  }
}
