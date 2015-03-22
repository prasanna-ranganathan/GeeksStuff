import java.util.*;
import java.lang.*;
import java.io.*;

class LongestPalinSubstring2 {
  public static String longestpalin(String s) {
    if( s == null )
      return null;

    if(s.length() == 1)
      return s;

    String longest = s.substring(0,1);

    for(int i = 0; i < s.length(); i++) {
      //for like lalaciviclala
      String tmp = helper(s,i,i);
      if(tmp.length() > longest.length())
        longest = tmp;

      //For like forgeeksskeegfor
      tmp = helper(s,i,i+1);
      if(tmp.length() > longest.length())
        longest = tmp;
    }
    return longest;
  }

  public static String helper(String s,int begin,int end) {
    while(begin >= 0 && end <= s.length()-1 && s.charAt(begin) == s.charAt(end)) {
      begin--;
      end++;
    }

    return s.substring(begin + 1,end);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    System.out.println(longestpalin(s));
  }
}
