
public class patternMatching {
  public static void main(String[] args) {
    String text = "AABAACAADAABAAABAA";
    String pattern = "AABA";
    System.out.println("Brute Force");
    //System.out.println("Pattern found at index: " + bruteForceMatch(text, pattern));
    //buildLast(pattern);
  }

  public static int bruteForceMatch(String text, String pattern) {
    int n = text.length();
    int m = pattern.length();
    for (int i = 0; i <= n - m; i++) {
      int j = 0;
      while (j < m && text.charAt(i + j) == pattern.charAt(j)) {
        j++;
      }
      if (j == m) {
        return i;
      }
    }
    return -1;
  }

  public static int boyerMooreMatch(String text, String pattern) {
    int n = text.length();
    int m = pattern.length();
    int[] last = buildLast(pattern);
    //Heuristic First
    int i = m - 1;
    if (i > n - 1) {
      return -1;
    }
    int j = m - 1;
    do {
      if (pattern.charAt(j) == text.charAt(i)) {
        //Match
        if (j == 0) {
          return i;
        } else {
          i--;
          j--;
        }
      // Heuristic Second
      } else {
        i = i + m - Math.min(j, 1 + last[text.charAt(i)]);
        j = m - 1;
      }
    } while (i <= n - 1);
    return -1;
  }

  public static int[] buildLast(String pattern) {
    int[] last = new int[256];
    for (int i = 0; i < 256; i++) {
      last[i] = -1;
    }
    printArray(last);
    for (int i = 0; i < pattern.length(); i++) {
      last[pattern.charAt(i)] = i;
    }
    printArray(last);
    return last;
  }

  public static void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }
}
