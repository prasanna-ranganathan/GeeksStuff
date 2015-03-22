import java.util.*;
import java.lang.*;
import java.io.*;

class LCSubstring {
  public static String lcsubstring(String s1,String s2) {
    if(s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty())
      return null;

    s1 = s1.toLowerCase();
    s2 = s2.toLowerCase();

    StringBuilder str = new StringBuilder();
    int[][] table = new int[s1.length()][s2.length()];
    int max = 0;
    int lastSublength = 0;

    for(int i = 0; i < s1.length(); i++) {
      for(int j = 0; j < s2.length(); j++) {
        if(s1.charAt(i) == s2.charAt(j)) {
          if((i == 0) || (j == 0))
            table[i][j] = 1;
          else
            table[i][j] = 1 + table[i-1][j-1];

          if(table[i][j] > max) {
            max = table[i][j];
            //Generate SubString from s1
            int thisSublength = i - table[i][j] + 1;
            if(lastSublength == thisSublength)
              str.append(s1.charAt(i));
            else {
              lastSublength = thisSublength;
              str = new StringBuilder();
              str.append(s1.substring(lastSublength,i+1));
            }
          }
        }
      }
    }
    return str.toString();
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s1 = br.readLine();
    String s2 = br.readLine();
    System.out.println(lcsubstring(s1,s2));
  }
}
