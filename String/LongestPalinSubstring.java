import java.util.*;
import java.lang.*;
import java.io.*;

class LongestPalinSubstring {
  //Brute Force
  public static String longestpalin(String s) {

    int maxPalinlength = 0;
    String longestPalindrome = null;
    int length = s.length();

    for(int i = 0; i < length; i++) {
      for(int j = i + 1; j < length; j++) {
        int len = j - i;
        String curr = s.substring(i,j+1);
        if(isPalindrome(curr)) {
          if(len > maxPalinlength) {
            maxPalinlength = len;
            longestPalindrome = curr;
          }
        }
      }
    }
    return longestPalindrome;
  }

  private static boolean isPalindrome(String s) {
    for(int i = 0; i < s.length()-1; i++)
      if(s.charAt(i) != s.charAt(s.length() - i - 1))
        return false;
    return true;
  }
  //Using DP
  public static String longestpalindrome(String s) {
    int maxLen = 0;

    if(s == null)
      return null;

    if(s.length() <= 1)
      return s;

    String longestPalindrome = null;

    int N = s.length();

    int[][] table = new int[N][N];

    for(int i = 0; i < N; i++)
      table[i][i] = 1;

    PrintTable(table);

    //Two consective same letters are palindrome
    for(int i = 0; i < N - 2; i++) {
      if(s.charAt(i) == s.charAt(i+1)) {
        table[i][i+1] = 1;
        longestPalindrome = s.substring(i,i+2);
      }
    }

    PrintTable(table);
    //condition for calcuate whole table
    for(int l = 3; l <= N; l++) {
      for(int i = 0; i <= N - l; i++) {
        int j = i + l - 1;
        if(s.charAt(i) == s.charAt(j)) {
          table[i][j] = table[i+1][j-1];
          if(table[i][j] == 1 && l > maxLen) {
            longestPalindrome = s.substring(i,j+1);
          } else {
            table[i][j] = 0;
          }
          PrintTable(table);
        }
      }
    }
    return longestPalindrome;
  }

  public static void PrintTable(int[][] table) {
    for(int[] y : table) {
      for(int x : y) {
        System.out.print(x + " ");
      }
    System.out.println();
    }
    System.out.println("-------------");
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    System.out.println(longestpalin(s));
    System.out.println();
    System.out.println(longestpalindrome(s));
  }
}
