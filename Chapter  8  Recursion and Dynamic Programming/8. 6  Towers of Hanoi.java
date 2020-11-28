class Tower {
  private Stack<Integer> disks = new Stack<Integer>();
  
  public void add(int d) {
    if (!disks.isEmpty() && disks.peek() <= d) {
      System.out.println("Error placing disk " + d);
    } else {
      disks.push(d);
    }
  }
  
  public void moveTopTo(Tower t) {
    int top = disks.pop();
    t.add(top);
  }
  
  public void moveDisks(int quantity, Tower destination, Tower buffer) {
    if (quantity <= 0) return;
    
    moveDisks(quantity - 1, buffer, destination);
    moveTopTo(destination);
    buffer.moveDisks(quantity - 1, destination, this);
  }
}
