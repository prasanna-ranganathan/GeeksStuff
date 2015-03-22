import java.io.*;
import java.lang.*;
import java.util.*;

class InterleavingString {
  private static void PrintUtilsRecur(String s1,String s2,String s) {

    if((s1 == null || s1.length() == 0) && (s2 == null || s2.length() == 0))
      return;

    if(s1 == null || s1.length() == 0) {
      System.out.print(" " + s + s2 + " ");
      return;
    }

    if(s2 == null || s2.length() == 0) {
      System.out.print(" " + s + s1 + " ");
      return;
    }

    PrintUtilsRecur(s1.substring(1),s2,s + s1.charAt(0));
    PrintUtilsRecur(s1,s2.substring(1),s + s2.charAt(0));
  }

  public static void PrintUtils(String s1,String s2) {
    PrintUtilsRecur(s1,s2,"");
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String a = br.readLine();
    String b = br.readLine();

    PrintUtils(a,b);
  }
}

