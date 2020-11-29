int search(int[] a, int target) {
  return search(a, 0, a.length - 1, target);
}

int search(int[] a, int left, int right, int target) {
  if (right < left) return -1; // Not found
  
  int middle = (left + right) / 2;
  if (target == a[middle]) return middle; // Found
  
  if (a[left] < a[middle]) { // Left is normally ordered
    if (a[left] <= target && target < a[middle]) { // target is within left range
      return search(a, left, middle - 1, target); // search left
    } else {
      return search(a, middle + 1, right, target); // search right
    }
  } else if (a[middle] < a[right]) { // Right is normally ordered
    if (a[middle] < target && target <= a[right]) { // target is in right range
      return search(a, middle + 1, right, target); // search right
    } else {
      return search(a, left, middle - 1, target); // search left
    }
  } else {
    int location = -1;
    if (a[left] == a[middle]) {
      location = search(a, middle + 1, right, target); // search right
    }
    
    if (location == -1 && a[middle] == a[right]) {
      location = search(a, left, middle - 1, target); // search left
    }
    return location;
  }
}
