/* Toggle the ith bit in the integer. */
int toggle(int bitVector, int index) {
  if (index < 0) return bitVector;
  
  int mask = 1 << index;
  bitVector ^= mask;
  return bitVector;
}

/* Create bit vector for string. For each letter with value i,
 * toggle the ith bit. */
int createBitVector(String phrase) {
  int bitVector = 0;
  for (char c : phrase.toCharArray()) {
    int x = Common.getCharNumber(c);
    bitVector = toggle(bitVector, x);
  }
  return bitVector;
}

/* Check that at most one bit is set by subtracting one from the
 * integer and ANDing it with the original integer. */
boolean checkAtMostOneBitSet(int bitVector) {
  return (bitVector & (bitVector - 1)) == 0;
}

boolean isPermutationOfPalindrome(String phrase) {
  int bitVector = createBitVector(phrase);
  return checkAtMostOneBitSet(bitVector);
}
