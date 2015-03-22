import java.util.*;
import java.io.*;

class PalindromeRotation {
  public static boolean StringRotation(String str) {
    int N = str.length();

    if(isPalindrome(str))
      return true;

   for(int i = 0; i < N; i++) {
     String left = str.substring(i);
     String right = str.substring(0,i);

     if(isPalindrome(left+right))
       return true;
   }

   return false;
  }

  public static boolean isPalindrome(String str) {
    int N = str.length();
    for(int i = 0; i <= N/2; i++) {
      if(str.charAt(i) != str.charAt(N-i-1))
        return false;
    }
    return true;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    System.out.println(StringRotation(s));
  }
}

