LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
  if (list1 == null || list2 == null) return null;
  
  /* Get tail and sizes. */
  Result result1 = getTailAndSize(list1);
  Result result2 = getTailAndSize(list2);
  
  /* If different tail nodes, then there's no intersection. */
  if (result1.tail != result2.tail) {
    return null;
  }
  
  /* Set pointers to the start of each linked list. */
  LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
  LinkedListNode longer = result1.size < result2.size ? list2 : list1;
  
  /* Advance the pointer for the longer linked list by difference in lengths. */
  longer = getKthNode(longer, Math.abs(result1.size - result2.size));
  
  /* Move both pointers until you have a collision. */
  while (shorter != longer) {
    shorter = shorter.next;
    longer = longer.next;
  }
  
  /* Return either one. */
  return longer;
}

Class Result {
  public LinkedListNode tail;
  public int size;
  public Result(LinkedListNode tail, int size) {
    this.tail = tail;
    this.size = size;
  }
}

Result getTailAndSize(LinkedListNode list) {
  if (list == null) return null;
  
  int size = 1;
  LinkedListNode current = list;
  while (current.next != null) {
    size++;
    current = current.next;
  }
  return new Result(current, size);
}

LinkedListNode getKthNode(LinkedListNode head, int k) {
  LinkedListNode current = head;
  while (k > 0 && current != null) {
    current = current.next;
    k--;
  }
  return current;
}
