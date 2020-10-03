boolean permutation(String s, String t) {
  if (s.length() != t.length()) return false; // Permutations must be same length
  
  int[] letters = new int[128]; // Assumption: ASCII
  for (int i = 0; i < s.length(); i++) {
    letters[s.charAt(i)]++;
  }
  
  for (int i = 0; i < t.length(); i++) {
    letters[t.charAt(i)]--;
    if (letters[t.charAt(i)] < 0) {
      return false;
    }
  }
  return true; // letters has no neg values, and therefore no pos values either
}
