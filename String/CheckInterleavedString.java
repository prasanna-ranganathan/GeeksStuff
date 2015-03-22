import java.util.*;
import java.io.*;
import java.lang.*;

class CheckIneterleavedString {
  public static boolean checkInterleave(String s1,String s2,String s) {

    while(s != null) {
      if(s1.charAt(0) == s.charAt(0))
        s1 = s1.substring(1);

      else if(s2.charAt(0) == s.charAt(0))
        s2 = s2.substring(1);

      else
        return false;

      s = s.substring(1);
    }

    if(s1 != null || s2 != null)
      return false;

    return true;
  }

  private static boolean isInterleavingRecur(String a,String b,String c,int i,int j,int k) {
    
    if(i >= a.length() && j >= b.length() && k >= c.length())
      return true;

    boolean ret = false;
    
    if(i < a.length() && a.charAt(i) == c.charAt(k))
      ret |= isInterleavingRecur(a,b,c,i+1,j,k+1);
    
    if(!ret && b.length() > j && b.charAt(j) == c.charAt(k))
      ret |= isInterleavingRecur(a,b,c,i,j+1,k+1);

    return ret;
  }

  //Recursicve Method
  public static boolean isInterleaving(String a, String b,String c) {
    if(a.length() + b.length() != c.length())
      return false;
    return isInterleavingRecur(a,b,c,0,0,0);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s1 = br.readLine();
    String s2 = br.readLine();
    String s  = br.readLine();
    System.out.println(isInterleaving(s1,s2,s));
  }
}
