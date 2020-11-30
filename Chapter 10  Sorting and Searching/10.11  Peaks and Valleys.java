void sortValleyPeak(int[] array) {
  for (int i = 1; i < array.length; i += 2) {
    int biggestIndex = maxIndex(array, i - 1, i, i + 1);
    if (i != biggestIndex) {
      swap(array, i, biggestIndex);
    }
  }
}

int maxIndex(int[] array, int a, int b, int c) {
  int len = array.length;
  int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
  int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
  int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;
  
  int max = Math.max(aValue, Math.max(bValue, cValue));
  if (aValue == max) return a;
  else if (bValue == max) return b;
  else return c;
}
