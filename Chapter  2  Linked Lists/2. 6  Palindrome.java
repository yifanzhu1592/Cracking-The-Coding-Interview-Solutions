boolean isPalindrome(LinkedListNode head) {
  LinkedListNode fast = head;
  LinkedListNode slow = head;
  
  Stack<Integer> stack = new Stack<Integer>();
  
  /* Push elements from first half of linked list onto stack. When fast runner
   * (which is moving at 2x speed) reaches the end of the linked list, then we
   * know we're at the middle */
  while (fast != null && fast.next != null) {
    stack.push(slow.data);
    slow = slow.next;
    fast = fast.next.next;
  }
  
  /* Has odd number of elements, so skip the middle element */
  if (fast != null) {
    slow = slow.next;
  }
  
  while (slow != null) {
    int top = stack.pop().intValue();
    
    /* If values are different, then it's not a palindrome */
    if (top != slow.data) {
      return false;
    }
    slow = slow.next;
  }
  return true;
}
