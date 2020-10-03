boolean isUniqueChars(String str) {
  int checker = 0;
  for (int i = 0; i < str.length(); i++) {
    int val = str.charAt(i) - 'a';
    if ((checker & (1 << val)) > 0) {
      returrn false;
    }
    checker |= (1 << val);
  }
  return true;
}
