void merge(int[] a, int[] b, int countA, int countB) {
  int indexMerged = countB + countA - 1; /* Last location of merged array */
  int indexA = countA - 1; /* Last element in array b */
  int indexB = countB - 1; /* Last element in array a */
  
  /* Merge a and b, starting from the last element in each */
  while (indexB >= 0) {
    if (indexA >= 0 && a[indexA] > b[indexB]) { /* end of A > end of B */
      a[indexMerged] = a[indexA]; // copy element
      indexA--;
    } else {
      a[indexMerged] = b[indexB]; // copy element
      indexB--;
    }
    indexMerged--; // move indicies
  }
}
