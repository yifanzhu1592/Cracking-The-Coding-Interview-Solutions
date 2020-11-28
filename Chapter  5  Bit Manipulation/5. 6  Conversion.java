int bitSwapRequired(int a, int b) {
  int count = 0;
  int c = a ^ b;
  while (c != 0) {
    count += c & 1; // Increment count if c ends with a 1
    c >>>= 1; // Shift right by 1
  }
  return count;
}
