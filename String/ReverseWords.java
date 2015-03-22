import java.io.*;
import java.lang.*;
import java.util.*;
class ReverseWords {
  public static String reversewords(String s) {
    if(s == null || s.length() == 0)
      return "";

    String[] a = s.split(" ");
    StringBuilder str = new StringBuilder();
    for(int i = a.length-1; i >= 0; i--)
      if(!a[i].equals(""))
        str.append(a[i]).append(" ");
    return str.length() == 0 ? "" : str.substring(0,str.length());
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(reversewords(br.readLine()));
  }
}

