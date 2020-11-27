Integer lastPrinted = null;
boolean checkBST(TreeNode n) {
  if (n == null) return true;
  
  // Check / recurse left
  if (!checkBST(n.left)) return false;
  
  // Check current
  if (lastPrinted != null && n.data <= lastPrinted) {
    return false;
  }
  lastPrinted = n.data;
  
  // Check / recurse right
  if (!checkBST(n.right)) return false;
  
  return true; // All good!
}
