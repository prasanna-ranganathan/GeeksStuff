import java.util.*;
import java.io.*;
import java.lang.*;

class PermutationLexicographic {
  public static void AllLexicographicRecur(String prefix,String str) {

    if(prefix.length() == str.length()) {
      System.out.println(prefix);
      return;
    }

    for(int i = 0; i < str.length(); i++)
      AllLexicographicRecur(prefix+str.charAt(i),str);
  }

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    System.out.println("-----------");
    AllLexicographicRecur("",str);
  }
}

